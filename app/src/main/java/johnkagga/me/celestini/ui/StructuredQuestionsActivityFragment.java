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
public class StructuredQuestionsActivityFragment extends Fragment {

    private static final String LOG_TAG = StructuredQuestionsActivityFragment.class.getSimpleName();

    public StructuredQuestionsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_structured_questions, container, false);

        return rootView;
    }

}
