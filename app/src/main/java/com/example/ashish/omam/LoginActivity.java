package com.example.ashish.omam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText editemail,editpass;
    ProgressDialog progressDialog;
    Button btnchk,btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editemail = (EditText) findViewById(R.id.editmail);
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        editpass = (EditText) findViewById(R.id.editpass);
        btnchk = (Button) findViewById(R.id.btnchk);
        btnsignin = (Button) findViewById(R.id.btnsignin);



        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });



        btnchk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInfo(view);
            }
        });


    }

    private void registerUser(){
        String email = editemail.getText().toString().trim();
        String password = editpass.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //Toast to show enter email please
            Toast.makeText(LoginActivity.this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //Toast to show enter password please
            Toast.makeText(LoginActivity.this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering user....");
        progressDialog.show();

        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Registered Succesfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(LoginActivity.this,Employee.class));

                        }else
                            Toast.makeText(LoginActivity.this,"Could not Registered,Please try again",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
    }


    protected  void checkInfo(View v){

        String email = editemail.getText().toString().trim();
        String password = editpass.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //Toast to show enter email please
            Toast.makeText(LoginActivity.this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //Toast to show enter password please
            Toast.makeText(LoginActivity.this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logging In....");
        progressDialog.show();

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else
                    Toast.makeText(LoginActivity.this,"Could not Log in,Please try again",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });

    }
}
