package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import johnkagga.me.celestini.Constants;
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



        return rootView;
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

}
