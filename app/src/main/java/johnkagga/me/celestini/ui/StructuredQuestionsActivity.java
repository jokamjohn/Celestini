package johnkagga.me.celestini.ui;

import android.content.Intent;
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
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.StructuredQuestions;

public class StructuredQuestionsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String LOG_TAG = StructuredQuestionsActivity.class.getSimpleName();
    private ClientContactInformation mContactInformation;
    private StructuredQuestions mStructuredQuestions;

    @Bind(R.id.number_preg_spinner)
    Spinner mSpinner;
    @Bind(R.id.infertility_edit_text)
    EditText mInFertility;
    @Bind(R.id.preg_outcome_edit_text)
    EditText mOutcome;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structured_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mStructuredQuestions = new StructuredQuestions();
        mContactInformation = new ClientContactInformation();

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
        mStructuredQuestions.setPegnanciesBefore(pregnancies);
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
        mStructuredQuestions.setPegnanciesBefore(0);
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

                mStructuredQuestions.setUuidString();
                mStructuredQuestions.setOutcome(outcome);
                mStructuredQuestions.setInfertility(inFertility);
                mStructuredQuestions.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //Save was successful
                            //Make the relation and redirect to the Main Activity
                            queryDataStoreSetRelationAndRedirect();
                        } else {
                            //An error occurred
                            // TODO Add AlertDialog informing the user to try again.
                        }
                    }
                });
            }
        });
    }

    /**
     * This method receives a Uuid of the Client Information from the incoming Intent
     * and queries for the object from the data store. After the Health Object
     * is saved into the Client Information Object as a Parse relation
     * Pointer.
     */
    private void queryDataStoreSetRelationAndRedirect() {
        final Intent intent = getIntent();

        if (intent != null && intent.hasExtra(Constants.CLIENT_CONTACT_INFO_ID)) {
            String clientId = intent.getStringExtra(Constants.CLIENT_CONTACT_INFO_ID);
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
                        mContactInformation.setStructuredHealthInformation(mStructuredQuestions);
                        Helper.makeToast(StructuredQuestionsActivity.this, "Saved Successfully and Process complete");
                        //TODO Redirect to the Sync Activity
                        Intent mainIntent = new Intent(StructuredQuestionsActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                    } else {
                        //There was a problem getting the object
                        //TODO Add a an AlertDialog that takes the user back to main activity.
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });
        } else {
            //TODO No clientId so redirect to Client Info Activity.
            Toast.makeText(StructuredQuestionsActivity.this,
                    "Error getting the Reference Client Object Uuid", Toast.LENGTH_LONG)
                    .show();
        }
    }

}
