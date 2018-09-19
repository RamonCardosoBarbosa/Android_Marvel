package br.com.ramon.cardoso.marvel.detailhero;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.ramon.cardoso.marvel.databinding.ComicItemBinding;
import br.com.ramon.cardoso.marvel.detailhero.data.Comic;

/**
 * This is a adapter to show the {@link Comic} on a recycler view
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ListAdapterHolder> {

    private List<Comic> mDataSource;
    private LayoutInflater layoutInflater;

    public ComicAdapter(List<Comic> dataSource) {
        mDataSource = dataSource;
    }

    @NonNull
    @Override
    public ListAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ComicItemBinding binding = ComicItemBinding.inflate(layoutInflater, parent, false);
        return new ListAdapterHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.binding.setComic(mDataSource.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSource != null ? mDataSource.size() : 0;
    }

    class ListAdapterHolder extends RecyclerView.ViewHolder {

        private final ComicItemBinding binding;

        ListAdapterHolder(final ComicItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}
