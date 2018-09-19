package br.com.ramon.cardoso.marvel.splashscreen;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.modules.ContextModule;
import br.com.ramon.cardoso.marvel.network.NoNetworkPresenterModule;
import br.com.ramon.cardoso.marvel.utils.AbstractActivity;
import br.com.ramon.cardoso.marvel.utils.ActivityUtils;

/**
 * This is the activity responsible to start the splash use case
 * Creating all necessary injection and views.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class SplashActivity extends AbstractActivity {

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashFragment fragment = ActivityUtils.addMainFragmentToActivity(this, SplashFragment.class, getRootLayout());
        DaggerSplashComponent.builder()
                .splashPresenterModule(new SplashPresenterModule(fragment))
                .contextModule(new ContextModule(this))
                .noNetworkPresenterModule(new NoNetworkPresenterModule(noNetworkFragment))
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
