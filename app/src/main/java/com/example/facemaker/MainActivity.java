package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

/**
 * @author Haley Welliver
 * MainActivity is where widgets are created and linked
 */

public class MainActivity extends AppCompatActivity {

    private FaceController mainFaceController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking surfaceView to object
        MySurfaceView mainSV = (MySurfaceView) findViewById(R.id.surfaceView);
        mainFaceController = new FaceController(mainSV);


        //linking seekbars to listeners
        SeekBar myRedSB = (SeekBar) findViewById(R.id.seekBar_RED);
        myRedSB.setOnSeekBarChangeListener(mainFaceController);

        SeekBar myGreenSB = (SeekBar) findViewById(R.id.seekBar_GREEN);
        myGreenSB.setOnSeekBarChangeListener(mainFaceController);

        SeekBar myBlueSB = (SeekBar) findViewById(R.id.seekBar_BLUE);
        myBlueSB.setOnSeekBarChangeListener(mainFaceController);


        //linking spinners to listeners
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setOnItemSelectedListener(mainFaceController);


        //linking radio buttons to listeners
        RadioButton myHairRadioButton = (RadioButton) findViewById(R.id.radioButton_HAIR);

        RadioButton myEyeRadioButton = (RadioButton) findViewById(R.id.radioButton_EYES);

        RadioButton mySkinRadioButton = (RadioButton) findViewById(R.id.radioButton_SKIN);

        //makes a radioGroup for the three radio buttons
        RadioGroup myRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        //linking randomize button to listeners
        Button myRandomButton = (Button) findViewById(R.id.randomButton);
        myRandomButton.setOnClickListener(mainFaceController);

    }

    public void onRadioButtonClicked(View view){
        mainFaceController.onCheckedChanged(view);
    }
}
