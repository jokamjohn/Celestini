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
public class HealthYesNoActivityFragment extends Fragment {

    private static final String LOG_TAG = HealthYesNoActivityFragment.class.getSimpleName();

    public HealthYesNoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_health_yes_no, container, false);



        return rootView;
    }



}
