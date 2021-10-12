package com.example.risajklerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView zakupyRecyclerView;
    private ZakupyAdapter zakupyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zakupyRecyclerView = findViewById(R.id.recyclerView);
        ListaProduktow listaProduktow = new ListaProduktow();
        zakupyAdapter = new ZakupyAdapter(this, listaProduktow);
        zakupyRecyclerView.setAdapter(zakupyAdapter);
        zakupyRecyclerView.setAdapter((zakupyAdapter));
        zakupyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}