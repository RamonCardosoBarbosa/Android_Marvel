package br.com.ramon.cardoso.marvel.listheroes;

import android.os.Bundle;
import android.support.v7.widget.SearchView;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.listheroes.data.source.DaggerListHeroesRepositoryComponent;
import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesRepositoryComponent;
import br.com.ramon.cardoso.marvel.modules.ContextModule;
import br.com.ramon.cardoso.marvel.modules.NetworkModule;
import br.com.ramon.cardoso.marvel.network.NoNetworkPresenterModule;
import br.com.ramon.cardoso.marvel.utils.AbstractActivity;
import br.com.ramon.cardoso.marvel.utils.ActivityUtils;

/**
 * This is the activity responsible to start the list heroes use case
 * Creating all necessary injection and views.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public class ListHeroesActivity extends AbstractActivity {

    @Inject
    ListHeroesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListHeroesFragment fragment = ActivityUtils.addMainFragmentToActivity(this, ListHeroesFragment.class, getRootLayout());
        ContextModule contextModule = new ContextModule(this);

        ListHeroesRepositoryComponent repositoryComponent = DaggerListHeroesRepositoryComponent.builder()
                .contextModule(contextModule)
                .networkModule(new NetworkModule(getString(R.string.base_url)))
                .build();

        DaggerListHeroesComponent.builder()
                .listHeroesPresenterModule(new ListHeroesPresenterModule(fragment))
                .contextModule(contextModule)
                .noNetworkPresenterModule(new NoNetworkPresenterModule(noNetworkFragment))
                .listHeroesRepositoryComponent(repositoryComponent)
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.default_activity;
    }

    @Override
    public int getRootLayout() {
        return R.id.rootLayout;
    }

}
