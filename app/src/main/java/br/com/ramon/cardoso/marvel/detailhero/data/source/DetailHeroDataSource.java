package br.com.ramon.cardoso.marvel.detailhero.data.source;

import java.util.List;

import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.shared.SuperHero;

/**
 * This interface is the contract to establish the communication between the {@link br.com.ramon.cardoso.marvel.detailhero.DetailHeroPresenter}
 * and {{@link br.com.ramon.cardoso.marvel.detailhero.DetailHeroPresenter}}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public interface DetailHeroDataSource {

    void loadHero(int id, Callback callback);

    void loadComics(int id, Callback callback);

    interface Callback {

        void onHeroLoaded(SuperHero hero);

        void onComicsLoaded(List<Comic> comics);

        void showCommunicationError();
    }

}
