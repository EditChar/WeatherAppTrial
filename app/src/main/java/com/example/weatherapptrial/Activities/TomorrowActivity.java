package com.example.weatherapptrial.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;

import com.example.weatherapptrial.Adapters.TomorrowAdapter;
import com.example.weatherapptrial.Domains.TomorrowDomain;
import com.example.weatherapptrial.R;

import java.util.ArrayList;

public class TomorrowActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomorrow);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(TomorrowActivity.this,MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<TomorrowDomain> items= new ArrayList<>();

        items.add(new TomorrowDomain("Sat", "storm", "Storm", 25, 10));
        items.add(new TomorrowDomain("Sun", "cloudy", "Rainy-Sunny", 24, 16));
        items.add(new TomorrowDomain("Mon", "cloudy_3", "Cloudy", 27, 15));
        items.add(new TomorrowDomain("Tue", "cloudy_sunny", "Cloudy-Sunny", 22, 13));
        items.add(new TomorrowDomain("Wen", "sun", "Sunny", 29, 18));
        items.add(new TomorrowDomain("Thu", "rainy", "Rainy", 23, 11));
        items.add(new TomorrowDomain("Thu", "rainy", "Rainy", 23, 11));


        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        adapterTomorrow = new TomorrowAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}