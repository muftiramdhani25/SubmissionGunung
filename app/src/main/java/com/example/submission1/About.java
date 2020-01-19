package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class About extends AppCompatActivity {

    ImageView imgAbout;
    TextView tvName, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("My Profile");

        imgAbout = findViewById(R.id.iv_about);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);

        Glide.with(getApplicationContext())
                .load(R.drawable.about)
                .into(imgAbout);
    }
}
