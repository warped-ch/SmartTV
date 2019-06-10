package org.dev.warped.smarttv;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.appcompat.widget.AppCompatImageButton;

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
