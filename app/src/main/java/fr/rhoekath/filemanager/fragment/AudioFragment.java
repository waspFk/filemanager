package fr.rhoekath.filemanager.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.rhoekath.filemanager.R;

/**
 * Created by Mickael on 14/11/2014.
 */
public class AudioFragment extends Fragment {

    AudioListener audioListener;

    public AudioFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        audioListener.onCreateViewListener();
        return view;
    }

    public interface AudioListener{
        public void onCreateViewListener();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            audioListener = (AudioListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
