package com.hai.jedi.gridviewpractice;

import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.util.Log;


public class MoodDialogFragment extends DialogFragment{

    public static final String TAG = MoodDialogFragment.class.getSimpleName();

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


        /**
         * To pull information from our fragment, we first have to
         * 1. Pull Radio Buttons from our Radio group.
         * 2. Get Radio Button id
         * 3. Return value from Radio Button
         * 4. Close DialogFragment*/


        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /**
                 * Adding this code here to the onClick makes sure that we get the appropriate radio
                 * button that was clicked*/
                // Pulling Radio Button Group
                RadioGroup moodSurvey = rootView.findViewById(R.id.moodRadioGroup);
                // Get Radio Button Id that user has selected.
                int selectedId = moodSurvey.getCheckedRadioButtonId();
                // Return value of above RadioButton
                final RadioButton selectedButtonValue = rootView.findViewById(selectedId);
                Log.d(TAG, "TESTING: "+ selectedButtonValue.getText().toString());
                dismiss();
            }
        });


        return rootView;
    }


}
