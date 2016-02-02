package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import johnkagga.me.celestini.R;
import johnkagga.me.celestini.provider.newvisit.NewvisitColumns;
import johnkagga.me.celestini.provider.newvisit.NewvisitContentValues;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;

public class ClientContactInfoActivity extends AppCompatActivity {

    private static final String LOG_TAG = ClientContactInfoActivity.class.getSimpleName();

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPhoneNumber;
    private EditText mAltPhoneNumber;
    private EditText mDOB;
    private EditText mTribe;
    private EditText mOccupation;
    private EditText mVillage;
    private EditText mDistrict;

    private Uri mClientUri;

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

                UUID uuid = UUID.randomUUID();
                final String tag = uuid.toString();
                //Get the user input data
                final String firstName = mFirstName.getText().toString().trim();
                final String lastName = mLastName.getText().toString().trim();
                final String patientName = firstName + " " + lastName;
                final String phoneNumber = mPhoneNumber.getText().toString().trim();
                final String altPhoneNumber = mAltPhoneNumber.getText().toString().trim();
                final String tribe = mTribe.getText().toString().trim();
                final String occupation = mOccupation.getText().toString().trim();
                final String village = mVillage.getText().toString().trim();
                final String district = mDistrict.getText().toString().trim();

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

                    NewvisitContentValues values = new NewvisitContentValues();
                    values.putPatientName(patientName)
                            .putHomeDistrict(district)
                            .putDob(finalDateOfBirth)
                            .putTribe(tribe)
                            .putOccupation(occupation)
                            .putTown(village);

                    mClientUri = ClientContactInfoActivity.this
                            .getContentResolver()
                            .insert(NewvisitColumns.CONTENT_URI, values.values());


                    startHealthYNActivity();
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
                HealthYesNoActivity.class);
        intent.putExtra(Constants.CLIENT_URI,mClientUri.toString());
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
        }
        return super.onOptionsItemSelected(item);
    }

}
