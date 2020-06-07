package com.drebtchinsky.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.drebtchinsky.viagens.DAO.PacoteDAO;
import com.drebtchinsky.viagens.R;
import com.drebtchinsky.viagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITLE_APPBAR);

        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        PacoteDAO dao = new PacoteDAO();
        listaPacotes.setAdapter(new ListaPacotesAdapter(dao.lista(),this));
    }
}