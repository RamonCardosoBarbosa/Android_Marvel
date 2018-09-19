package br.com.ramon.cardoso.marvel.detailhero.data.source;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This class know where is the data the was requested by {
 * @link br.com.ramon.cardoso.marvel.detailhero.DetailHeroPresenter}
 * and know if the data is either web or local storage.
 *
 * If has both location of storage the {@link br.com.ramon.cardoso.marvel.detailhero.DetailHeroPresenter}
 * don't need to know where is the data, only need call this class.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Singleton
public class DetailHeroRepository implements DetailHeroDataSource {

    private final DetailHeroDataSource dataSource;

    @Inject
    public DetailHeroRepository(DetailHeroDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadHero(int id, Callback callback) {
        dataSource.loadHero(id, callback);
    }

    @Override
    public void loadComics(int id, Callback callback) {
        dataSource.loadComics(id, callback);
    }
}