package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

import johnkagga.me.celestini.Constants;
import johnkagga.me.celestini.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;

public class StructuredQuestionsActivity extends AppCompatActivity {

    private static final String LOG_TAG = StructuredQuestionsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structured_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_structured_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sync) {
            //Sync the data to Parse.com
            syncData();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sync the data to Parse.com
     */
    private void syncData() {
        if (Helper.isOnline(this)) {
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
                                            Helper.makeToast(StructuredQuestionsActivity.this, "Sync successful");
                                        } else {
                                            //if saving fails set sync to false
                                            info.setSync(false);
                                            Log.e(LOG_TAG, "Error saving in background" + e.getMessage());
                                        }
                                    }
                                });
                            }
                        } else {
                            Helper.makeToast(StructuredQuestionsActivity.this, "Error syncing: " + e.getMessage());
                        }

                    }
                });
            } else {
                //Redirect to the login activity
                Intent loginIntent = new Intent(this, LoginActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(loginIntent);
            }
        } else {
            //No network connection
            Helper.makeToast(this, "No internet connection");
        }
    }

}
