package com.example.risajklerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

//tutaj 2 create
//implements method wszystkie
public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder> {
    private LayoutInflater inflater;
    private ListaProduktow listaProduktowObject = new ListaProduktow();
    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //wywolywana przez RecycleView w celu utworzenia nowego obiektu
        //przypisuje odpowiedni widok ale nie wypełnia widoku danymi
        View itemView = inflater.inflate(R.layout.item_produkt,parent,false);
        return new ProduktViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {
        //metoda wywoływana przez RecyclerView w celu wypełnienia danymi widoku
        holder.productTextView.setText(listaProduktowObject.ListaProduktow.get(position));
    }

    @Override
    public int getItemCount() {
        //zwraca liczbe elementow w calej liscie
        return listaProduktowObject.ListaProduktow.size();
    }
//tutaj pierwszy create
//implements konstructor
    public class ProduktViewHolder extends RecyclerView.ViewHolder{
    private TextView productTextView;
    ZakupyAdapter zakupyAdapter;
        public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            productTextView = itemView.findViewById(R.id.textView);
            this.zakupyAdapter = adapter;
        }
    }
}
