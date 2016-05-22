package com.lazytest.airo.lazytest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

/**
 * Created by Airo on 21.05.2016.
 */
public class FragmentQuastion extends Fragment {

    private static final String ARG_NUMBER = "number";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quastion, container, false);
        return v;
    }
}
