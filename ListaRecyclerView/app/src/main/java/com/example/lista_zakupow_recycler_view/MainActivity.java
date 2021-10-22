package com.example.lista_zakupow_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Product> products = new ArrayList<>();
    private RecyclerView zakupyRecyclerView;
    private ZakupyAdapter zakupyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        modyfikujemy build gradle ten modułowy
//        xml dodajemy recycler view
//        widok dla kazdego itemka
//        gettery settery toString()adpter
//        konstucktor adaptera
//        create class ProduktViewHolder
//        -implements method
//        main activity wypełnienie RecyclerView itemami
        products.add(new Product("Mleko"));
        products.add(new Product("Chleb"));
        zakupyRecyclerView = findViewById(R.id.recyclerview);
        zakupyAdapter = new ZakupyAdapter(this,products);
        zakupyRecyclerView.setAdapter(zakupyAdapter);
        zakupyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button dodajButton = (Button) findViewById(R.id.button);
        dodajButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dodawanie elemtu z textView do arraylist produkty
                EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String nazwaProduktu=String.valueOf(editText.getText());
                //Odzczytywanie pola tekstowego
                if(!nazwaProduktu.isEmpty()){
                    zakupyAdapter.dodajProdukt(new Product(nazwaProduktu));
                    editText.setText("");
                }
            }
        });
        Button usunZaznaczoneElementy = (Button) findViewById(R.id.button2);
        usunZaznaczoneElementy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //usuwanie zaznaczonych elementow listy
                zakupyAdapter.usunZlisty();
            }
        });
    }
}