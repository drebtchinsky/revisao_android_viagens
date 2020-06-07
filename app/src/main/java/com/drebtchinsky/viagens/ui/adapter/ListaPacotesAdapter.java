package com.drebtchinsky.viagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.drebtchinsky.viagens.R;
import com.drebtchinsky.viagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> lista;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);


        ImageView imagem = view.findViewById(R.id.item_pacote_image);
        TextView local = view.findViewById(R.id.item_pacote_local);
        TextView dias = view.findViewById(R.id.item_pacote_dias);
        TextView preco = view.findViewById(R.id.item_pacote_preco);

        Pacote pacote = lista.get(position);
        Resources resources = context.getResources();
        int drawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(drawable);

        imagem.setImageDrawable(drawableImagemPacote);

        local.setText(pacote.getLocal());

        int qtdDias = pacote.getDias();
        String textoDias = pacote.getDias() + " dia" + (qtdDias > 1 ? "s" : "");
        dias.setText(textoDias);

        NumberFormat brFormat = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        BigDecimal pacotePreco = pacote.getPreco();
        String moedaBr = brFormat.format(pacotePreco).replace("R$","R$ ");
        preco.setText(moedaBr);

        return view;
    }
}
