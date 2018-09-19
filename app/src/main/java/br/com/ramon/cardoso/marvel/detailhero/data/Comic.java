package br.com.ramon.cardoso.marvel.detailhero.data;

import br.com.ramon.cardoso.marvel.shared.Thumbnail;

/**
 * This is the comic model
 *
 * Is part of the Model on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class Comic {

    private Integer id;
    private String title;
    private Thumbnail thumbnail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
