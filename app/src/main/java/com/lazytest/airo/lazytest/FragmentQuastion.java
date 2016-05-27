package com.lazytest.airo.lazytest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by Airo on 21.05.2016.
 */
public class FragmentQuastion extends Fragment {


    private static final String ARG_NUMBER = "number";
    private Button mYesButton, mNoButton;
    private static final String DIALOG_LAZY = "lazy";
    private static final int REQUEST_LAZY = 0;
    private static final String DIALOG_STRONG = "strong";
    private static final int REQUEST_STRONG = 0;
    private int lazyLevel = randomLazyLevel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quastion, container, false);
        final Integer[] screenData = getScreenDimension();
        mYesButton = (Button) v.findViewById(R.id.yes);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                LazyFragment dialog = new LazyFragment();
                dialog.setTargetFragment(FragmentQuastion.this, REQUEST_LAZY);
                dialog.show(manager, DIALOG_LAZY);
            }
        });
        mNoButton = (Button) v.findViewById(R.id.no);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lazyLevel > 0) {
                    mNoButton.setX((float) (Math.random() * screenData[0]));
                    mNoButton.setY((float) (Math.random() * screenData[1]));
                    lazyLevel = lazyLevel - 1;
                } else {
                    FragmentManager manager = getFragmentManager();
                    StrongFragment dialog = new StrongFragment();
                    dialog.setTargetFragment(FragmentQuastion.this, REQUEST_STRONG);
                    dialog.show(manager, DIALOG_STRONG);
                    lazyLevel = randomLazyLevel();
                }
               final Toast toast = Toast.makeText(getActivity(),
                        "Осталось: " +lazyLevel, Toast.LENGTH_SHORT);
                        toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 500);
            }
        });
        return v;
    }

    private Integer[] getScreenDimension() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = (int) (dm.widthPixels / 1.8);
        int height = (int) (dm.heightPixels / 1.8);
        Integer[] screenInformation = new Integer[2];
        screenInformation[0] = width;
        screenInformation[1] = height;
        return screenInformation;
    }

    private int randomLazyLevel() {
        int lazyLevel = (int) (15 + (Math.random() * ((30 - 15) + 1)));
        return lazyLevel;
    }
}
