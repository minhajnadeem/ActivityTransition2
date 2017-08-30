package com.example.minhaj.activitytransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView1,textView2,textView3,textView4;
    private Button button,button2,button3,button4;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView1 = (TextView) findViewById(R.id.textView5);
        textView2 = (TextView) findViewById(R.id.textView6);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button5);
        imageView = (ImageView) findViewById(R.id.imageView);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startNewActivity(view);
            }
        });
    }

    private void startNewActivity(View view) {

        if (view == button) {
            Explode explode = new Explode();
            //explode.setDuration(2000);
            Transition imgTransition = TransitionInflater.from(this).inflateTransition(R.transition.image_transition);
            getWindow().setSharedElementExitTransition(imgTransition);
            getWindow().setExitTransition(explode);
        }else if (view == button2){
            getWindow().setSharedElementExitTransition(new Fade());
            getWindow().setExitTransition(new Fade());
        }else if (view == button3){
            getWindow().setSharedElementExitTransition(new Slide());
            getWindow().setExitTransition(new Slide());
        }else if (view == button4){
            Transition custom = TransitionInflater.from(this).inflateTransition(R.transition.custom_transition);
            custom.setDuration(2000);
            getWindow().setExitTransition(custom);
        }
        startActivity(new Intent(this,Main2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this,imageView,"test").toBundle());
    }
}
