package com.example.submission1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMount;
    private ArrayList<Mount> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMount =findViewById(R.id.rv_mount);
        rvMount.setHasFixedSize(true);

        list.addAll(MountData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMount.setLayoutManager(new LinearLayoutManager(this));
        ListMountAdapter listMountAdapter = new ListMountAdapter(list, getApplicationContext());
        rvMount.setAdapter(listMountAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        if (itemId == R.id.about){
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        }
    }
}
