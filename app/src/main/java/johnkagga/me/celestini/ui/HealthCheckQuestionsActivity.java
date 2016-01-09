package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.HealthCheckQuestions;

public class HealthCheckQuestionsActivity extends AppCompatActivity {

    private static final String LOG_TAG = HealthCheckQuestionsActivity.class.getSimpleName();
    private String clientId;
    private ClientContactInformation mContactInformation;
    private HealthCheckQuestions mHealthCheckQuestions;

    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.headache_cb)
    CheckBox mHeadache;
    @Bind(R.id.epigastric_cb)
    CheckBox mEpigastric;
    @Bind(R.id.nausea_cb)
    CheckBox mNause;
    @Bind(R.id.fever_cb)
    CheckBox mFever;
    @Bind(R.id.vomitin_cb)
    CheckBox mVomiting;
    @Bind(R.id.visual_disturbances_cb)
    CheckBox mVisualDis;
    @Bind(R.id.chest_pain_cb)
    CheckBox mChestPain;
    @Bind(R.id.diff_breathing_cb)
    CheckBox mDiffInBreath;
    @Bind(R.id.vaginal_cb)
    CheckBox mVaginal;

    @Bind(R.id.hypertension_drugs_cb)
    CheckBox mHyperDrugs;
    @Bind(R.id.iron_tablets_cb)
    CheckBox mIronTabs;
    @Bind(R.id.diabetes_drugs_cb)
    CheckBox mDiabetes;
    @Bind(R.id.folic_acid_tablets_cb)
    CheckBox mFolic;
    @Bind(R.id.other_drugs_cb)
    CheckBox mOtherCb;
    @Bind(R.id.yes_others_cb)
    EditText mOtherDrugs;

    @Bind(R.id.pre_mother_cb)
    CheckBox mMotherPre;
    @Bind(R.id.pre_sisters_cb)
    CheckBox mSisterPre;

    @Bind(R.id.menstral_date)EditText mMensturalDate;

    ArrayList<String> mDiseases = null;
    ArrayList<String> mDrugs = null;
    ArrayList<String> mPreeclampia = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_check_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mDiseases = new ArrayList<>();
        mDrugs = new ArrayList<>();
        mPreeclampia = new ArrayList<>();

        saveDataInLocalDataStore();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * This method saves the user input into the HealthCheckQuestion object
     * and then in the Parse LocalDataStore.
     */
    private void saveDataInLocalDataStore() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHealthCheckQuestions = new HealthCheckQuestions();

                //Formatting the date
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                Date mensurationDate = new Date();
                String date_to_format = "";
                try {
                    date_to_format = mMensturalDate.getText().toString().trim();
                    mensurationDate = formatter.parse(date_to_format);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }

                mHealthCheckQuestions.setUuidString();
                mHealthCheckQuestions.setDiseases(mDiseases);
                mHealthCheckQuestions.setDrugs(mDrugs);
                mHealthCheckQuestions.setPreeclampsia(mPreeclampia);
                mHealthCheckQuestions.setMensurationDate(mensurationDate);
                mHealthCheckQuestions.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //Save was successful
                            //Query for Client information object and add
                            //the mHealthCheckQuestions object.
                            queryDataStoreAndSetRelation();
                        } else {
                            //Error occurred while saving
                            Helper.makeToast(HealthCheckQuestionsActivity.this,
                                    "An error occurred while saving HCQs");
                        }
                    }
                });
            }
        });
    }

    /**
     * This method listens for the click events on the Other Drugs question.
     * It enables the other editText when its checked and disables
     * when it is unchecked.
     *
     * @param view Check Box
     */
    public void otherCheckBoxClicked(View view) {
        if (mOtherCb.isChecked()) {
            mOtherDrugs.setEnabled(true);
        } else {
            mOtherDrugs.setEnabled(false);
        }
    }

    /**
     * This method listens for click events on the check boxes.
     * And adds or removes data from the ArrayLists.
     *
     * @param view
     */
    public void setCheckedChoice(View view) {
        //Is the view checked
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.headache_cb:
                String headache = mHeadache.getText().toString();
                if (checked) {
                    mDiseases.add(headache); //Add headache to the list
                    Log.v(LOG_TAG, "Added " + headache);
                } else {
                    mDiseases.remove(headache); //Remove headache from the list
                    Log.v(LOG_TAG, "Removed " + headache);
                }
                break;

            case R.id.epigastric_cb:
                String epigastric = mEpigastric.getText().toString();
                if (checked) {
                    mDiseases.add(epigastric);
                } else {
                    mDiseases.remove(epigastric);
                }
                break;

            case R.id.nausea_cb:
                String nausea = mNause.getText().toString();
                if (checked) {
                    mDiseases.add(nausea);
                } else {
                    mDiseases.remove(nausea);
                }
                break;

            case R.id.fever_cb:
                String fever = mFever.getText().toString();
                if (checked) {
                    mDiseases.add(fever);
                } else {
                    mDiseases.remove(fever);
                }
                break;

            case R.id.vomitin_cb:
                String vomit = mVomiting.getText().toString();
                if (checked) {
                    mDiseases.add(vomit);
                } else {
                    mDiseases.remove(vomit);
                }
                break;

            case R.id.visual_disturbances_cb:
                String visual = mVisualDis.getText().toString();
                if (checked) {
                    mDiseases.add(visual);
                } else {
                    mDiseases.remove(visual);
                }
                break;

            case R.id.chest_pain_cb:
                String chest = mChestPain.getText().toString();
                if (checked) {
                    mDiseases.add(chest);
                } else {
                    mDiseases.remove(chest);
                }
                break;

            case R.id.diff_breathing_cb:
                String breath = mDiffInBreath.getText().toString();
                if (checked) {
                    mDiseases.add(breath);
                } else {
                    mDiseases.remove(breath);
                }
                break;

            case R.id.vaginal_cb:
                String vaginal = mVaginal.getText().toString();
                if (checked) {
                    mDiseases.add(vaginal);
                } else {
                    mDiseases.remove(vaginal);
                }
                break;
            //Setting the Drugs
            case R.id.hypertension_drugs_cb:
                String hyper = mHyperDrugs.getText().toString();
                if (checked) {
                    mDrugs.add(hyper);
                } else {
                    mDrugs.remove(hyper);
                }
                break;

            case R.id.iron_tablets_cb:
                String iron = mIronTabs.getText().toString();
                if (checked) {
                    mDrugs.add(iron);
                } else {
                    mDrugs.remove(iron);
                }
                break;

            case R.id.diabetes_drugs_cb:
                String diabetes = mDiabetes.getText().toString();
                if (checked) {
                    mDrugs.add(diabetes);
                } else {
                    mDrugs.remove(diabetes);
                }
                break;

            case R.id.folic_acid_tablets_cb:
                String folic = mFolic.getText().toString();
                if (checked) {
                    mDrugs.add(folic);
                } else {
                    mDrugs.remove(folic);
                }
                break;
            //Set preeclampsia
            case R.id.pre_mother_cb:
                String mother = mMotherPre.getText().toString();
                if (checked) {
                    mPreeclampia.add(mother);
                } else {
                    mPreeclampia.remove(mother);
                }
                break;

            case R.id.pre_sisters_cb:
                String sisters = mSisterPre.getText().toString();
                if (checked) {
                    mPreeclampia.add(sisters);
                } else {
                    mPreeclampia.remove(sisters);
                }
                break;
        }
    }

    /**
     * This method receives a Uuid of the Client Information from the incoming Intent
     * and queries for the object from the data store. After the Health Object
     * is saved into the Client Information Object as a Parse relation
     * Pointer.
     */
    private void queryDataStoreAndSetRelation() {
        final Intent intent = getIntent();

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
                        mContactInformation.setHealthCheckInformation(mHealthCheckQuestions);
                        //start the structured activity
                        startStructuredActivity();
                    } else {
                        //There was a problem getting the object
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });
        } else {
            Toast.makeText(HealthCheckQuestionsActivity.this,
                    "Error getting the Reference Client Object Uuid", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * This method makes the intent to start the Structured Activity.
     */
    private void startStructuredActivity() {
        Intent structureIntent = new Intent(HealthCheckQuestionsActivity.this,
                StructuredQuestionsActivity.class);
        structureIntent.putExtra(Constants.CLIENT_CONTACT_INFO_ID, clientId);
        startActivity(structureIntent);
    }

}
