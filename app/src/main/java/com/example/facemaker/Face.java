package com.example.facemaker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * @author Haley Welliver
 * the Face class serves as a model for a face, containing all its features
 */

public class Face {

    public int skinColor = 0;
    public int eyeColor = 0;
    public int hairColor = 0;
    public int hairStyle = 0; //0, 1, 2 are options

    enum FEATURE{ EYES, HAIR, SKIN }

    public Face(){
        randomize();
    }

    /**
     * the randomize method initializes all variables to random values
     */
    public void randomize(){

        //random hair style
        int randHair = (int)(Math.random() * 3);
        hairStyle = randHair;

        //random colors
        Random rnd = new Random();
        int color1 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        int color2 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        int color3 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        skinColor = color1;
        hairColor = color2;
        eyeColor = color3;
    }

    public void setHairStyle(int hStyle){
        hairStyle = hStyle;
    }

    /**
     * the drawFace method draws the circle and the mouth of the face which both remain constant
     * @param canvas
     */
    public void drawFace(Canvas canvas){

        //draws circle for face
        Paint color = new Paint();
        color.setColor(skinColor);
        canvas.drawCircle(600, 400, 250, color);

        //draws mouth
        color.setColor(Color.WHITE);
        canvas.drawCircle(600, 500, 60, color);
        color.setColor(skinColor);
        canvas.drawRect(800, 500, 500, 250, color);
    }

    /**
     * the setColors method sets each face feature to a color based on seekbars
     * @param red
     * @param green
     * @param blue
     * @param feature
     */
    public void setColors(int red, int green, int blue, FEATURE feature){
        Paint color = new Paint();
        color.setColor(
                0xff000000
                        + red * 0x10000
                        + green * 0x100
                        + blue);
        int theColor = color.getColor();

        if( feature == FEATURE.EYES ) {
            //set eye color to red, green, blue
            eyeColor = theColor;
        }
        else if( feature == FEATURE.HAIR ){
            //set hair color to red, green, blue
            hairColor = theColor;
        }
        else if ( feature == FEATURE.SKIN ){
            //set skin color to red, green, blue
            skinColor = theColor;
        }

    }

    /**
     * the drawEyes method draws the eyes
     * @param canvas
     */
    public void drawEyes(Canvas canvas){ //, int seekR, int seekG, int seekB){
        Paint color = new Paint();

        //whites of eyes
        color.setColor(Color.WHITE);
        canvas.drawCircle(500, 350, 40, color);
        canvas.drawCircle(700, 350, 40, color);

        //iris color
        color.setColor(eyeColor);
        canvas.drawCircle(500, 350, 30, color);
        canvas.drawCircle(700, 350, 30, color);

        //pupil
        color.setColor(Color.BLACK);
        canvas.drawCircle(500, 350, 20, color);
        canvas.drawCircle(700, 350, 20, color);
    }

    /**
     * the drawHair method draws the hair based on selected hair style
     * @param canvas
     */
    public void drawHair(Canvas canvas){
        //select hair style from spinner
        //0 = long
        //1 = curly
        //2 = pig tails

        Paint color = new Paint();
        color.setColor(hairColor);

        //long
        if(hairStyle == 0){
            canvas.drawCircle(600, 400, 270, color);
            canvas.drawRect(850, 800, 350, 300, color);
        }
        //curly
        else if(hairStyle == 1){
            canvas.drawCircle(390, 200, 70, color);
            canvas.drawCircle(800, 200, 70, color);
            canvas.drawCircle(500, 150, 80, color);
            canvas.drawCircle(700, 150, 70, color);
            canvas.drawCircle(600, 100, 70, color);
            canvas.drawCircle(390, 300, 80, color);
            canvas.drawCircle(800, 300, 80, color);
        }
        //pig tails
        else if(hairStyle == 2){
            canvas.drawCircle(600, 350, 250, color);
            canvas.drawCircle(390, 200, 70, color);
            canvas.drawCircle(800, 200, 70, color);
        }
    }

    /**
     * the draw method is called in MySurfaceView and calls hair, face, and
     * eye methods to create the face
     * @param canvas
     */
    //calls hair method, eye method, etc
    public void draw(Canvas canvas){
        drawHair(canvas);
        drawFace(canvas);
        drawEyes(canvas);
    }
}
