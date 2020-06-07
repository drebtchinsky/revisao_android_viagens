package com.drebtchinsky.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.drebtchinsky.viagens.DAO.PacoteDAO;
import com.drebtchinsky.viagens.R;
import com.drebtchinsky.viagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle("Pacotes");

        inflateList();
    }

    private void inflateList() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        PacoteDAO dao = new PacoteDAO();
        listaPacotes.setAdapter(new ListaPacotesAdapter(dao.lista(),this));
    }
}