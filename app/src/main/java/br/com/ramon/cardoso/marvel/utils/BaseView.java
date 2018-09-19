package br.com.ramon.cardoso.marvel.utils;

/**
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public interface BaseView<T> {

    void showNetworkError();

    void setPresenter(T presenter);
}
