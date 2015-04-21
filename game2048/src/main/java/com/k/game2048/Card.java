package com.k.game2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by k on 2015/3/18.
 */
public class Card extends FrameLayout {

    private TextView lable;

    public Card(Context context) {
        super(context);

        lable = new TextView(getContext());
        //设置字体大小
        lable.setTextSize(32);
        //设置字体颜色
        lable.setBackgroundColor(0x33ffffff);
        //设置居中
        lable.setGravity(Gravity.CENTER);

        LayoutParams lp =new LayoutParams(-1, -1);
        lp.setMargins(10, 10, 0, 0);
        addView(lable, lp);

        setNum(0);
    }

    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;

        if (num <= 0){
            lable.setText("");
        }else {
            lable.setText(num + "");
        }
    }

    public boolean equals(Card o) {
        return getNum() == o.getNum();
    }
}
