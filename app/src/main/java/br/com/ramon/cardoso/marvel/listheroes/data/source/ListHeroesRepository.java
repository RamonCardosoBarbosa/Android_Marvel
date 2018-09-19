package br.com.ramon.cardoso.marvel.listheroes.data.source;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This class know where is the data the was requested by
 * {@link br.com.ramon.cardoso.marvel.listheroes.ListHeroesPresenter}
 * and know if the data is either web or local storage.
 *
 * If has both location of storage the {@link br.com.ramon.cardoso.marvel.detailhero.DetailHeroPresenter}
 * don't need to know where is the data, only need call this class.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Singleton
public class ListHeroesRepository implements ListHeroesDataSource {

    private final ListHeroesDataSource dataSource;

    @Inject
    public ListHeroesRepository(ListHeroesDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadHeroes(String query, Callback callback) {
        dataSource.loadHeroes(query, callback);
    }
}