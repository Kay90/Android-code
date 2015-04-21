package com.k.topbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by k on 2015/3/31.
 */
public class TopBar extends RelativeLayout {

    private Button leftButton, rightButton;
    private TextView tvTitle;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams, rightParams, titleParams;

    private topBarClickListener listener;

    public interface topBarClickListener{
        void leftClick();
        void rightClick();
    }

    public void setOnTopBarClickListener(topBarClickListener listener){
        this.listener = listener;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        leftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = typedArray.getString(R.styleable.TopBar_leftText);

        rightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = typedArray.getString(R.styleable.TopBar_rightText);

        titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);
        titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        title = typedArray.getString(R.styleable.TopBar_topBarTitle);

        typedArray.recycle();

        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(title);
        tvTitle.setGravity(Gravity.CENTER);

        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        addView(leftButton, leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        addView(rightButton, rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        addView(tvTitle, titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
    }

    public void setLeftIsVisible(boolean flag){
        if (flag){
            leftButton.setVisibility(VISIBLE);
        }else {
            leftButton.setVisibility(GONE);
        }
    }
}
