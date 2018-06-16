package com.example.ashish.omam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by ashish on 16/6/18.
 */

public class RemoveEmployee extends AppCompatActivity{

    EditText editText1,editText2,editText3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeemployee);
        editText1 = (EditText) findViewById(R.id.edt1);
        editText2 = (EditText) findViewById(R.id.edt2);
        editText3 = (EditText) findViewById(R.id.edt3);

    }
}
