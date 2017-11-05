package org.dev.warped.smarttv;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatImageButton;

class VectorDrawableSupport {

    private VectorDrawableSupport() {
    }

    static void setTintList(AppCompatImageButton imageButton, @ColorRes int id) {
        ColorStateList tint = ContextCompat.getColorStateList(imageButton.getContext(), id);
        Drawable drawable = DrawableCompat.wrap(imageButton.getDrawable());
        DrawableCompat.setTintList(drawable, tint);
        drawable.mutate();
        imageButton.setImageDrawable(drawable);
    }
}
