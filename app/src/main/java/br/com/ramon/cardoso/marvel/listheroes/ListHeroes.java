package br.com.ramon.cardoso.marvel.listheroes;

import java.util.List;

import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.BasePresenter;
import br.com.ramon.cardoso.marvel.utils.BaseView;

/**
 * This is the contract to establish the communication between
 * {@link ListHeroesFragment} and {@link ListHeroesPresenter}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public interface ListHeroes {

    interface View extends BaseView<Presenter> {
        void showHeroes(List<SuperHero> heroes);

        void showLoadHeroes();

        void showEmptyHeroes();

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void loadHeroes(String query);
    }
}
