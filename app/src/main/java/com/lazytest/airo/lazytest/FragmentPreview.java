package com.lazytest.airo.lazytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * Created by Airo on 21.05.2016.
 */
public class FragmentPreview extends Fragment {
    private NumberPicker mNumberField;
    private Button mStartButton;
    private static final String NUMBER = "Number";
    private int number;
    private String numberEnter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_preview, container, false);
       /*mNumberField = (NumberPicker) v.findViewById(R.id.editNumber);
        number = mNumberField.getValue();*/
        mStartButton = (Button) v.findViewById(R.id.start);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityQuastion.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
