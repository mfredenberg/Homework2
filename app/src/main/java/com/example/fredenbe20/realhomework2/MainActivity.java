package com.example.fredenbe20.realhomework2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Face displayedFace = (Face)findViewById(R.id.faceSurfaceView);


        displayedFace.setBackgroundColor(Color.WHITE);
        //Retrieve references to relevant views
        TextView redTV = (TextView)findViewById(R.id.textViewRedSB);
        TextView greenTV = (TextView)findViewById(R.id.textViewGreenSB);
        TextView blueTV = (TextView)findViewById(R.id.textViewBlueSB);

        SeekBar redSB = (SeekBar)findViewById(R.id.seekBarRed);
        SeekBar greenSB = (SeekBar)findViewById(R.id.seekBarGreen);
        SeekBar blueSB = (SeekBar)findViewById(R.id.seekBarBlue);

        Spinner hairSpinner = (Spinner)findViewById(R.id.hairStyleSpinner);

        RadioGroup radioChoice = (RadioGroup) findViewById(R.id.radioChoice);
        RadioButton radioEyes = (RadioButton)findViewById(R.id.radioEyes);
        RadioButton radioHair = (RadioButton)findViewById(R.id.radioHair);
        RadioButton radioSkin = (RadioButton)findViewById(R.id.radioSkin);


        Button randomFaceBut = (Button)findViewById(R.id.randomFaceButton);

        //Setup and add to listener
        ActionListener myListener = new ActionListener(redTV, displayedFace, redSB);
        myListener.addTV(greenTV);
        myListener.addTV(blueTV);
        myListener.addSB(greenSB);
        myListener.addSB(blueSB);

        //Applying the Listener to the Views
        randomFaceBut.setOnClickListener(myListener);
        redSB.setOnSeekBarChangeListener(myListener);
        greenSB.setOnSeekBarChangeListener(myListener);
        blueSB.setOnSeekBarChangeListener(myListener);
        hairSpinner.setOnItemSelectedListener(myListener);
        radioChoice.setOnCheckedChangeListener(myListener);
    }


}
