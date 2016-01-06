package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import johnkagga.me.celestini.Constants;
import johnkagga.me.celestini.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.HealthYesNoQuestions;

/**
 * A placeholder fragment containing a simple view.
 */
public class HealthYesNoActivityFragment extends Fragment {

    private static final String LOG_TAG = HealthYesNoActivityFragment.class.getSimpleName();
    private String clientId;
    private ClientContactInformation mContactInformation;
    private HealthYesNoQuestions mHealthYesNoQuestions;

    public HealthYesNoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_health_yes_no, container, false);

        Button button = (Button) rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testHealthInfo();

            }
        });

        return rootView;
    }

    /**
     * Get the Client contact information Uuid
     * and set the Health information
     */
    private void getIntentAndSetHealthInfo() {
        Intent intent = getActivity().getIntent();

        if (intent != null && intent.hasExtra(Constants.CLIENT_CONTACT_INFO_ID)) {
            String id = intent
                    .getStringExtra(Constants.CLIENT_CONTACT_INFO_ID);

            clientId = id;

            ParseQuery<ClientContactInformation> query = ClientContactInformation.getQuery();
            query.fromLocalDatastore();
            query.whereEqualTo(Constants.UUID_FIELD, clientId);
            query.getFirstInBackground(new GetCallback<ClientContactInformation>() {
                @Override
                public void done(ClientContactInformation clientInfo, ParseException e) {
                    if (e == null) {
                        mContactInformation = clientInfo;
                        mContactInformation.setHealthInfo(mHealthYesNoQuestions);
                    } else {
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(), "error getting uuid", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * Start the Health Activity
     */
    private void startHealthYesNoActivity() {
        Intent checkIntent = new Intent(getActivity(),HealthCheckQuestionsActivity.class);
        checkIntent.putExtra(Constants.CLIENT_CONTACT_INFO_ID,clientId);
        checkIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        checkIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(checkIntent);
    }

    /**
     * Test health information
     */
    private void testHealthInfo() {
        mHealthYesNoQuestions = new HealthYesNoQuestions();
        mHealthYesNoQuestions.setUuidString();
        mHealthYesNoQuestions.setDiabetic("yes");
        mHealthYesNoQuestions.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    //check intent and set relation
                    getIntentAndSetHealthInfo();
                    //start activity
                    startHealthYesNoActivity();

                    Helper.makeToast(getActivity(),"Successfully saved");
                } else {
                    Toast.makeText(getActivity(), "error saving", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
