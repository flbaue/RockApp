package de.esailors.rockapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends ActionBarActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetector;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this, this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d("TOUCH", "single tab");
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("TOUCH", "double tab");
        if (mPlayer != null && mPlayer.isPlaying()) {
            return true;
        }
        mPlayer = MediaPlayer.create(this, R.raw.nd_jag);
        mPlayer.start();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (distanceY > 10 && Math.abs(distanceX) < 5) {
            Log.d("TOUCH", "scroll up");
            if (mPlayer != null && mPlayer.isPlaying()) {
                return true;
            }
            mPlayer = MediaPlayer.create(this, R.raw.rhcp_so18);
            mPlayer.start();
        }
        if (distanceY < -10 && Math.abs(distanceX) < 5) {
            Log.d("TOUCH", "scroll down");
            if (mPlayer != null && mPlayer.isPlaying()) {
                return true;
            }
            mPlayer = MediaPlayer.create(this, R.raw.jb);
            mPlayer.start();
        }
        if (distanceX > 10 && Math.abs(distanceY) < 5) {
            Log.d("TOUCH", "scroll left");
            if (mPlayer != null && mPlayer.isPlaying()) {
                return true;
            }
            mPlayer = MediaPlayer.create(this, R.raw.jbg);
            mPlayer.start();

        }
        if (distanceX < -10 && Math.abs(distanceY) < 5) {
            Log.d("TOUCH", "scroll right");
            if (mPlayer != null && mPlayer.isPlaying()) {
                return true;
            }
            mPlayer = MediaPlayer.create(this, R.raw.guns);
            mPlayer.start();
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("TOUCH", "long tab");
        if (mPlayer != null && mPlayer.isPlaying()) {
            return;
        }
        mPlayer = MediaPlayer.create(this, R.raw.acdc);
        mPlayer.start();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
