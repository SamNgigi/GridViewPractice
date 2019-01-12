package com.hai.jedi.gridviewpractice;

import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;


public class MoodDialogFragment extends DialogFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_mood_dialog, container, false);
        getDialog().setTitle("Simple Dialog");

        // On a Fragment we cannot use butter-knife because we are not interacting with the activity
        // We do it old school

        Button cancelButton = rootView.findViewById(R.id.cancelButton);
        Button submitButton = rootView.findViewById(R.id.submitButton);

        // We cannot use the View.onClickListener either because we cannot depend on an activity
        // only a fragment view. We do clicks old school.
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dismiss();
            }
        });




        return rootView;
    }


}
