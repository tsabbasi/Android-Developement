package com.example.tubaabbasi.androidlayouts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout background;
    Button redBtn, tealBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        background = (LinearLayout) findViewById(R.id.background);
        redBtn = (Button) findViewById(R.id.redBtn);
        tealBtn = (Button) findViewById(R.id.tealBtn);

        redBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick (View view) {
                background.setBackgroundColor(Color.parseColor("#e16b60"));

            }
        });

        tealBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick (View view) {
                background.setBackgroundColor(Color.parseColor("#88cccb"));

            }
        });
    }
}
