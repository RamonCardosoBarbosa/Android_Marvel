package br.com.ramon.cardoso.marvel.listheroes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.databinding.ListHeroesItemBinding;
import br.com.ramon.cardoso.marvel.detailhero.DetailHeroActivity;
import br.com.ramon.cardoso.marvel.shared.SuperHero;

/**
 * This is a adapter to show the {@link SuperHero} on a recycler view
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class ListHeroesAdapter extends RecyclerView.Adapter<ListHeroesAdapter.ListAdapterHolder> {

    private final Activity mActivity;
    private List<SuperHero> mDataSource;
    private LayoutInflater layoutInflater;

    public ListHeroesAdapter(List<SuperHero> dataSource, Activity activity) {
        mDataSource = dataSource;
        mActivity = activity;
    }

    @NonNull
    @Override
    public ListAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListHeroesItemBinding binding = ListHeroesItemBinding.inflate(layoutInflater, parent, false);
        return new ListAdapterHolder(binding, mActivity);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.binding.setHero(mDataSource.get(position));
        holder.binding.setHandler(holder);
    }

    @Override
    public int getItemCount() {
        return mDataSource != null ? mDataSource.size() : 0;
    }

    public class ListAdapterHolder extends RecyclerView.ViewHolder {

        private final ListHeroesItemBinding binding;
        private final Activity activity;

        ListAdapterHolder(final ListHeroesItemBinding itemBinding, Activity activity) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
            this.activity = activity;
        }

        public void onHeroClicked(SuperHero hero) {
            Intent intent = new Intent(mActivity, DetailHeroActivity.class);
            intent.putExtra(activity.getString(R.string.intent_hero_key), Integer.valueOf(hero.getId()));
            mActivity.startActivity(intent);
        }
    }
}
