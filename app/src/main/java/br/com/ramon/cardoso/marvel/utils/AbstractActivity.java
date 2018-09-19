package br.com.ramon.cardoso.marvel.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import br.com.ramon.cardoso.marvel.network.NoNetworkFragment;
import br.com.ramon.cardoso.marvel.network.NoNetworkPresenter;

/**
 * This class contains all base implementation for a activity
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public abstract class AbstractActivity extends AppCompatActivity {

    @Inject
    protected NoNetworkPresenter noNetworkPresenter;
    protected NoNetworkFragment noNetworkFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        noNetworkFragment = NoNetworkFragment.newInstance();
    }

    public void showNetworkError() {
        if (noNetworkFragment != null && noNetworkFragment.mPresenter != null)
            ActivityUtils.addFragmentToActivity(this, noNetworkFragment, getRootLayout());
    }

    public abstract int getLayoutRes();

    public abstract int getRootLayout();
}
