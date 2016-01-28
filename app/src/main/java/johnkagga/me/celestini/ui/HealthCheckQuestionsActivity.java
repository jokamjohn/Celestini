package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.provider.newvisit.NewvisitContentValues;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;

public class HealthCheckQuestionsActivity extends AppCompatActivity {

    private static final String LOG_TAG = HealthCheckQuestionsActivity.class.getSimpleName();
    private static final String YES = "yes";
    private static final String NO = "no";
    private String uriString;
    private Uri mClientUri;

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

    @Bind(R.id.menstral_date)
    EditText mMensturalDate;

    ArrayList<String> mDiseases = null;
    ArrayList<String> mDrugs = null;
    ArrayList<String> mPreeclampia = null;

    private String otherDrugs;
    private String Headache;
    private String Epigastric;
    private String Nause;
    private String Fever;
    private String Vomiting;
    private String VisualDis;
    private String SisterPre;
    private String ChestPain;
    private String DiffInBreath;
    private String Vaginal;
    private String HyperDrugs;
    private String IronTabs;
    private String Diabetes;
    private String Folic;
    private String MotherPre;

    private NewvisitContentValues values;

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
        values = new NewvisitContentValues();

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

                //Add data to the local db
                values.putLastNormalMpDate(date_to_format)
                        .putPreeclampsiaFamilyHistory(mPreeclampia.toString());
                if (otherDrugs != null) {
                    values.putOtherDrugs(otherDrugs);
                }
                values.putChestPain(ChestPain)
                        .putHeadacheSymptome(Headache)
                        .putEpigastricPain(Epigastric)
                        .putNauseaAndVomiting(Nause)//TODO add nause and vomit
                        .putVisualDisturbance(VisualDis)
                        .putPreeclampsiaFamilyHistory(MotherPre)//TODO change mother n sister to PreceHis
                        .putDifficultyInBreathing(DiffInBreath)
                        .putVaginalBleeding(Vaginal)
                        .putHypertensionBeforePregnancy(HyperDrugs)
                        .putIronTablets(IronTabs)
                        .putDiabetesDrugs(Diabetes)
                        .putFolicAcidTablets(Folic);

                Intent intent = getIntent();
                if (intent != null && intent.hasExtra(Constants.CLIENT_URI)) {

                    uriString = intent.getStringExtra(Constants.CLIENT_URI);

                    mClientUri = Uri.parse(uriString);

                    Log.v(LOG_TAG, "Uri: " + mClientUri.toString());
                    //Number of rows updated
                    int rowsUpdated = 0;
                    rowsUpdated = HealthCheckQuestionsActivity.this
                            .getContentResolver()
                            .update(mClientUri, values.values(), null, null);
                    Log.v(LOG_TAG, "Number of rows updated" + rowsUpdated);

                    Helper.makeToast(HealthCheckQuestionsActivity.this, "Saved successfully");
                    startStructuredActivity();
                }
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
            otherDrugs = mOtherDrugs.getText().toString();
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
                    Headache = YES; //Add headache to the list
                    Log.v(LOG_TAG, "Added " + headache);
                } else {
                    Headache = NO; //Remove headache from the list
                    Log.v(LOG_TAG, "Removed " + headache);
                }
                break;

            case R.id.epigastric_cb:
                String epigastric = mEpigastric.getText().toString();
                if (checked) {
                    Epigastric = YES;
                } else {
                    Epigastric = NO;
                }
                break;

            case R.id.nausea_cb:
                String nausea = mNause.getText().toString();
                if (checked) {
                    Nause = YES;
                } else {
                    Nause = NO;
                }
                break;

            case R.id.fever_cb:
                String fever = mFever.getText().toString();
                if (checked) {
                    Fever = YES;
                } else {
                    Fever = NO;
                }
                break;

            case R.id.vomitin_cb:
                String vomit = mVomiting.getText().toString();
                if (checked) {
                    Vomiting = YES;
                } else {
                    Vomiting = NO;
                }
                break;

            case R.id.visual_disturbances_cb:
                String visual = mVisualDis.getText().toString();
                if (checked) {
                    VisualDis = YES;
                } else {
                    VisualDis = NO;
                }
                break;

            case R.id.chest_pain_cb:
                String chest = mChestPain.getText().toString();
                if (checked) {
                    ChestPain = YES;
                } else {
                    ChestPain = NO;
                }
                break;

            case R.id.diff_breathing_cb:
                String breath = mDiffInBreath.getText().toString();
                if (checked) {
                    DiffInBreath = YES;
                } else {
                    DiffInBreath = NO;
                }
                break;

            case R.id.vaginal_cb:
                String vaginal = mVaginal.getText().toString();
                if (checked) {
                    Vaginal = YES;
                } else {
                    Vaginal = NO;
                }
                break;
            //Setting the Drugs
            case R.id.hypertension_drugs_cb:
                String hyper = mHyperDrugs.getText().toString();
                if (checked) {
                    HyperDrugs = YES;
                } else {
                    HyperDrugs = NO;
                }
                break;

            case R.id.iron_tablets_cb:
                String iron = mIronTabs.getText().toString();
                if (checked) {
                    IronTabs = YES;
                } else {
                    IronTabs = NO;
                }
                break;

            case R.id.diabetes_drugs_cb:
                String diabetes = mDiabetes.getText().toString();
                if (checked) {
                    Diabetes = YES;
                } else {
                    Diabetes = NO;
                }
                break;

            case R.id.folic_acid_tablets_cb:
                String folic = mFolic.getText().toString();
                if (checked) {
                    Folic = YES;
                } else {
                    Folic = NO;
                }
                break;
            //Set preeclampsia
            case R.id.pre_mother_cb:
                String mother = mMotherPre.getText().toString();
                if (checked) {
                    MotherPre = YES;
                } else {
                    MotherPre = NO;
                }
                break;

            case R.id.pre_sisters_cb:
                String sisters = mSisterPre.getText().toString();
                if (checked) {
                    SisterPre = YES;
                } else {
                    SisterPre = NO;
                }
                break;
        }
    }

    /**
     * This method makes the intent to start the Structured Activity.
     */
    private void startStructuredActivity() {
        Intent structureIntent = new Intent(HealthCheckQuestionsActivity.this,
                StructuredQuestionsActivity.class);
        structureIntent.putExtra(Constants.CLIENT_URI, mClientUri.toString());
        startActivity(structureIntent);
    }

}
