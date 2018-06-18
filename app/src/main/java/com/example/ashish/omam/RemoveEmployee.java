package com.example.ashish.omam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by ashish on 16/6/18.
 */

public class RemoveEmployee extends AppCompatActivity{

    EditText editText1;
    Spinner sp1,sp2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeemployee);
        editText1 = (EditText) findViewById(R.id.edt11);
        sp1 = (Spinner) findViewById(R.id.spinr11);
        sp2 = (Spinner) findViewById(R.id.spinr21);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(RemoveEmployee.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.position));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(arrayAdapter1);



        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(RemoveEmployee.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.branch));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(arrayAdapter2);

    }
}
