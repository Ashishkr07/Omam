package com.example.ashish.omam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ashish on 16/6/18.
 */

public class AddEmployee extends AppCompatActivity {

    Spinner spinr1,spinr2;
    DataBaseHelper dataBaseHelper;
    String department;
    Button btadd;
    String branch;
    EditText ed1;
    TextView tvd,tvb,tvad1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addemployee);
        ed1 = (EditText) findViewById(R.id.ed1);
        spinr1 = (Spinner) findViewById(R.id.spinr1);
        spinr2 = (Spinner) findViewById(R.id.spinr2);
        btadd = (Button) findViewById(R.id.btadd);
        tvd = (TextView) findViewById(R.id.tvd);
        tvb = (TextView) findViewById(R.id.tvb);
        tvad1 = (TextView) findViewById(R.id.tvad1);
        dataBaseHelper = new DataBaseHelper(this);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.position));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinr1.setAdapter(arrayAdapter1);
        spinr1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        department = "ENTER THE DEPARTMENT";
                        break;
                    case 1:
                        department  = "Consultant";
                        break;
                    case 2:
                        department = "HR";
                        break;
                    case 3:
                        department = "Administration";
                        break;
                    case 4:
                        department = "Counselor";
                        break;
                    case 5:
                        department = "Marketing";
                        break;
                    case 6:
                        department = "Faculty";
                        break;
                    case 7:
                        department = "Center Head";
                        break;
                    case 8:
                        department = "Business";
                        break;
                    case 9:
                        department = "Telle Caller";
                        break;
                    case 10:
                        department = "Other";
                        break;
                }
                tvd.setText(department);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.branch));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinr2.setAdapter(arrayAdapter2);
        spinr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i ==1){
                    branch = "Dwarka";
                }else if(i ==2 ){
                    branch = "Rama Vihar";
                }else
                    branch = "ENTER THE BRANCH";
                tvb.setText(branch);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = dataBaseHelper.insertData(ed1.getText().toString(),department,branch);

                if(isInserted == true){
                    Toast.makeText(getBaseContext(), "Employee Added", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getBaseContext(),"Employee Not Added",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
