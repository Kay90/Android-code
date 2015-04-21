package com.k.game2048;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private TextView tvScore;
    private static MainActivity mainActivity = null;
    private int score = 0;

    public MainActivity(){
        mainActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScore = (TextView) findViewById(R.id.tvScore);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static MainActivity getMainActivity(){
        return mainActivity;
    }

    /**
     * 清空分数
     */
    public void clearScore(){
        score = 0;
        showScore();
    }

    /**
     * 显示分数
     */
    public void showScore(){
        tvScore.setText(score+"");
    }

    /**
     * 添加分数
     * @param s    分数
     */
    public void addScore(int s){
        score += s;
        showScore();
    }

}
