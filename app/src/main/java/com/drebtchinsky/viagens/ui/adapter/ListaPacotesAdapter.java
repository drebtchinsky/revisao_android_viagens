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

        exibeLocal(view, pacote);
        exibeDias(view, pacote);
        exibeImagem(view, pacote);
        exibePreco(view, pacote);

        return view;
    }

    private void exibePreco(View view, Pacote pacote) {
        TextView preco = view.findViewById(R.id.item_pacote_preco);
        String moedaBr = MoedaUtil.formataEmTexto(pacote.getPreco());
        preco.setText(moedaBr);
    }

    private void exibeImagem(View view, Pacote pacote) {
        ImageView imagem = view.findViewById(R.id.item_pacote_image);
        Drawable drawableImagemPacote = ResourcesUtil.getDrawable(context,pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void exibeDias(View view, Pacote pacote) {
        TextView dias = view.findViewById(R.id.item_pacote_dias);
        String textoDias = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(textoDias);
    }

    private void exibeLocal(View view, Pacote pacote) {
        TextView local = view.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
