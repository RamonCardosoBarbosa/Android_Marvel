package br.com.ramon.cardoso.marvel.detailhero;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Module to make a injection dependence.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

@Module
public class DetailHeroPresenterModule {

    private final DetailHero.View mView;

    public DetailHeroPresenterModule(DetailHero.View view) {
        mView = view;
    }

    @Provides
    DetailHero.View providesView() {
        return mView;
    }
}
