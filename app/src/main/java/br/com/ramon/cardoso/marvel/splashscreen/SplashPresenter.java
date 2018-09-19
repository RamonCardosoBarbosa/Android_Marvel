package br.com.ramon.cardoso.marvel.splashscreen;

import android.content.Context;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.utils.NetworkUtils;

/**
 * This is the presenter of splash hero use case
 * is responsible to handler all users interactions and business rule
 * <p>
 * This class is part of Presenter on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class SplashPresenter implements Splash.Presenter {

    private final Splash.View mView;
    private final Context mContext;

    @Inject
    SplashPresenter(Splash.View view, Context context) {
        mView = view;
        mContext = context;
    }

    @Inject
    @Override
    public void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public boolean isConnected() {
        return NetworkUtils.isConnected(mContext);
    }

    @Override
    public int timeToWait() {
        return 3000;
    }
}
