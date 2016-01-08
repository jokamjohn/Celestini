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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.Constants;
import johnkagga.me.celestini.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.HealthYesNoQuestions;

public class HealthYesNoActivity extends AppCompatActivity {

    private static final String LOG_TAG = HealthYesNoActivity.class.getSimpleName();

    @Bind(R.id.hyper_history_group)
    RadioGroup mHyperHistoryGroup;
    @Bind(R.id.cesarean_group)
    RadioGroup mCesareanGroup;
    @Bind(R.id.diabetic_group)
    RadioGroup mDiabeticGroup;
    @Bind(R.id.chronic_group)
    RadioGroup mChronicRenalGroup;
    @Bind(R.id.thyroid_group)
    RadioGroup mThyroidGroup;
    @Bind(R.id.sickle_cell_group)
    RadioGroup mSickleCellGroup;
    @Bind(R.id.hypertensive_before_preg_group)
    RadioGroup mHyperBeforePreg;
    @Bind(R.id.multiple_gestationgroup)
    RadioGroup mGestationGroup;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private RadioButton mHyperButton;
    private RadioButton mCesareanButton;
    private RadioButton mDiabeticButton;
    private RadioButton mChronicButton;
    private RadioButton mThyroidButton;
    private RadioButton mSickleButton;
    private RadioButton mHyperBefore;
    private RadioButton mGestationButton;

    private HealthYesNoQuestions mHealthYesNoQuestions;
    private ClientContactInformation mContactInformation;

    private String clientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_yes_no);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        setTheFab();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * This method gets the id of the selected RadioButton, then gets the text
     * associated with it and finally saves the data into the Health
     * Question Object.
     */
    private void setTheFab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the id of the selected radio button from the Radio Group
                //find the radio button by the selected id
                int hyperHistoryId = mHyperHistoryGroup.getCheckedRadioButtonId();
                mHyperButton = (RadioButton) findViewById(hyperHistoryId);

                int cesareanId = mCesareanGroup.getCheckedRadioButtonId();
                mCesareanButton = (RadioButton) findViewById(cesareanId);

                int diabeticId = mDiabeticGroup.getCheckedRadioButtonId();
                mDiabeticButton = (RadioButton) findViewById(diabeticId);

                int chronicId = mChronicRenalGroup.getCheckedRadioButtonId();
                mChronicButton = (RadioButton) findViewById(chronicId);

                int thyriodId = mThyroidGroup.getCheckedRadioButtonId();
                mThyroidButton = (RadioButton) findViewById(thyriodId);

                int sickleId = mSickleCellGroup.getCheckedRadioButtonId();
                mSickleButton = (RadioButton) findViewById(sickleId);

                int hyperBeforeId = mHyperBeforePreg.getCheckedRadioButtonId();
                mHyperBefore = (RadioButton) findViewById(hyperBeforeId);

                int gestationId = mGestationGroup.getCheckedRadioButtonId();
                mGestationButton = (RadioButton) findViewById(gestationId);

                //Getting the text from the selected options
                String hyperHistoryAns = mHyperButton.getText().toString();
                String cesareanAns = mCesareanButton.getText().toString();
                String diabeticsAns = mDiabeticButton.getText().toString();
                String chronicAns = mChronicButton.getText().toString();
                String thyroidAns = mThyroidButton.getText().toString();
                String sickleCellAns = mSickleButton.getText().toString();
                String hyperBeforeAns = mHyperBefore.getText().toString();
                String gestationAns = mGestationButton.getText().toString();

                //Save the Parse object
                mHealthYesNoQuestions = new HealthYesNoQuestions();
                mHealthYesNoQuestions.setUuidString();
                mHealthYesNoQuestions.setHistoryHypertension(hyperHistoryAns);
                mHealthYesNoQuestions.setCesarean(cesareanAns);
                mHealthYesNoQuestions.setDiabetic(diabeticsAns);
                mHealthYesNoQuestions.setChronicRenal(chronicAns);
                mHealthYesNoQuestions.setThyroid(thyroidAns);
                mHealthYesNoQuestions.setSickleCell(sickleCellAns);
                mHealthYesNoQuestions.setHypertensive(hyperBeforeAns);
                mHealthYesNoQuestions.setMultipleGestation(gestationAns);

                mHealthYesNoQuestions.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //Saving was successful
                            getIntentAndSetHealthInfo();
                        } else {
                            //There was a problem saving
                        }
                    }
                });

                Helper.makeToast(HealthYesNoActivity.this, mHyperButton.getText().toString());
            }
        });
    }

    /**
     * This method receives a Uuid of the Client Information from the incoming Intent
     * and queries for the object from the data store. After the Health Object
     * is saved into the Client Information Object as a Parse relation
     * Pointer.
     */
    private void getIntentAndSetHealthInfo() {
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(Constants.CLIENT_CONTACT_INFO_ID)) {
            clientId = intent.getStringExtra(Constants.CLIENT_CONTACT_INFO_ID);
            Log.v(LOG_TAG, "Client Id: " + clientId);
            //Query for the ClientInformation Object and save the Health Object to it.
            ParseQuery<ClientContactInformation> query = ClientContactInformation.getQuery();
            query.fromLocalDatastore();
            query.whereEqualTo(Constants.UUID_FIELD, clientId);
            query.getFirstInBackground(new GetCallback<ClientContactInformation>() {
                @Override
                public void done(ClientContactInformation clientInfo, ParseException e) {
                    if (e == null) {
                        //Attach the Health Object to the returned Client Object
                        //and start an intent when done.
                        mContactInformation = clientInfo;
                        mContactInformation.setHealthInfo(mHealthYesNoQuestions);
                        startHealthYesNoActivity();
                    } else {
                        //There was a problem getting the object
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });
        } else {
            Toast.makeText(HealthYesNoActivity.this,
                    "Error getting the Reference Client Object Uuid", Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_health_yes_no, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sync) {
            syncData();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method queries for all the data saved in the Parse LocalDataStore
     * for all the objects pinned with Constants.INFO_SAVE_LABEL. And
     * then saves the data to Parse.com and unpins the data.
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
                                            Helper.makeToast(HealthYesNoActivity.this, "Sync successful");
                                        } else {
                                            //if saving fails set sync to false
                                            info.setSync(false);
                                            Log.e(LOG_TAG, "Error saving in background" + e.getMessage());
                                        }
                                    }
                                });
                            }
                        } else {
                            Helper.makeToast(HealthYesNoActivity.this, "Error syncing: " + e.getMessage());
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

    /**
     * This method makes an Intent to the Health Question Activity, it also sets
     * the intent extra to the clientId of the Client Information Activity
     * and also add Flags so that the user does not go back to the
     * previous activity but rather the Main Activity.
     */
    private void startHealthYesNoActivity() {
        Intent checkIntent = new Intent(this, HealthCheckQuestionsActivity.class);
        checkIntent.putExtra(Constants.CLIENT_CONTACT_INFO_ID, clientId);
        checkIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        checkIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(checkIntent);
    }
}
