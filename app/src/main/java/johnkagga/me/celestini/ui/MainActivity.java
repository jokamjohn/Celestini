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
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ParseUser currentUser;
    private Button mInitialVisit;
    protected Button mSubVisit;
    private Button mTasks;
    private Button mSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mInitialVisit = (Button) findViewById(R.id.initial_visit);
        mInitialVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClientContactInfoActivity.class);
                startActivity(intent);
            }
        });

        mSubVisit = (Button) findViewById(R.id.sub_visit);
        mSubVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mTasks = (Button) findViewById(R.id.tasks);
        mTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mSync = (Button) findViewById(R.id.sync);
        mSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SyncActivity.class);
                startActivity(intent);
            }
        });

        currentUser = ParseUser.getCurrentUser();

        if (currentUser == null) {
            startLoginActivity();
        } else {
            Log.i(LOG_TAG, currentUser.getUsername());
        }

        setFab();

    }

    /**
     * Start the Login Activity
     */
    private void startLoginActivity() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
    }

    private void setFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                break;

            case R.id.action_log_out:
                ParseUser.logOut();
                startLoginActivity();
                break;

            case R.id.action_sync:
                syncData();
                break;
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
                                            Helper.makeToast(MainActivity.this, "Sync successful");
                                        } else {
                                            //if saving fails set sync to false
                                            info.setSync(false);
                                            Log.e(LOG_TAG, "Error saving in background" + e.getMessage());
                                        }
                                    }
                                });
                            }
                        } else {
                            Helper.makeToast(MainActivity.this, "Error syncing: " + e.getMessage());
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
