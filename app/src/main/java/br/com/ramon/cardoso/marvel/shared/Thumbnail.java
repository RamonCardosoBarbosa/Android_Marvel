package br.com.ramon.cardoso.marvel.shared;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import br.com.ramon.cardoso.marvel.R;

/**
 * This is the Super Hero or Comic thumbs Model
 * <p>
 * Is part of the Model on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class Thumbnail extends BaseObservable {

    private String path;
    private String extension;
    private String url;

    @BindingAdapter({"url"})
    public static void loadImage(ImageView view, String imageUrl) {
        RequestOptions options = new RequestOptions()
                .circleCrop()
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_action_person)
                .error(R.drawable.ic_action_person)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(options)
                .into(view);
    }

    @Bindable
    public String getUrl() {
        return path + "." + extension;
    }

}
