package com.example.lista_zakupow_recycler_view;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder> {
    private ArrayList<Product> products;
    private LayoutInflater inflater;

    public ZakupyAdapter(Context context, ArrayList<Product> products) {
        inflater = LayoutInflater.from(context);
        this.products = products;
    }
    //dodawanie do listy zakpów
    //dodajemy do ArrayList produkty
    //aktaulizujemy wyświetlanie
    public void dodajProdukt(Product produkt){
        products.add(produkt);
        notifyItemInserted(products.size()-1);
    }
    //usuwanie z listy zakupów
    public void usunZlisty(){
        products.removeIf(x-> x.isZaznaczony());
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View produktItemView = (View) inflater.inflate(R.layout.item_recycler_view, parent, false);
        return new ProduktViewHolder(produktItemView,this);
        //zwracamy obiekt klasy produkt viewholder
        //do ktorego przekazujemy widok pojedyczego elemntu
        //elementu listy
        //łączymy z adaptera
    }//tutaj jest tworzony widok

    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {
        Product aktualnyProduct = products.get(position);
        holder.checkBoxItem.setText(aktualnyProduct.getNazwa());
        holder.checkBoxItem.setChecked(aktualnyProduct.isZaznaczony());
        holder.checkBoxItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                aktualnyProduct.setZaznaczony(b);
                if(b){
                    holder.checkBoxItem.setPaintFlags(holder.checkBoxItem.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    holder.checkBoxItem.setPaintFlags(holder.checkBoxItem.getPaintFlags()&~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });
    }//tutaj wiazemy dane

    @Override
    public int getItemCount() {
        return products.size();
    }//tutaj zwracamy liczbe elemtow do wyswietlenia

    public class ProduktViewHolder  extends  RecyclerView.ViewHolder {
        public CheckBox checkBoxItem;
        public final ZakupyAdapter zakupyAdapter;
        public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            this.checkBoxItem = itemView.findViewById(R.id.checkBox);
            this.zakupyAdapter = adapter;
        }
    }
}
//konstruktor adaptera
//create product view holder // extends RecyclerView.ViewHolder
//
//