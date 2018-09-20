package br.com.ramon.cardoso.marvel.listheroes;


import android.app.SearchManager;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.databinding.ListHeroesFragmentBinding;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.AbstractFragment;
import br.com.ramon.cardoso.marvel.utils.KeyboardUtils;

/**
 * This fragment is responsible to bind the view
 * and logical of view's elements of list heroes use case
 * <p>
 * Is part of View on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public class ListHeroesFragment extends AbstractFragment<ListHeroes.Presenter> implements ListHeroes.View, SearchView.OnQueryTextListener {

    private ListHeroesFragmentBinding binding;
    private SearchView searchView;

    public ListHeroesFragment() {
    }

    public static ListHeroesFragment newInstance() {
        return new ListHeroesFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_heroes_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ListHeroesActivity activity = (ListHeroesActivity) getActivity();
            activity.setSupportActionBar(binding.toolbar);
        }
    }

    @Override
    public void onCustomCreateView(ViewDataBinding view, ViewGroup container) {
        binding = (ListHeroesFragmentBinding) view;
        binding.listHeroesRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.listHeroesRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.listHeroesRecycler.addItemDecoration(new DividerItemDecoration(binding.listHeroesRecycler.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void showHeroes(List<SuperHero> heroes) {
        binding.indicateSearchViewLayout.setVisibility(View.GONE);
        binding.loadHeroesAnimation.setVisibility(View.GONE);
        binding.emptyHeroesLayout.setVisibility(View.GONE);

        binding.listHeroesRecycler.setVisibility(View.VISIBLE);
        binding.listHeroesRecycler.setAdapter(new ListHeroesAdapter(heroes, getActivity()));
    }

    @Override
    public void showLoadHeroes() {
        binding.loadHeroesAnimation.setVisibility(View.VISIBLE);
        binding.loadHeroesAnimation.playAnimation();

        binding.indicateSearchViewLayout.setVisibility(View.GONE);
        binding.listHeroesRecycler.setVisibility(View.GONE);
        binding.listHeroesRecycler.setAdapter(null);
        binding.emptyHeroesLayout.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyHeroes() {
        binding.indicateSearchViewLayout.setVisibility(View.GONE);
        binding.loadHeroesAnimation.setVisibility(View.GONE);
        binding.listHeroesRecycler.setVisibility(View.GONE);
        binding.listHeroesRecycler.setAdapter(null);
        binding.emptyHeroesLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        if (getActivity() != null) {
            getActivity().getMenuInflater().inflate(R.menu.list_heroes_menu, menu);

            SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
            searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
            if (searchManager != null) {
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
                searchView.setMaxWidth(Integer.MAX_VALUE);
                searchView.setOnQueryTextListener(this);

                searchView.setOnKeyListener(new View.OnKeyListener() {
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (event.getAction() == KeyEvent.ACTION_DOWN) {
                            switch (keyCode) {
                                case KeyEvent.KEYCODE_ENTER:
                                    mPresenter.loadHeroes(searchView.getQuery().toString());
                                    return false;
                                default:
                                    break;
                            }
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_search || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (query.length() >= 3) {
            mPresenter.loadHeroes(query);
            KeyboardUtils.hide(getActivity(), searchView);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (query.length() >= 3)
            mPresenter.loadHeroes(query);
        return true;
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
