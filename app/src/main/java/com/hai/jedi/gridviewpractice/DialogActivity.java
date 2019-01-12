package com.hai.jedi.gridviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.os.Bundle;

//import android.app.FragmentManager;

import android.view.View;

import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.dialog_launcher) Button dialog_launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        ButterKnife.bind(this);

        dialog_launcher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == dialog_launcher){
             FragmentManager fm = getSupportFragmentManager();
             MoodDialogFragment moodDialogFragment = new MoodDialogFragment();
             moodDialogFragment.show(fm, "Sample Fragment");
        }
    }
}
