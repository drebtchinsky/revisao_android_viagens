package com.drebtchinsky.viagens.utils;

import com.drebtchinsky.viagens.model.Pacote;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DiasUtil {

    public static final String DIA = " dia";
    public static final String DIAS = " dias";

    public static String formataEmTexto(int dias) {
        return dias + (dias > 1 ? DIAS : DIA);
    }

    public static String formataPeriodo(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = formatoBr.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBr.format(dataVolta.getTime());
        String dataFormatadaPacote = dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
        return dataFormatadaPacote;
    }
}
