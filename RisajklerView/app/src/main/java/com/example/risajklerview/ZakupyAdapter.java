package com.example.risajklerview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

//tutaj 2 create
//implements method wszystkie
public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder> {

    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //wywolywana przez RecycleView w celu utworzenia nowego obiektu
        //przypisuje odpowiedni widok ale nie wypełnia widoku danymi
        View itemView = inflater_
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
//tutaj pierwszy create
//implements konstructor
    public class ProduktViewHolder extends RecyclerView.ViewHolder{
        public ProduktViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}