package com.example.facemaker;

import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;

/**
 * @author Haley Welliver
 * the FaceController class contains methods that perform actions on the face
 */

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener {

    private SurfaceView mySV;
    private Face myFace;

    private int seekRedValue, seekBlueValue, seekGreenValue;

    private Face.FEATURE radioFeature;

    /**
     * FaceController constructor
     * @param diffSV
     */
    public FaceController(MySurfaceView diffSV)
    {
        radioFeature = Face.FEATURE.EYES;
        this.mySV = diffSV;
        this.myFace = diffSV.getFace();

    }

    /**
     * when the user clicks the randomize button, this method randomizes the face and then
     * invalidates the SurfaceView to clear it
     * @param v
     */
    public void onClick(View v)
    {
        myFace.randomize();
        mySV.invalidate();
    }

    /**
     * controls radio buttons based on an enumerated feature (eyes, hair, or skin) and then
     * invalidates the SurfaceView to clear it
     * @param buttonView
     */
    public void onCheckedChanged(View buttonView)
    {
        if(buttonView.getId() == R.id.radioButton_EYES){
            radioFeature = Face.FEATURE.EYES;
        }
        else if(buttonView.getId() == R.id.radioButton_HAIR){
            radioFeature = Face.FEATURE.HAIR;
        }
        else if(buttonView.getId() == R.id.radioButton_SKIN){
            radioFeature = Face.FEATURE.SKIN;
        }
        mySV.invalidate();
    }

    /**
     * method to get color information from seekbars and then
     * invalidates the SurfaceView to clear it
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if(seekBar.getId() == R.id.seekBar_RED){
            seekRedValue = progress;
        }
        else if(seekBar.getId() == R.id.seekBar_BLUE){
            seekBlueValue = progress;
        }
        else if(seekBar.getId() == R.id.seekBar_GREEN){
            seekGreenValue = progress;
        }
        else
            return;
        myFace.setColors(seekRedValue, seekGreenValue, seekBlueValue, radioFeature);
        mySV.invalidate();

        /**
         * External Citation
         * Date: 26 September 2019
         * Problem: Could not get the RGB values from seekbars
         * Resource: http://android-er.blogspot.com/2009/08/change-background-color-by-seekbar.html
         * Solution: I used the code from this blog as a reference point
         */
    }

    public void onStartTrackingTouch(SeekBar seekBar) { }

    public void onStopTrackingTouch(SeekBar seekBar) { }

    /**
     * method to get selected item for spinner
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        //0 = long
        //1 = curly
        //2 = pig tails
        if(parent.getSelectedItem().equals("Long")){
            this.myFace.setHairStyle(0);
        }
        else if(parent.getSelectedItem().equals("Curly")){
            this.myFace.setHairStyle(1);
        }
        else if(parent.getSelectedItem().equals("Pig Tails")){
            this.myFace.setHairStyle(2);
        }

        /**
         * External Citation
         * Date: 27 September 2019
         * Problem: Could not figure out how to make a dropdown menu for the spinner
         * Resource: https://www.youtube.com/watch?v=NoSri0OSOaA
         * Solution: I watched this video to learn how to make a list of strings in my strings.xml
         */
    }

    public void onNothingSelected(AdapterView<?> parent){ }

}
