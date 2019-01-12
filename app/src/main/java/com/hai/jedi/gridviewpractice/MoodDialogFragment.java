package com.hai.jedi.gridviewpractice;



import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Build;



public class MoodDialogFragment extends DialogFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Build savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_mood_dialog, container, false);
        getDialog().setTitle("Simple Dialog");
        return rootView;
    }
}
