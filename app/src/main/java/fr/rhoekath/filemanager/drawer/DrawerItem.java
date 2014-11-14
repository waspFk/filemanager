package fr.rhoekath.filemanager.drawer;

import android.graphics.drawable.Drawable;

/**
 * Created by Mickael on 14/11/2014.
 */
public class DrawerItem {
    private final Drawable drawable;
    private final String textView;

    public DrawerItem(Drawable drawable, String textView) {
        this.drawable = drawable;
        this.textView = textView;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String getTextView() {
        return textView;
    }
}
