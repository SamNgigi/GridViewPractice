package com.hai.jedi.gridviewpractice;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;

import android.os.Bundle;

import android.view.View;

import android.content.Intent;

import android.widget.GridView;
import android.widget.TextView;

import android.graphics.Typeface;

import java.lang.UnsatisfiedLinkError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    protected void loadNativeLibraries(){
        try{
            System.loadLibrary("native-lib");
        }catch(UnsatisfiedLinkError error){
            String error_message = "YOU'VE GOT ERROR MAIL FROM: " + error;
            Log.d(TAG, error_message);
        }
    }

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.exampleGridView) GridView gridView;
    @BindView(R.id.sample_text) TextView welcome_text;

    String[] letters = new String[] {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");

        ButterKnife.bind(this);

        /**
         *  Example of a call to a native method
         *  TextView tv = (TextView) findViewById(R.id.sample_text);
         *  tv.setText(stringFromJNI()); String from 'native-lib'
         * */

        //Setting onClickListener to welcome text to lead us to Dialog Activity
        welcome_text.setOnClickListener(this);
        // Should return 'B' a couple of times for now base on the length of the letters array.
        gridView.setAdapter(new AlphabetAdapter(this, letters, mTypeface));



    }

    @Override
    public void onClick(View v){
        if(v == welcome_text) {
            // We navigate to the Dialog Activity.w
            Intent dialog_intent = new Intent(MainActivity.this, DialogActivity.class);
            startActivity(dialog_intent);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     *
     * public native String stringFromJNI();
     */

}
