package com.example.ashish.omam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by ashish on 16/6/18.
 */

public class AddEmployee extends AppCompatActivity {

    Spinner s1,s2;
    String department = " ";
    String branch = " ";
    EditText e1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addemployee);
        e1 = (EditText) findViewById(R.id.ed1);
        s1 = (Spinner) findViewById(R.id.spinr1);
        s2 = (Spinner) findViewById(R.id.spinr2);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(AddEmployee.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.position));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(arrayAdapter1);
        s1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                       department  = "Consultant";
                        break;
                    case 1:
                        department = "HR";
                        break;
                    case 2:
                        department = "Administration";
                        break;
                    case 3:
                        department = "Counselor";
                        break;
                    case 4:
                        department = "Marketing";
                        break;
                    case 5:
                        department = "Faculty";
                        break;
                    case 6:
                        department = "Center Head";
                        break;
                    case 7:
                        department = "Business";
                        break;
                    case 8:
                        department = "Telle Caller";
                        break;
                    case 9:
                        department = "Other";
                        break;
                }
            }

        });



        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(AddEmployee.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.branch));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(arrayAdapter2);
        s2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i ==0){
                    branch = "DWARKA";
                }else{
                    branch = "RAMA VIHAR";
                }
            }
        });

    }
}
