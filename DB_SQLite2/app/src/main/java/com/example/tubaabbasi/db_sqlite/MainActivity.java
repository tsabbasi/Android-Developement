package com.example.tubaabbasi.db_sqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    private ListView accountObj;
    DBHelper mydb;
    AccountsDBHelper acdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);
        acdb = new AccountsDBHelper(this);
        ArrayList account_array_list = acdb.getAllAccounts();
        ArrayList array_list = mydb.getAllCotacts();
        ArrayAdapter accountArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, account_array_list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_list);

        accountObj = (ListView) findViewById(R.id.listView);
        obj = (ListView) findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        accountObj.setAdapter(accountArrayAdapter);

        accountObj.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int id_To_Search = arg2 + 1;

                Bundle accountDataBundle = new Bundle();
                accountDataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(), DisplayAccount.class);

                intent.putExtras(accountDataBundle);
                startActivity(intent);
            }
        });
        obj.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.item1:Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);

                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
                intent.putExtras(dataBundle);

                startActivity(intent);
                return true;
            case R.id.item2:Bundle accountDataBundle = new Bundle();
                accountDataBundle.putInt("id", 0);

                Intent accountIntent = new Intent(getApplicationContext(),DisplayAccount.class);
                accountIntent.putExtras(accountDataBundle);

                startActivity(accountIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }
}
