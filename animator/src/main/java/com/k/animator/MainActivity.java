package com.k.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Animator 属性动画
 * translationX\translationY
 * rotation,rotationX\rotationY
 * scaleX\scaleY
 * X\Y
 * alpha
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArcActivity.class));
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MyActivity.class));
            }
        });
    }

    public void click(View view){
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }

    public void move(View view){
//        TranslateAnimation animation = new TranslateAnimation(0,200,0,0);
//        animation.setDuration(1000);
//        animation.setFillAfter(true);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.startAnimation(animation);
//        ObjectAnimator.ofFloat(imageView, "rotation", 0f,360f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "translationX", 0f,200f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "translationY", 0f,200f).setDuration(1000).start();

//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0f, 200f);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY", 0f, 200f);
//        ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2,p3).setDuration(1000).start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0f,360f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0f,200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 200f);

        AnimatorSet set = new AnimatorSet();
//        set.playSequentially(animator1, animator2, animator3);
        set.play(animator2).with(animator3);
        set.play(animator1).after(animator2);
        set.setDuration(1000);
        set.start();
    }

    public void clicked(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        animator.setDuration(1000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(MainActivity.this, "anim end", Toast.LENGTH_SHORT).show();
            }
        });
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                Toast.makeText(MainActivity.this, "anim end", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
        animator.start();
    }
}
