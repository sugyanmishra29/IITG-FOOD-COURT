package com.example.foodcourt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class help extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        TextView tv = (TextView)findViewById(R.id.helptext);
        tv.setText("Sample");
    }

    @Override
    public void onBackPressed() {
        Intent k = new Intent(help.this,MainActivity.class);
        startActivity(k);
    }
}
