package com.drebtchinsky.viagens.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LANGUAGE = "pt";
    public static final String COUNTRY = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_IDEAL = "R$ ";

    public static String formataEmTexto(BigDecimal preco) {
        NumberFormat brFormat = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE, COUNTRY));
        BigDecimal pacotePreco = preco;
        return brFormat.format(pacotePreco).replace(FORMATO_PADRAO, FORMATO_IDEAL);
    }
}
