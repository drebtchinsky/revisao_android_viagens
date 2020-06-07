package com.drebtchinsky.viagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.drebtchinsky.viagens.utils.DiasUtil;
import com.drebtchinsky.viagens.utils.MoedaUtil;
import com.drebtchinsky.viagens.R;
import com.drebtchinsky.viagens.utils.ResourcesUtil;
import com.drebtchinsky.viagens.model.Pacote;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> lista;
    private final Context context;

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

        Pacote pacote = lista.get(position);

        carregaInfo(view,R.id.item_pacote_preco, MoedaUtil.formataEmTexto(pacote.getPreco()));
        carregaInfo(view,R.id.item_pacote_image, ResourcesUtil.getDrawable(context,pacote.getImagem()));
        carregaInfo(view,R.id.item_pacote_dias, DiasUtil.formataEmTexto(pacote.getDias()));
        carregaInfo(view,R.id.item_pacote_local, pacote.getLocal());

        return view;
    }

    private void carregaInfo(View view, int p, Drawable d) {
        ImageView imagem = view.findViewById(p);
        Drawable drawableImagemPacote = d;
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void carregaInfo(View view, int p, String s) {
        TextView dias = view.findViewById(p);
        String textoDias = s;
        dias.setText(textoDias);
    }
}
