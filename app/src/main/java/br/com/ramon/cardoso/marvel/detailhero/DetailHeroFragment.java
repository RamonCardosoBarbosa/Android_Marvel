package br.com.ramon.cardoso.marvel.detailhero;


import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.databinding.DetailHeroFragmentBinding;
import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.AbstractFragment;

/**
 * This fragment is responsible to bind the view
 * and logical of view's elements of show hero use case
 *
 * Is part of View on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public class DetailHeroFragment extends AbstractFragment<DetailHero.Presenter> implements DetailHero.View {

    private DetailHeroFragmentBinding binding;

    public DetailHeroFragment() {
    }

    public static DetailHeroFragment newInstance(int hero) {
        Bundle args = new Bundle();
        args.putInt("param_hero_id", hero);
        DetailHeroFragment fragment = new DetailHeroFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.detail_hero_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCustomCreateView(ViewDataBinding view, ViewGroup container) {
        binding = (DetailHeroFragmentBinding) view;
        binding.comicRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.comicRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.comicRecycler.addItemDecoration(new DividerItemDecoration(binding.comicRecycler.getContext(), DividerItemDecoration.VERTICAL));

        if (getArguments() != null) {
            int id = getArguments().getInt("param_hero_id");
            mPresenter.loadHero(id);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            DetailHeroActivity activity = (DetailHeroActivity) getActivity();
            activity.setSupportActionBar(binding.toolbar);
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
                binding.toolbar.setTitle("Teste");
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home && getActivity() != null) {
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showHero(SuperHero hero) {
        binding.setHero(hero);
    }

    @Override
    public void showComics(List<Comic> comics) {
        binding.comicRecycler.setAdapter(new ComicAdapter(comics));
        binding.loadAnimation.cancelAnimation();
        binding.loadAnimation.setVisibility(View.GONE);
        binding.contentScrool.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyComics() {
        binding.comicRecycler.setAdapter(new ComicAdapter(null));
        binding.emptyComicLayout.setVisibility(View.VISIBLE);
        binding.contentScrool.setVisibility(View.VISIBLE);
        binding.loadAnimation.cancelAnimation();
        binding.loadAnimation.setVisibility(View.GONE);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
