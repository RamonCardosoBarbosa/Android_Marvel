/*
 * Copyright (c) 2017. App Media S/A - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ramon Cardoso <ramon.cardoso@moving.com.br>, 9/19/17 10:35 AM
 *
 */

package br.com.ramon.cardoso.marvel.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import br.com.ramon.cardoso.marvel.R;

/**
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class ActivityUtils {

    public static <T> T addMainFragmentToActivity(@NonNull FragmentActivity activity, @NonNull Class<T> clazz, int rootLayout) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(rootLayout);

        if (fragment == null)
            fragment = Fragment.instantiate(activity, clazz.getName());

        addFragmentToActivity(activity, fragment, rootLayout);
        return (T) fragment;
    }

    public static void addFragmentToActivity(@NonNull FragmentActivity activity,
                                             @NonNull Fragment fragment, int frameId) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        if (!fragment.isAdded()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            transaction.add(frameId, fragment, fragment.getClass().toString());
            transaction.commit();
        }
    }

    public static void removeFragmentFromActivity(@NonNull FragmentActivity activity, @NonNull Fragment fragment) {
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();

        if (supportFragmentManager != null && fragment.isAdded() && !activity.isDestroyed() && !activity.isFinishing())
            try {
                supportFragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                        .remove(fragment)
                        .commit();
            } catch (Exception ignored) {
            }
    }

}