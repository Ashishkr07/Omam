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
import android.widget.Toast;

/**
 * Created by ashish on 16/6/18.
 */

public class RemoveEmployee extends AppCompatActivity{

    DataBaseHelper dataBaseHelper;
    EditText editText1;
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeemployee);
        editText1 = (EditText) findViewById(R.id.edt11);
        dataBaseHelper = new DataBaseHelper(this);
         btn = (Button) findViewById(R.id.btdel);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isDeleted = dataBaseHelper.deleteData(editText1.getText().toString());

                if(isDeleted > 0){
                    Toast.makeText(RemoveEmployee.this,"Data deleted",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RemoveEmployee.this,"Data not deleted",Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}
