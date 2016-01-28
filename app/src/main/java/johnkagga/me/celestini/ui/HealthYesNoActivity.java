package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.provider.newvisit.NewvisitContentValues;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;

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
    @Bind(R.id.gestation_options)
    RadioGroup mGestationOptions;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.multiple_gestation_yes)
    RadioButton mMultiple_yes;
    @Bind(R.id.twins)
    RadioButton mTwins;
    @Bind(R.id.triplets)
    RadioButton mTriplets;
    @Bind(R.id.other)
    RadioButton mOther;

    private RadioButton mHyperButton;
    private RadioButton mCesareanButton;
    private RadioButton mDiabeticButton;
    private RadioButton mChronicButton;
    private RadioButton mThyroidButton;
    private RadioButton mSickleButton;
    private RadioButton mHyperBefore;
    private RadioButton mGestationButton;
    private RadioButton mGestationOption;

    private NewvisitContentValues mValues;

    private String uriString;
    private Uri mClientUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_yes_no);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        //Initialize the Values
        mValues = new NewvisitContentValues();

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
            public void onClick(View v) {

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

                //Setting the gestation option.
                if (mTwins.isEnabled() || mTriplets.isEnabled() || mOther.isEnabled()) {

                    int optionId = mGestationOptions.getCheckedRadioButtonId();
                    mGestationOption = (RadioButton) findViewById(optionId);
                    String choice = mGestationOption.getText().toString();
                    Log.v(LOG_TAG, "Gestation choice: " + choice);

                    //TODO remove this section
                }

                //Getting the text from the selected options
                String hyperHistoryAns = mHyperButton.getText().toString();
                String cesareanAns = mCesareanButton.getText().toString();
                String diabeticsAns = mDiabeticButton.getText().toString();
                String chronicAns = mChronicButton.getText().toString();
                String thyroidAns = mThyroidButton.getText().toString();
                String sickleCellAns = mSickleButton.getText().toString();
                String hyperBeforeAns = mHyperBefore.getText().toString();
                String gestationAns = mGestationButton.getText().toString();

                //Save to local db.
                mValues.putHypertensionBeforePregnancy(hyperBeforeAns)
                        .putPreviousCaesarean(cesareanAns)
                        .putDiabeticBeforePregnancy(diabeticsAns)
                        .putChronicRenalDisease(chronicAns)
                        .putSickleCells(sickleCellAns)
                        .putThyroidDisease(thyroidAns)
                        .putHypertensionHistoryCocs(hyperHistoryAns)
                        .putMultipleGestation(gestationAns);

                Intent intent = getIntent();
                if (intent != null && intent.hasExtra(Constants.CLIENT_URI)) {
                    uriString = intent.getStringExtra(Constants.CLIENT_URI);
                    mClientUri = Uri.parse(uriString);

                    int rowsUpdated = 0;
                    rowsUpdated = HealthYesNoActivity.this.getContentResolver()
                            .update(mClientUri, mValues.values(), null, null);
                    Log.v(LOG_TAG, "YesNo updated rows " + rowsUpdated);
                    Helper.makeToast(HealthYesNoActivity.this, "Saved data");

                    startHealthYesNoActivity();
                }
            }
        });
    }

    /**
     * This method disables the Gestation Options
     *
     * @param view View
     */
    public void grayOutGestationOptions(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            mTwins.setEnabled(false);
            mTriplets.setEnabled(false);
            mOther.setEnabled(false);
        }
    }

    /**
     * This method makes an Intent to the Health Question Activity, it also sets
     * the intent extra to the uriString of the Client Information Activity
     * and also add Flags so that the user does not go back to the
     * previous activity but rather the Main Activity.
     */
    private void startHealthYesNoActivity() {
        Intent checkIntent = new Intent(HealthYesNoActivity.this, HealthCheckQuestionsActivity.class);
        checkIntent.putExtra(Constants.CLIENT_URI, uriString);
        startActivity(checkIntent);
    }

    public void setGestationOptions(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            mTwins.setEnabled(true);
            mTriplets.setEnabled(true);
            mOther.setEnabled(true);
        }
    }
}
