package com.example.fredenbe20.realhomework2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/14/2018.
 */

public class ActionListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    private ArrayList<TextView> allTVs = new ArrayList<TextView>();
    private ArrayList<SeekBar> allSBs = new ArrayList<SeekBar>();
    public Face faceView;

    public ActionListener(TextView initalTV, Face face, SeekBar seekBar) {
        addTV(initalTV);
        addSB(seekBar);
        faceView = face;
    }

    //methods to add TextViews or SeekBars to their respective ArrayLists
    public void addTV(TextView anotherTV) {
        allTVs.add(anotherTV);
    }

    public void addSB(SeekBar anotherSB) {
        allSBs.add(anotherSB);
    }

    @Override
    public void onClick(View wasClicked) {

        if (wasClicked.getId() == R.id.randomFaceButton) {
            faceView.randomize();
        }

    }

    //Color.argb to make full color int
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red = 0;
        int green = 0;
        int blue = 0;

        if (seekBar.getId() == R.id.seekBarRed) {
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.textViewRedSB) {
                    tv.setText("Red: " + progress);
                    red = progress;
                }

            }
        } else if (seekBar.getId() == R.id.seekBarGreen) {
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.textViewGreenSB) {
                    tv.setText("Green: " + progress);
                    green = progress;
                }

            }
        } else if (seekBar.getId() == R.id.seekBarBlue) {
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.textViewBlueSB) {
                    tv.setText("Blue: " + progress);
                    blue = progress;
                }

            }
        }
        if (faceView.getRadioNum() == 0) {
            faceView.setEyeColor(red, green, blue);
        }
        if (faceView.getRadioNum() == 1) {
            faceView.setHairColor(red, green, blue);
        }
        if (faceView.getRadioNum() == 2) {
            faceView.setSkinColor(red, green, blue);

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Nothing needed
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Nothing needed
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "onItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
        faceView.setHairStyle(pos);
    }

    /**
     * External Citation
     * Date: 14 February 2018
     * Problem: Didn't know how to implement a Spinner in code
     * Resource:
     * http://www.mkong.com/android/android-spinner-drop-down-list-example/
     * Solution: I used the example code from this post.
     */
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        //Nothing
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.radioHair) faceView.setRadioNum(1);
        if(checkedId == R.id.radioEyes) faceView.setRadioNum(0);
        if(checkedId == R.id.radioSkin) faceView.setRadioNum(2);
    }
}
