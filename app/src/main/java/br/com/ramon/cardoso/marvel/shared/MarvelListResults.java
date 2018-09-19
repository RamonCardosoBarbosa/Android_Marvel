package br.com.ramon.cardoso.marvel.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the API Response Results Model
 *
 * This class is generic because in all response there is equals parts
 * <p>
 * Is part of the Model on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class MarvelListResults<T> {

    private List<T> results = new ArrayList<>();

    public List<T> getResults() {
        return results;
    }

}
