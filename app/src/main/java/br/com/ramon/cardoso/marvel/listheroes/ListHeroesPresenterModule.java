package br.com.ramon.cardoso.marvel.listheroes;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Module to make a injection dependence.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

@Module
public class ListHeroesPresenterModule {

    private final ListHeroes.View mView;

    public ListHeroesPresenterModule(ListHeroes.View view) {
        mView = view;
    }

    @Provides
    ListHeroes.View providesView() {
        return mView;
    }
}
