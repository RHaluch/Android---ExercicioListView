package com.example.exerciciolistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Item>{

    private int rId;

    public ListaAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Item item = getItem(position);

        TextView textNome = mView.findViewById(R.id.textProduto);
        TextView textQuantidade = mView.findViewById(R.id.textQuantidade);

        textNome.setText(item.getNome());
        textQuantidade.setText(item.getQuantidade()+" - "+item.getTipo());
        if(item.isPrioridade()){
            textNome.setTextColor(Color.RED);
            textQuantidade.setTextColor(Color.RED);
        }
        return mView;
    }

}
