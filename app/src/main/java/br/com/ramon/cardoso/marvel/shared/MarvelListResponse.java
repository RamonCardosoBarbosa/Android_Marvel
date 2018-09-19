package br.com.ramon.cardoso.marvel.shared;

/**
 * This is the API Response Model
 *
 * This class is generic because in all response there is equals parts
 * <p>
 * Is part of the Model on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class MarvelListResponse<T> {

    private MarvelListResults<T> data;

    public MarvelListResults<T> getData() {
        return data;
    }

    public void setData(MarvelListResults<T> data) {
        this.data = data;
    }

}
