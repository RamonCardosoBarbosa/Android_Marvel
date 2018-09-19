package br.com.ramon.cardoso.marvel.detailhero;

import java.util.List;

import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.BasePresenter;
import br.com.ramon.cardoso.marvel.utils.BaseView;

/**
 * This is the contract to establish the communication between
 * {@link DetailHeroFragment} and {@link DetailHeroPresenter}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public interface DetailHero {

    interface View extends BaseView<Presenter> {

        void showHero(SuperHero hero);

        void showComics(List<Comic> comics);

        void showEmptyComics();

        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void loadHero(int id);
    }
}
