package com.example.weatherapptrial.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherapptrial.Adapters.HourlyAdapter;
import com.example.weatherapptrial.Domains.Hourly;
import com.example.weatherapptrial.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn = findViewById(R.id.next7dayBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TomorrowActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("10:00 pm", 27, "cloudy"));
        items.add(new Hourly("11:00 pm", 28, "sun"));
        items.add(new Hourly("12:00 pm", 29, "wind"));
        items.add(new Hourly("01:00 am", 28, "rainy"));
        items.add(new Hourly("02:00 am", 27, "storm"));


        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        //RecyclerView içerisine List itemlerini adapterden pozisyonsa göre çektirme.
        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);


    }
}