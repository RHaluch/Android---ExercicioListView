package com.example.exerciciolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nome, quantidade;
    Button cadastrar;
    CheckBox prioridade;
    Spinner tipo;
    ListView list;
    List <Item> itens;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome=findViewById(R.id.nomeProduto);
        quantidade=findViewById(R.id.quantidade);
        prioridade = findViewById(R.id.checkPrioridade);
        cadastrar = findViewById(R.id.cadastrar);
        tipo = findViewById(R.id.tipoUnidade);
        list = findViewById(R.id.list);

    }

    @Override
    protected void onStart(){
        super.onStart();
        itens = new ArrayList<>();
        adapter = new ListaAdapter(getApplicationContext(),R.layout.list_item,itens);
        list.setAdapter(adapter);
    }

    public void cadastrar(View view) {
        Item item = new Item();
        item.setNome(nome.getText().toString());
        item.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
        item.setPrioridade(prioridade.isChecked());
        item.setTipo(tipo.getSelectedItem().toString());
        itens.add(item);

        adapter.notifyDataSetChanged();
    }
}
