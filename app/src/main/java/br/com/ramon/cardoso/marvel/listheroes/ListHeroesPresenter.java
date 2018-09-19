package br.com.ramon.cardoso.marvel.listheroes;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesDataSource;
import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesRepository;
import br.com.ramon.cardoso.marvel.utils.NetworkUtils;

/**
 * This is the presenter of show hero use case
 * is responsible to handler all users interactions and business rule
 * <p>
 * To fetch the data use the {@link ListHeroesRepository}
 * <p>
 * The {@link ListHeroesRepository}, {@link br.com.ramon.cardoso.marvel.listheroes.data.source.remote.ListHeroesRemoteDataSource}
 * and this class are part of Presenter on architecture MVP
 * <p>
 * All this classes are responsible together to handler all interactions, business rules and data(remote or local storage)
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class ListHeroesPresenter implements ListHeroes.Presenter, ListHeroesDataSource.Callback {

    private final ListHeroes.View mView;
    private final Context mContext;
    private final ListHeroesRepository mRepository;

    @Inject
    public ListHeroesPresenter(ListHeroes.View view, Context context, ListHeroesRepository repository) {
        mView = view;
        mContext = context;
        mRepository = repository;
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
    public void loadHeroes(String query) {
        mView.showLoadHeroes();
        mRepository.loadHeroes(query, this);
    }

    @Override
    public void onHeroesLoaded(List<SuperHero> heroes) {
        if (heroes != null && heroes.size() > 0)
            mView.showHeroes(heroes);
        else
            mView.showEmptyHeroes();
    }

    @Override
    public void showCommunicationError() {
        mView.showNetworkError();
    }
}
