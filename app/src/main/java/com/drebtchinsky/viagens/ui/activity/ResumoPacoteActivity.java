package com.drebtchinsky.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.drebtchinsky.viagens.R;
import com.drebtchinsky.viagens.model.Pacote;
import com.drebtchinsky.viagens.utils.DiasUtil;
import com.drebtchinsky.viagens.utils.MoedaUtil;
import com.drebtchinsky.viagens.utils.ResourcesUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do Pacote");

        bindResumo();
    }

    private void bindResumo() {
        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        carregaInfo(R.id.resumo_pacote_imagem, ResourcesUtil.getDrawable(this, pacote.getImagem()));

        carregaInfo(R.id.resumo_pacote_local, pacote.getLocal());

        carregaInfo(R.id.resumo_pacote_data, DiasUtil.formataPeriodo(pacote.getDias()));

        carregaInfo(R.id.resumo_pacote_preco, MoedaUtil.formataEmTexto(pacote.getPreco()));

        carregaInfo(R.id.resumo_pacote_dias, DiasUtil.formataEmTexto(pacote.getDias()));
    }

    private void carregaInfo(int p, Drawable d) {
        ImageView imagem = findViewById(p);
        Drawable drawableImagemPacote = d;
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void carregaInfo(int p, String s) {
        TextView dias = findViewById(p);
        String textoDias = s;
        dias.setText(textoDias);
    }
}