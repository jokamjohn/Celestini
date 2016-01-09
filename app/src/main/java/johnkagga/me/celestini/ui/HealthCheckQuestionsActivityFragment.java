package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import johnkagga.me.celestini.utilites.Constants;
import johnkagga.me.celestini.utilites.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.HealthCheckQuestions;

/**
 * A placeholder fragment containing a simple view.
 */
public class HealthCheckQuestionsActivityFragment extends Fragment {

    private static final String LOG_TAG = HealthCheckQuestionsActivityFragment.class.getSimpleName();
    private String clientId;
    private ClientContactInformation mContactInformation;
    private HealthCheckQuestions mHealthCheckQuestions;

    public HealthCheckQuestionsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_health_check_questions, container, false);

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
            Log.v(LOG_TAG,"ClientId: " + clientId);

            ParseQuery<ClientContactInformation> query = ClientContactInformation.getQuery();
            query.fromLocalDatastore();
            query.whereEqualTo(Constants.UUID_FIELD, clientId);
            query.getFirstInBackground(new GetCallback<ClientContactInformation>() {
                @Override
                public void done(ClientContactInformation clientInfo, ParseException e) {
                    if (e == null) {
                        mContactInformation = clientInfo;
                        mContactInformation.setHealthCheckInformation(mHealthCheckQuestions);
                    } else {
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });

        }else {
            Toast.makeText(getActivity(), "error getting uuid", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * Test health information
     */
    private void testHealthInfo() {
        mHealthCheckQuestions = new HealthCheckQuestions();
        mHealthCheckQuestions.setUuidString();
        mHealthCheckQuestions.setOtherDiseases("Potato");
        mHealthCheckQuestions.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    //set relation
                    getIntentAndSetHealthInfo();
                    //start activity
                    startStructuredActivity();
                    Helper.makeToast(getActivity(), "Saved successfully");

                } else {
                    Toast.makeText(getActivity(), "error saving locally", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    /**
     * Start the Health Activity
     */
    private void startStructuredActivity() {
        Intent checkIntent = new Intent(getActivity(),StructuredQuestionsActivity.class);
        checkIntent.putExtra(Constants.CLIENT_CONTACT_INFO_ID,clientId);
        checkIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        checkIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(checkIntent);
    }
}
