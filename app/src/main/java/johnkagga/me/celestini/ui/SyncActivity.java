package johnkagga.me.celestini.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.utilites.Constants;

public class SyncActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String LOG_TAG = SyncActivity.class.getSimpleName();
    @Bind(R.id.not_synced_listView)ListView mListView;

    List<ClientContactInformation> mInformationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mListView.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                    for (ClientContactInformation info : mInformationList){
                        clientNames[i] = info.getName();
                        i++;
                    }
                    //Make an adapter
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(SyncActivity.this,
                            android.R.layout.simple_list_item_1, clientNames);
                    mListView.setAdapter(adapter);
                } else {
                    //TODO There was a problem catch the exception.
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         String name = mInformationList.get(position).getUuidString();
        Log.v(LOG_TAG,"My name is: " + name);
    }
}
