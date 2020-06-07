package com.drebtchinsky.viagens.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.drebtchinsky.viagens.model.Pacote;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int drawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(drawable);
    }
}
