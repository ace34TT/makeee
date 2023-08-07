package com.aceky.makeee.binding;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.widget.EditText;
import androidx.databinding.BindingAdapter;

public class EditTextBindingAdapters {
    @BindingAdapter("errorColor")
    public static void setErrorColor(EditText editText, boolean showError) {
        Log.d("setting color : " , "set color red ");
        if (showError) {
            editText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        } else {
            // Reset the underline color to its default state
            editText.getBackground().clearColorFilter();
        }
    }
}
