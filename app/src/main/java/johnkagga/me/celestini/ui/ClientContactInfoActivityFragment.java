package johnkagga.me.celestini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.Date;

import johnkagga.me.celestini.Constants;
import johnkagga.me.celestini.R;
import johnkagga.me.celestini.data.ClientContactInformation;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClientContactInfoActivityFragment extends Fragment {

    private static final String LOG_TAG = ClientContactInfoActivityFragment.class.getSimpleName();
    private String clientId;

    public ClientContactInfoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_client_contact_info, container, false);
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientTestData();

            }
        });
        return rootView;
    }

    private void ClientTestData() {
        final ClientContactInformation testObj = new ClientContactInformation();

        testObj.setFirstName("Health");
        testObj.setDateOfBirth(new Date());
        testObj.setOccupation("builder");

        ParseGeoPoint location = new ParseGeoPoint(40.0, 41.0);
        testObj.setGeoPoint(location);

        testObj.setUuidString();
        testObj.setSync(false);
        testObj.setCreatedBy(ParseUser.getCurrentUser());

        testObj.pinInBackground(Constants.INFO_SAVE_LABEL, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    String id = testObj.getUuidString();
                    clientId = id;
                    Log.v(LOG_TAG, id);
                    startHealthActivity(clientId);
                } else {
                    Toast.makeText(getActivity(), "error saving", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }

    /**
     * Start the HealthActivity
     *
     * @param id Uuid
     */
    private void startHealthActivity(String id) {
        Intent intent = new Intent(getActivity(), HealthYesNoActivity.class);
        intent.putExtra(Constants.CLIENT_CONTACT_INFO_ID, id);
        startActivity(intent);
    }
}
