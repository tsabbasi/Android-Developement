package com.example.tubaabbasi.androidcalls;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        Button Phone = (Button) findViewById(R.id.button1);
        final EditText edittext = (EditText) findViewById(R.id.edittext);

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {


                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + edittext.getText()));


                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (sIntent.resolveActivity(getPackageManager()) != null) {

                    startActivity(sIntent);
                } else {

                    Toast.makeText(MainActivity.this, "Cellular Data Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}