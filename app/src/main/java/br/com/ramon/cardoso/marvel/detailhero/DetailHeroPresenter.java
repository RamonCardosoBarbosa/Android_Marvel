package br.com.ramon.cardoso.marvel.detailhero;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroDataSource;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroRepository;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.NetworkUtils;

/**
 * This is the presenter of show hero use case
 * is responsible to handler all users interactions and business rule
 * <p>
 * To fetch the data use the {@link DetailHeroRepository}
 * <p>
 * The {@link DetailHeroRepository}, {@link br.com.ramon.cardoso.marvel.detailhero.data.source.remote.DetailHeroRemoteDataSource}
 * and this class are part of Presenter on architecture MVP
 * <p>
 * All this classes are responsible together to handler all interactions, business rules and data(remote or local storage)
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class DetailHeroPresenter implements DetailHero.Presenter, DetailHeroDataSource.Callback {

    private final DetailHero.View mView;
    private final Context mContext;
    private final DetailHeroRepository mRepository;

    @Inject
    public DetailHeroPresenter(DetailHero.View view, Context context, DetailHeroRepository repository) {
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
    public void showCommunicationError() {
        mView.showNetworkError();
    }

    @Override
    public void loadHero(int id) {
        mRepository.loadHero(id, this);
        mRepository.loadComics(id, this);
    }

    @Override
    public void onHeroLoaded(SuperHero hero) {
        mView.showHero(hero);
    }

    @Override
    public void onComicsLoaded(List<Comic> comics) {
        if (comics != null && comics.size() > 0)
            mView.showComics(comics);
        else
            mView.showEmptyComics();
    }
}
