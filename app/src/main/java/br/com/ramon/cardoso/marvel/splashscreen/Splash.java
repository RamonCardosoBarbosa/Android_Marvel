package br.com.ramon.cardoso.marvel.splashscreen;

import br.com.ramon.cardoso.marvel.utils.BasePresenter;
import br.com.ramon.cardoso.marvel.utils.BaseView;

/**
 * This is the contract to establish the communication between
 * {@link SplashFragment} and {@link SplashPresenter}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public interface Splash {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {

        int timeToWait();
    }
}
