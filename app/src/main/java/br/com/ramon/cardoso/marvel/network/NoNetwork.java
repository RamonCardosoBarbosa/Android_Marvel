package br.com.ramon.cardoso.marvel.network;

import br.com.ramon.cardoso.marvel.utils.BasePresenter;
import br.com.ramon.cardoso.marvel.utils.BaseView;

/**
 * This is the contract to establish the communication between
 * {@link NoNetworkFragment} and {@link NoNetworkPresenter}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public interface NoNetwork {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
