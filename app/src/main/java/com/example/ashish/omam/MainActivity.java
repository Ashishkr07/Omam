package com.example.ashish.omam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder nbuiler = new AlertDialog.Builder(MainActivity.this).setMessage("ACTION TO BE PERFORMED?");
                View mview = View.inflate(MainActivity.this,R.layout.customlayout,null);
                TextView textv1 = (TextView) findViewById(R.id.tv1);
                TextView textv2 = (TextView) findViewById(R.id.tv2);
                TextView textv3 = (TextView) findViewById(R.id.tv3);

                nbuiler.setView(mview);
                final AlertDialog alertDialog = nbuiler.create();
                alertDialog.show();



            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Want to remove employee?", Snackbar.LENGTH_LONG)
                        .setAction("Remove", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(getBaseContext(),RemoveEmployee.class));
                            }
                        }).show();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Want to add new employee?", Snackbar.LENGTH_LONG)
                        .setAction("Add", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(getBaseContext(),AddEmployee.class));
                            }
                        }).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder nbuiler = new AlertDialog.Builder(MainActivity.this).setTitle("ACTION TO BE PERFORMED?");
                View mview = View.inflate(MainActivity.this,R.layout.customlayout,null);
                TextView textv1 = (TextView) findViewById(R.id.tv1);
                TextView textv2 = (TextView) findViewById(R.id.tv2);
                TextView textv3 = (TextView) findViewById(R.id.tv3);

                nbuiler.setView(mview);
                final AlertDialog alertDialog = nbuiler.create();
                alertDialog.show();



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
