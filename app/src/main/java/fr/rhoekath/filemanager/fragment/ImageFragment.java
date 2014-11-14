package fr.rhoekath.filemanager.fragment;

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
public class ImageFragment extends Fragment {
    public ImageFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container);

        return view;
    }
}
