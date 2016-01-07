package johnkagga.me.celestini.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import johnkagga.me.celestini.R;

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


        return rootView;
    }








}
