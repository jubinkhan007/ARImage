package com.example.myar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_dashboard);
    }

    public void chair(View view) {
        Intent intent = new Intent(Dashboard.this,chair.class);
        startActivity(intent);

    }

    public void sofa(View view) {
        Intent intent = new Intent(Dashboard.this,Sofa.class);
        startActivity(intent);
    }

    public void table(View view) {
        Intent intent = new Intent(Dashboard.this,Table.class);
        startActivity(intent);
    }

    public void showcase(View view) {
        Intent intent = new Intent(Dashboard.this,Showcase.class);
        startActivity(intent);
    }

    public void bed(View view) {
        Intent intent = new Intent(Dashboard.this,Bed.class);
        startActivity(intent);
    }

    public void plane_book(View view) {
        Intent intent = new Intent(Dashboard.this,Armoire.class);
        startActivity(intent);
    }
}