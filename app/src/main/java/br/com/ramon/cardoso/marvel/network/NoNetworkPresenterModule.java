package br.com.ramon.cardoso.marvel.network;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Module to make a injection dependence of No network use case.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

@Module
public class NoNetworkPresenterModule {

    private final NoNetwork.View mView;

    public NoNetworkPresenterModule(NoNetwork.View view) {
        mView = view;
    }

    @Provides
    NoNetwork.View providesView() {
        return mView;
    }
}
