package johnkagga.me.celestini;

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

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentUser = ParseUser.getCurrentUser();

        if (currentUser == null) {
            startLoginActivity();
        }
        else {
            Log.i(LOG_TAG,currentUser.getUsername());
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

    private void ClientTestData() {
        final ClientContactInformation testObj = new ClientContactInformation();
        testObj.setFirstName("xawa");
        testObj.setDateOfBirth(new Date());
        testObj.setOccupation("builder");

        ParseGeoPoint location = new ParseGeoPoint(40.0,41.0);
        testObj.setGeoPoint(location);
        if (currentUser != null){
            testObj.setCreatedBy(currentUser);
        }
        testObj.saveEventually(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null)
                {
                    String objectId = testObj.getObjectId();
                    Log.i(LOG_TAG,objectId);
                }
            }
        });
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
                return true;
            case R.id.action_log_out:
                ParseUser.logOut();
                startLoginActivity();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
