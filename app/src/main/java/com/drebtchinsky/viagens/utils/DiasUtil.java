package com.drebtchinsky.viagens.utils;

import com.drebtchinsky.viagens.model.Pacote;

public class DiasUtil {

    public static final String DIA = " dia";
    public static final String DIAS = " dias";

    public static String formataEmTexto(int dias) {
        return dias + (dias > 1 ? DIAS : DIA);
    }
}
