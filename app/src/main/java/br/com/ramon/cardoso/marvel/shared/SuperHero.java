package br.com.ramon.cardoso.marvel.shared;

import android.databinding.BaseObservable;

/**
 * This is the Super Hero Model
 * <p>
 * Is part of the Model on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class SuperHero extends BaseObservable {

    private int id;
    private String name;
    private String description;
    private Thumbnail thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

}
