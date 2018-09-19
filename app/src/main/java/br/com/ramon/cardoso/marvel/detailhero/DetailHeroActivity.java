package br.com.ramon.cardoso.marvel.detailhero;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DaggerDetailHeroRepositoryComponent;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroRepositoryComponent;
import br.com.ramon.cardoso.marvel.modules.ContextModule;
import br.com.ramon.cardoso.marvel.modules.NetworkModule;
import br.com.ramon.cardoso.marvel.network.NoNetworkPresenterModule;
import br.com.ramon.cardoso.marvel.utils.AbstractActivity;
import br.com.ramon.cardoso.marvel.utils.ActivityUtils;


/**
 * This is the activity responsible to start the show hero use case
 * Creating all necessary injection and views.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public class DetailHeroActivity extends AbstractActivity {

    @Inject
    DetailHeroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextModule contextModule = new ContextModule(this);

        int hero = 0;
        if (getIntent().getExtras() != null)
            hero = getIntent().getExtras().getInt(getString(R.string.intent_hero_key));

        DetailHeroFragment fragment = DetailHeroFragment.newInstance(hero);
        ActivityUtils.addFragmentToActivity(this, fragment, getRootLayout());

        DetailHeroRepositoryComponent repositoryComponent = DaggerDetailHeroRepositoryComponent.builder()
                .contextModule(contextModule)
                .networkModule(new NetworkModule(getString(R.string.base_url)))
                .build();

        DaggerDetailHeroComponent.builder()
                .contextModule(contextModule)
                .noNetworkPresenterModule(new NoNetworkPresenterModule(noNetworkFragment))
                .detailHeroPresenterModule(new DetailHeroPresenterModule(fragment))
                .detailHeroRepositoryComponent(repositoryComponent)
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
