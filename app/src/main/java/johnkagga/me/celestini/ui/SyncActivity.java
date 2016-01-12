package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.DividerItemDecoration;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.SyncAdapter;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;

public class SyncActivity extends AppCompatActivity {

    private static final String LOG_TAG = SyncActivity.class.getSimpleName();

    @Bind(R.id.not_synced_RecyclerView)
    RecyclerView mRecyclerView;

    private List<ClientContactInformation> mInformationList;
    private RecyclerView.ItemDecoration itemDecoration;
    private SyncAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        //Layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //Decorator
        itemDecoration = new DividerItemDecoration(this, R.drawable.line_divider);

        SetSyncFab();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void SetSyncFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                if (Helper.isOnline(SyncActivity.this)) {
                    if (ParseUser.getCurrentUser() != null) {
                        //If we have a user then sync the data
                        //Get the data from the LocalDataStore
                        ParseQuery<ClientContactInformation> query = ClientContactInformation.getQuery();
                        query.fromPin(Constants.INFO_SAVE_LABEL);
                        query.whereEqualTo(Constants.IS_SYNCED, false);
                        query.findInBackground(new FindCallback<ClientContactInformation>() {
                            @Override
                            public void done(List<ClientContactInformation> data, ParseException e) {
                                if (e == null) {
                                    for (final ClientContactInformation info : data) {
                                        //set the sync status to true before syncing to parse
                                        info.setSync(true);
                                        info.saveInBackground(new SaveCallback() {
                                            @Override
                                            public void done(ParseException e) {
                                                if (e == null) {
                                                    //Saving is successful
                                                    //Unpin from the local data store
                                                    info.unpinInBackground(Constants.INFO_SAVE_LABEL);
                                                    Snackbar.make(view, "Sync has been Successful", Snackbar.LENGTH_LONG)
                                                            .setAction("Action", null).show();
                                                    adapter.notifyDataSetChanged();
//                                                    Helper.makeToast(SyncActivity.this, "Sync successful");
                                                } else {
                                                    //if saving fails set sync to false
                                                    info.setSync(false);
                                                    Log.e(LOG_TAG, "Error saving in background" + e.getMessage());
                                                }
                                            }
                                        });
                                    }
                                } else {
                                    Helper.makeToast(SyncActivity.this, "Error syncing: " + e.getMessage());
                                }
                            }
                        });
                    } else {
                        //Redirect to the login activity
                        Intent loginIntent = new Intent(SyncActivity.this, LoginActivity.class);
                        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(loginIntent);
                    }
                } else {
                    //No network connection
                    Helper.makeToast(SyncActivity.this, "No internet connection");
                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ParseQuery<ClientContactInformation> query = ClientContactInformation.getQuery();
        query.fromPin(Constants.INFO_SAVE_LABEL);
        query.whereEqualTo(Constants.IS_SYNCED, false);
        query.findInBackground(new FindCallback<ClientContactInformation>() {
            @Override
            public void done(List<ClientContactInformation> clientInfoList, ParseException e) {
                if (e == null) {
                    mInformationList = clientInfoList;
                    int i = 0;
                    String[] clientNames = new String[mInformationList.size()];
                    for (ClientContactInformation info : mInformationList) {
                        clientNames[i] = info.getName();
                        i++;
                    }
                    //Make an adapter
                    adapter = new SyncAdapter(SyncActivity.this, mInformationList);
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.addItemDecoration(itemDecoration);

                } else {
                    //TODO There was a problem catch the exception.
                }
            }
        });

    }


}
