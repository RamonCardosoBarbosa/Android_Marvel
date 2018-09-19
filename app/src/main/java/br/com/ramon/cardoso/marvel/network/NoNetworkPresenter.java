package br.com.ramon.cardoso.marvel.network;

import android.content.Context;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.utils.NetworkUtils;

/**
 * This is the presenter of show hero use case
 * is responsible to handler all users interactions and business rule
 * <p>
 * This class is part of Presenter on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class NoNetworkPresenter implements NoNetwork.Presenter {

    private final NoNetwork.View mView;
    private final Context mContext;

    @Inject
    NoNetworkPresenter(NoNetwork.View view, Context context) {
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
}
