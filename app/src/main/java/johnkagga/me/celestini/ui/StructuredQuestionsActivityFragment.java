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

import johnkagga.me.celestini.Constants;
import johnkagga.me.celestini.Helper;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;
import johnkagga.me.celestini.data.StructuredQuestions;

/**
 * A placeholder fragment containing a simple view.
 */
public class StructuredQuestionsActivityFragment extends Fragment {

    private static final String LOG_TAG = StructuredQuestionsActivityFragment.class.getSimpleName();
    private String clientId;
    private ClientContactInformation mContactInformation;
    private StructuredQuestions mStructuredQuestions;

    public StructuredQuestionsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_structured_questions, container, false);

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
            Log.v(LOG_TAG, "ClientId: " + clientId);

            ParseQuery<ClientContactInformation> query = ClientContactInformation.getQuery();
            query.fromLocalDatastore();
            query.whereEqualTo(Constants.UUID_FIELD, clientId);
            query.getFirstInBackground(new GetCallback<ClientContactInformation>() {
                @Override
                public void done(ClientContactInformation clientInfo, ParseException e) {
                    if (e == null) {
                        mContactInformation = clientInfo;
                        mContactInformation.setStructuredHealthInformation(mStructuredQuestions);

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
     * Test health information
     */
    private void testHealthInfo() {
        mStructuredQuestions = new StructuredQuestions();
        mStructuredQuestions.setUuidString();
        mStructuredQuestions.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    //set relation
                    getIntentAndSetHealthInfo();


                    Helper.makeToast(getActivity(),"Saved successfully");
                } else {
                    Toast.makeText(getActivity(), "error saving locally", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
