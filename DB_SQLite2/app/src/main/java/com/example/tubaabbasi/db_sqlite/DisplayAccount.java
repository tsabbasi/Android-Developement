package com.example.tubaabbasi.db_sqlite;

/**
 * Created by tubaabbasi on 11/11/16.
 */

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayAccount extends Activity {

    int from_Where_I_Am_Coming = 0;
    private AccountsDBHelper mydb ;

    TextView accountName;
    TextView username;
    TextView password;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_account);
        accountName = (TextView) findViewById(R.id.editTextAccountName);
        username = (TextView) findViewById(R.id.editTextUsername);
        password = (TextView) findViewById(R.id.editTextPassword);

        mydb = new AccountsDBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add account part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String accountNam = rs.getString(rs.getColumnIndex(AccountsDBHelper.ACCOUNTS_COLUMN_NAME));
                String usernam = rs.getString(rs.getColumnIndex(AccountsDBHelper.ACCOUNTS_COLUMN_USERNAME));
                String passwor = rs.getString(rs.getColumnIndex(AccountsDBHelper.ACCOUNTS_COLUMN_PASSWORD));

                if (!rs.isClosed())  {
                    rs.close();
                }
                Button b = (Button)findViewById(R.id.saveButton);
                b.setVisibility(View.INVISIBLE);

                accountName.setText((CharSequence)accountNam);
                accountName.setFocusable(false);
                accountName.setClickable(false);

                username.setText((CharSequence)usernam);
                username.setFocusable(false);
                username.setClickable(false);

                password.setText((CharSequence)passwor);
                password.setFocusable(false);
                password.setClickable(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.display_account, menu);
            } else{
                getMenuInflater().inflate(R.menu.main_menu, menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.Edit_Account:
                Button b = (Button)findViewById(R.id.saveButton);
                b.setVisibility(View.VISIBLE);
                accountName.setEnabled(true);
                accountName.setFocusableInTouchMode(true);
                accountName.setClickable(true);

                username.setEnabled(true);
                username.setFocusableInTouchMode(true);
                username.setClickable(true);

                password.setEnabled(true);
                password.setFocusableInTouchMode(true);
                password.setClickable(true);

                return true;
            case R.id.Delete_Account:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteAccount)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteAccount(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });

                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                if(mydb.updateAccount(id_To_Update,accountName.getText().toString(),
                        username.getText().toString(), password.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            } else{
                if(mydb.insertAccount(accountName.getText().toString(), username.getText().toString(),
                        password.getText().toString())){
                    Toast.makeText(getApplicationContext(), "done",
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}

