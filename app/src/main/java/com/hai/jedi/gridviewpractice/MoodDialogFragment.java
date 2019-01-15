package com.hai.jedi.gridviewpractice;

import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.util.Log;


public class MoodDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceSate){

        // Creating the dialog builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Adding a title to the builder
        builder.setTitle("Dialog view a Dialog Builder");
        // Adding a message to the builder
        builder.setMessage("Would you like to take a survey");

        // Creating the Yes button and adding a click event handler.
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
           @Override
           public void onClick(DialogInterface dialog, int which){
               dismiss();
           }
        });

        //Creating the No button and adding a click event handler
        builder.setNegativeButton("Nope", new DialogInterface.OnClickListener (){
           @Override
           public void onClick(DialogInterface dialog, int which){
               dismiss();
           }
        });



        return builder.create();
    }
}
