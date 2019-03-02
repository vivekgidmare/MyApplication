package com.vivek.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private MotionLayout motionLayout;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekbar);
        motionLayout = findViewById(R.id.motion_container);
        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startID, int endId, float progress) {
                double pr = Math.ceil(progress * 100);
                Log.d("TAG", "onTransitionChange: " + pr);
                seekBar.setProgress((int) pr);
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentID) {
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });

    }

    public void start(View view) {
//        motionLayout.transitionToEnd();
    }
}
