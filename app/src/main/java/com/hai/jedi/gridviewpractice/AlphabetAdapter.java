package com.hai.jedi.gridviewpractice;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import android.widget.BaseAdapter;
import android.widget.TextView;

import android.graphics.Typeface;

public class AlphabetAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mLetters;
    private Typeface mTypeface;

    public AlphabetAdapter(Context context, String[] letters, Typeface typeface){
        this.mContext = context;
        this.mLetters = letters;
        this.mTypeface = typeface;
    }

    @Override
    public int getCount() {
        return mLetters.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * ContextView
     *
     * If a View is a convertView, it is actually a View that can be converted to a new View.
     * This means that new content can get written into the fields contained in said view.
     *
     * This is necessary for the app performance. For example.
     *
     * Say we had a list of 150 things to display but our screen can only fit 10 items at a given
     * time. As we scroll down, the view that was in the 0th place goes off screen and can now be
     * removed from the app's memory until we scroll back up.
     *
     * Note that when we start our list, the convertView is null. This is because we need to start
     * building our list from our layout. If its not nll, then the layout already got built and
     * scrolling happened.
     * */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView;

        /**
         * The LayoutInflaters aid in correctly matching data to layout.
         *
         * Kind of a like a grocer making sure that each fruit is put in the right box, container
         * for display.
         * */
        LayoutInflater layout_inflater = (LayoutInflater) mContext
                                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            // Get layout from xml file
            gridView = layout_inflater.inflate(R.layout.alphabet_grid_item, null);
            // Pull views
            TextView letter_view = gridView.findViewById(R.id.grid_item_letter);
            // Set values to view.
            letter_view.setText(mLetters[position]); // using letter list data
            letter_view.setTypeface(mTypeface);

        }else {
            gridView = convertView;
        }

        return gridView;
    }
}
