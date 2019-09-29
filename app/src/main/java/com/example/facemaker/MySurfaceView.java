package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * @author Haley Welliver
 * the MySurfaceView class is where the face is drawn
 */

public class MySurfaceView extends SurfaceView {

    /**
     * constructor
     * @param context
     * @param attrs
     */
    public MySurfaceView(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
    }

    //creating new face
    Face myFace = new Face();

    public void onDraw(Canvas canvas){
        myFace.draw(canvas);
    }

    public Face getFace() {
        return myFace;
    }
}
