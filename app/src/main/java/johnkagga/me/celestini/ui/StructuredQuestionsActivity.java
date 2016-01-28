package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.provider.newvisit.NewvisitContentValues;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;

public class StructuredQuestionsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String LOG_TAG = StructuredQuestionsActivity.class.getSimpleName();

    @Bind(R.id.number_preg_spinner)
    Spinner mSpinner;
    @Bind(R.id.infertility_edit_text)
    EditText mInFertility;
    @Bind(R.id.preg_outcome_edit_text)
    EditText mOutcome;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private String uriString;
    private Uri mClientUri;

    private ArrayAdapter<String> adapter;
    private NewvisitContentValues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structured_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        values = new NewvisitContentValues();

        setUpTheSpinner();

        getAndSaveData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * This method setups the spinner in the onCreate method and also set an adapter
     * to the spinner.
     */
    private void setUpTheSpinner() {
        String[] times = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, times);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(this);
    }

    /**
     * This method gets the string at the position clicked by the user in
     * the spinner and parse into an int. And finally saves it to
     * the StructuredQuestion object.
     *
     * @param parent   AdapterView
     * @param view     View
     * @param position Item clicked
     * @param id       Id of item clicked
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Get the value of the selected item from the spinner
        String selectedStr = (String) parent.getItemAtPosition(position);
        int pregnancies = Integer.parseInt(selectedStr);
        values.putParityNoOfPregnancies(pregnancies);
        Log.v(LOG_TAG, "Selected: " + selectedStr);
    }

    /**
     * This method enables us to save zero pregnancies when nothing is
     * selected in the spinner.
     *
     * @param parent AdapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //If nothing is selected set the value to zero
        values.putParityNoOfPregnancies(0);
    }

    /**
     * This method saves the user input into the StructuredQuestion object
     * and then in the Parse LocalDataStore.
     */
    private void getAndSaveData() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String outcome = mOutcome.getText().toString();
                String inFertility = mInFertility.getText().toString();

                values.putPregnancyOutcome(outcome);
                values.putInfertilityTreatmentHistory(inFertility);

                Intent intent = getIntent();
                if (intent != null && intent.hasExtra(Constants.CLIENT_URI)) {
                    uriString = intent.getStringExtra(Constants.CLIENT_URI);

                    mClientUri = Uri.parse(uriString);
                    int rowsUpdated = 0;
                    rowsUpdated = StructuredQuestionsActivity.this
                            .getContentResolver()
                            .update(mClientUri, values.values(), null, null);

                    Log.v(LOG_TAG, "Structured Updated rows: " + rowsUpdated);

                    Helper.makeToast(StructuredQuestionsActivity.this,"Data saved");
                    startMainActivity();
                }
            }

        });
    }

    /**
     * Start main activity.
     */
    private void startMainActivity() {
        Intent mainIntent = new Intent(StructuredQuestionsActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }


}
