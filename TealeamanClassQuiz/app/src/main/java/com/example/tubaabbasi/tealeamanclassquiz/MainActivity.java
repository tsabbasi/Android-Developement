package com.example.tubaabbasi.tealeamanclassquiz;

import android.content.Intent;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.lang.reflect.Array;


public class MainActivity extends Activity {

    Button submitButton;
    EditText textField1;
    EditText textField2;
    EditText textField3;
    EditText textField4;
    EditText textField5;
    EditText textField6;
    EditText textField7;
    EditText textField8;
    EditText textField9;
    EditText textField10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submitButton);
        textField1 = (EditText) findViewById(R.id.row1);
        textField2 = (EditText) findViewById(R.id.row2);
        textField3 = (EditText) findViewById(R.id.row3);
        textField4 = (EditText) findViewById(R.id.row4);
        textField5 = (EditText) findViewById(R.id.row5);
        textField6 = (EditText) findViewById(R.id.row6);
        textField7 = (EditText) findViewById(R.id.row7);
        textField8 = (EditText) findViewById(R.id.row8);
        textField9 = (EditText) findViewById(R.id.row9);
        textField10 = (EditText) findViewById(R.id.row10);
        final EditText[] textFields = new EditText[] {textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10};


        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String text = "";

                // Looping through the array of text fields -> EditText
                for(int index = 0; index < textFields.length; index++) {

                    if(!TextUtils.isEmpty(textFields[index].getText())) {

                        String input = textFields[index].getText().toString();

                        int answer = index + 1;
                        // Formatting input for display
                        text += answer + ". " + input + "\n";

                        }
                    }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                // Assigning data to intent
                intent.putExtra(Intent.EXTRA_TEXT, text);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }


            }
        });
    }
}
