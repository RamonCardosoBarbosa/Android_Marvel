package br.com.ramon.cardoso.marvel.listheroes.data.source;

import android.support.annotation.Nullable;

import java.util.List;

import br.com.ramon.cardoso.marvel.shared.SuperHero;

/**
 * This interface is the contract to establish the communication between
 * the {@link br.com.ramon.cardoso.marvel.listheroes.ListHeroesPresenter}
 * and {{@link br.com.ramon.cardoso.marvel.listheroes.data.source.remote.ListHeroesRemoteDataSource}}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public interface ListHeroesDataSource {

    void loadHeroes(String query, Callback callback);

    interface Callback {
        void onHeroesLoaded(@Nullable List<SuperHero> heroes);

        void showCommunicationError();
    }
}
