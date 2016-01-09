package johnkagga.me.celestini.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import johnkagga.me.celestini.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SyncActivityFragment extends Fragment {

    public SyncActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sync, container, false);
    }
}
