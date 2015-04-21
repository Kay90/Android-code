package com.k.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k on 2015/4/2.
 */
public class ArcActivity extends Activity implements View.OnClickListener {

    private int[] res = {R.id.imageView_a, R.id.imageView_b, R.id.imageView_c,
            R.id.imageView_d, R.id.imageView_e, R.id.imageView_f, R.id.imageView_g, R.id.imageView_h};

    private List<ImageView> imageViews = new ArrayList<>();

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc);
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViews.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_a:
                if (flag) {
                    startAnimator();
                } else {
                    closeAnimator();
                }
                break;
            default:
                Toast.makeText(ArcActivity.this, "Click:" + v.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeAnimator() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageViews.get(i),
                    "translationY", i*100f, 0f);
            AnimatorSet set = new AnimatorSet();
            set.play(animatorY);
            //set.setInterpolator(new BounceInterpolator());
            set.setStartDelay(i * 200);
            set.setDuration(300);
            set.start();
            flag = true;
        }
    }

    private void startAnimator() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageViews.get(i),
                    "translationY", 0f,i*100f);
            AnimatorSet set = new AnimatorSet();
            set.play(animatorY);
            //set.setInterpolator(new BounceInterpolator());
            set.setStartDelay(i * 200);
            set.setDuration(300);
            set.start();
            flag = false;
        }
    }
}
