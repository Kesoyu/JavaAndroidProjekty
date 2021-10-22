package com.example.lista_zakupow_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Product> products = new ArrayList<>();
    private RecyclerView zakupyRecyclerView;
    private ZakupyAdapter zakupyAdapter;
    private SharedPreferences listaSharedPrefences;

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
//        products.add(new Product("Mleko"));
//        products.add(new Product("Chleb"));
        listaSharedPrefences = getPreferences(MODE_PRIVATE);
        products = odczytajSharedPrefrences();
        zakupyRecyclerView = findViewById(R.id.recyclerview);
        zakupyAdapter = new ZakupyAdapter(this,products);
        zakupyRecyclerView.setAdapter(zakupyAdapter);
        zakupyRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
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
    private void zapiszSharedPreferences(){
        SharedPreferences.Editor editor = listaSharedPrefences.edit();
        Gson gson = new Gson();
        String listaGson = gson.toJson(products);
        editor.putString("LISTA_Z",listaGson);
        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zapiszSharedPreferences();
    }
    //deserializcaja danych
    private ArrayList<Product> odczytajSharedPrefrences(){
        String gsonLista = listaSharedPrefences.getString("LISTA_Z","");
        Gson gson = new Gson();
        Type typ = new TypeToken<List<Product>>(){}.getType();
        ArrayList<Product> productsFromGson = gson.fromJson(gsonLista,typ);
        if(productsFromGson == null){
            productsFromGson=new ArrayList<>();
        }
        return  productsFromGson;
    }
}