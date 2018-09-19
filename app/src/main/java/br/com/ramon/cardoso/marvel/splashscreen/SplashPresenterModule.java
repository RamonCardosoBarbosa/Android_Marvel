package br.com.ramon.cardoso.marvel.splashscreen;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Module to make a injection dependence of No splash use case.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

@Module
public class SplashPresenterModule {

    private final Splash.View mView;

    public SplashPresenterModule(Splash.View view) {
        mView = view;
    }

    @Provides
    Splash.View providesView() {
        return mView;
    }
}
