package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseGeoPoint;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import johnkagga.me.celestini.Constants;
import johnkagga.me.celestini.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;

public class ClientContactInfoActivity extends AppCompatActivity {

    private static final String LOG_TAG = ClientContactInfoActivity.class.getSimpleName();
    private String clientId;

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPhoneNumber;
    private EditText mAltPhoneNumber;
    private EditText mDOB;
    private EditText mTribe;
    private EditText mOccupation;
    private EditText mVillage;
    private EditText mDistrict;
    private EditText mLatitude;
    private EditText mLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_contact_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeScreen();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.client_info_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                //Get the user input data
                final String firstName = mFirstName.getText().toString().trim();
                final String lastName = mLastName.getText().toString().trim();
                final String phoneNumber = mPhoneNumber.getText().toString().trim();
                final String altPhoneNumber = mAltPhoneNumber.getText().toString().trim();
                final String tribe = mTribe.getText().toString().trim();
                final String occupation = mOccupation.getText().toString().trim();
                final String village = mVillage.getText().toString().trim();
                final String district = mDistrict.getText().toString().trim();
                String lat = mLatitude.getText().toString().trim();
                String log = mLongitude.getText().toString().trim();
                //Formatting the date
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                Date dateOfBirth = new Date();
                String date_to_format = "";
                try {
                    date_to_format = mDOB.getText().toString().trim();
                    dateOfBirth = formatter.parse(date_to_format);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                final Date finalDateOfBirth = dateOfBirth;

                //Store the User input in the Parse LocalDataStore
                if (firstName.isEmpty() || lastName.isEmpty() || date_to_format.isEmpty()) {

                    Helper.alertDialog(ClientContactInfoActivity.this,
                            "Try Again", "Please enter the First and Last name and Date");
                } else {

                    final ClientContactInformation contactInformation = new ClientContactInformation();
                    contactInformation.setUuidString();
                    contactInformation.setFirstName(firstName);
                    contactInformation.setLastName(lastName);
                    contactInformation.setPhoneNumber(phoneNumber);
                    contactInformation.setAltPhoneNumber(altPhoneNumber);
                    contactInformation.setDateOfBirth(finalDateOfBirth);
                    contactInformation.setTribe(tribe);
                    contactInformation.setOccupation(occupation);
                    contactInformation.setVillage(village);
                    contactInformation.setDistrict(district);
                    if (lat.isEmpty() || log.isEmpty()) {
                        //latitude and Longitude not set
                        Log.v(LOG_TAG, "No Geopoints");
                    } else {
                        double latitude = Double.parseDouble(lat);
                        double longitude = Double.parseDouble(log);
                        ParseGeoPoint geoPoint = new ParseGeoPoint(latitude, longitude);
                        contactInformation.setGeoPoint(geoPoint);
                    }
                    contactInformation.setSync(false);
                    contactInformation.setCreatedBy(ParseUser.getCurrentUser());
                    //Pin in the Parse LocalDataStore
                    contactInformation.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
                        @Override
                        public void done(com.parse.ParseException e) {
                            if (e == null) {

                                //If no error get the Uuid
                                clientId = contactInformation.getUuidString();
                                Log.v(LOG_TAG, "clientId" + clientId);

                                Helper.makeToast(ClientContactInfoActivity.this,
                                        "Client Info saved successfully");

                                startHealthYNActivity();
                            } else {
                                Helper.makeToast(ClientContactInfoActivity.this,
                                        "Error saving the data try again");
                            }
                        }
                    });
                }


            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    /**
     * Start HealthYesNoActivity
     */
    private void startHealthYNActivity() {
        Intent intent = new Intent(ClientContactInfoActivity.this,
                HealthCheckQuestionsActivity.class);
        intent.putExtra(Constants.CLIENT_CONTACT_INFO_ID, clientId);
        startActivity(intent);
    }

    /**
     * Set the IDs of the views
     */
    private void initializeScreen() {
        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mPhoneNumber = (EditText) findViewById(R.id.phone_number);
        mAltPhoneNumber = (EditText) findViewById(R.id.alt_phone_number);
        mDOB = (EditText) findViewById(R.id.date_of_birth);
        mTribe = (EditText) findViewById(R.id.tribe);
        mOccupation = (EditText) findViewById(R.id.occupation);
        mVillage = (EditText) findViewById(R.id.village);
        mDistrict = (EditText) findViewById(R.id.district);
        mLatitude = (EditText) findViewById(R.id.latitude);
        mLongitude = (EditText) findViewById(R.id.longitude);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_client_contact_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:

                break;
            case R.id.action_sync:
                syncData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sync the data to Parse.com Or redirect to the Login Screen if
     * there is no ParseUser.
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
                    public void done(List<ClientContactInformation> data, com.parse.ParseException e) {
                        if (e == null) {
                            for (final ClientContactInformation info : data) {
                                //set the sync status to true before syncing to parse
                                info.setSync(true);
                                info.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(com.parse.ParseException e) {
                                        if (e == null) {
                                            //Saving is successful
                                            //Unpin from the local data store
                                            info.unpinInBackground(Constants.INFO_SAVE_LABEL);
                                            Helper.makeToast(ClientContactInfoActivity.this, "Sync successful");
                                        } else {
                                            //if saving fails set sync to false
                                            info.setSync(false);
                                            Log.e(LOG_TAG, "Error saving in background" + e.getMessage());
                                        }
                                    }
                                });
                            }
                        } else {
                            Helper.makeToast(ClientContactInfoActivity.this, "Error syncing: " + e.getMessage());
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
