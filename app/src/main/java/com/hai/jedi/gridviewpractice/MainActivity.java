package com.hai.jedi.gridviewpractice;

import android.util.Log;

import android.support.v7.app.AppCompatActivity;

import android.app.FragmentManager;

import android.os.Bundle;

//import android.widget.TextView;
import android.widget.GridView;

import android.graphics.Typeface;

import java.lang.UnsatisfiedLinkError;

public class MainActivity extends AppCompatActivity {

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

    GridView gridView;

    String[] letters = new String[] {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");

        /**
         *  Example of a call to a native method
         *  TextView tv = (TextView) findViewById(R.id.sample_text);
         *  tv.setText(stringFromJNI()); String from 'native-lib'
         * */

        gridView = findViewById(R.id.exampleGridView);

        // Should return 'B' a couple of times for now base on the length of the letters array.
        gridView.setAdapter(new AlphabetAdapter(this, letters, mTypeface));

        // Adding our MoodDialogFragment to our activity
        FragmentManager fragmentManager = getFragmentManager();
        MoodDialogFragment moodDialogFragment = new MoodDialogFragment();
        moodDialogFragment.show(fragmentManager, "Example Fragment");

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     *
     * public native String stringFromJNI();
     */

}
