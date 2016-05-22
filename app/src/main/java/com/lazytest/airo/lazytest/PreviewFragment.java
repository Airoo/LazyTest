package com.lazytest.airo.lazytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Airo on 21.05.2016.
 */
public class PreviewFragment extends Fragment {
    private EditText mNumberField;
    private Button mStartButton;
    private static final String NUMBER = "Number";
    private int number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_preview, container, false);
        mNumberField = (EditText) v.findViewById(R.id.editNumber);
        number = Integer.parseInt(String.valueOf(mNumberField));
        mStartButton = (Button) v.findViewById(R.id.start);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                QuastionFragment qustionFragment = new QuastionFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(NUMBER, number);
                qustionFragment.setArguments(bundle);
                FragmentTransaction ft  = manager.beginTransaction();
                ft.replace(R.id.fagment_preview  , qustionFragment);
                ft.commit();

            }
        });
        return v;
    }
}
