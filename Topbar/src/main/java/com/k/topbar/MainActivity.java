package com.k.topbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity {

    private TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topBar = (TopBar) findViewById(R.id.topBar);
        topBar.setOnTopBarClickListener(new TopBar.topBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
            }
        });

        topBar.setLeftIsVisible(true);
    }
}
