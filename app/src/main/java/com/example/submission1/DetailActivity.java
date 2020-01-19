package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOUNT = "EXTRA MOUNT";

    ImageView ivDetail;
    TextView tvName, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail");

        ivDetail= findViewById(R.id.dtl_photo);
        tvName= findViewById(R.id.dtl_name);
        tvDescription= findViewById(R.id.dtl_description);

        Mount mount = getIntent().getParcelableExtra(EXTRA_MOUNT);

        assert mount != null;
        Glide.with(getApplicationContext())
                .load(mount.getPhoto())
                .into(ivDetail);
        tvName.setText(mount.getName());
        tvDescription.setText(mount.getFrom());

    }
}
