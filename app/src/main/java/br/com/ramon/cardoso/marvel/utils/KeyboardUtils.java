package br.com.ramon.cardoso.marvel.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class KeyboardUtils {

    public static void hide(Activity activity, View view) {
        view.clearFocus();
        InputMethodManager keyboard = (InputMethodManager)
                activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (keyboard != null)
            keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
