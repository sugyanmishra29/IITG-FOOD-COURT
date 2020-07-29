package com.example.foodcourt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.widget.Toast.LENGTH_SHORT;

public class signuppage extends AppCompatActivity {

    private EditText suUsername;  //email
    private EditText suPassword;
    private EditText suName;
    private EditText suAddress;
    private EditText suConfirmPassword;
    private EditText suPhone;
    private Button btnSignUp;
    private Button btnResetSu;

    private void addData()
    {
        final String email_txt = suUsername.getText().toString().trim();
        final String password_txt = suPassword.getText().toString().trim();
        final String confirmpassword_txt = suConfirmPassword.getText().toString().trim();
        final String name_txt = suName.getText().toString().trim();
        final String phone_txt = suPhone.getText().toString().trim();
        final String address_txt = suAddress.getText().toString().trim();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();       //ROOT
        Log.v("Sign up",email_txt);
        Log.v("Sign up",password_txt);
        if(!email_txt.equals(""))
        {
            if(!password_txt.equals("")) {
                if(confirmpassword_txt.equals(password_txt)){
                    ref.child("Users").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.child(email_txt).exists())
                                {
                                    Toast.makeText(signuppage.this, "Email id already in use", LENGTH_SHORT).show();
                                }
                                else
                                {
                                    ref.child("Users").child(email_txt).child("Password").setValue(password_txt);
                                    ref.child("Users").child(email_txt).child("Name").setValue(name_txt);
                                    ref.child("Users").child(email_txt).child("Address").setValue(address_txt);
                                    ref.child("Users").child(email_txt).child("Phone").setValue(phone_txt);
                                    Log.v("sign up ","Before intent");
                                    Intent i = new Intent(signuppage.this,authpage.class);
                                    startActivity(i);
                                    Log.v("sign up ","After intent");
                                    Toast.makeText(signuppage.this, "Account created successfully", LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(signuppage.this, "Database Error", LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(this, "Passwords entered do not match", LENGTH_SHORT).show();
                }}
            else
            {
                Toast.makeText(this,"Please Fill Password.", LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"Please Fill Email.", LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);
        suUsername=(EditText)findViewById(R.id.suUsername);
        suPassword=(EditText)findViewById(R.id.suPassword);
        suConfirmPassword=(EditText)findViewById(R.id.suConfirmPassword);
        suName=(EditText)findViewById(R.id.suName);
        suAddress=(EditText)findViewById(R.id.suAddress);
        suPhone=(EditText)findViewById(R.id.suPhone);
        btnSignUp=(Button)findViewById(R.id.btnSignup);
        btnResetSu=(Button)findViewById(R.id.btnResetsu);

        btnResetSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suUsername.setText("");
                suPassword.setText("");
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }
}
