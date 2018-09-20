package br.com.ramon.cardoso.marvel.splashscreen;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.view.ViewGroup;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.listheroes.ListHeroesActivity;
import br.com.ramon.cardoso.marvel.utils.AbstractFragment;

/**
 * This is the presenter of splash use case
 * is responsible to handler all users interactions and business rule
 * <p>
 * This class is part of Presenter on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public class SplashFragment extends AbstractFragment<Splash.Presenter> implements Splash.View {

    public SplashFragment() {
    }

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.splash_fragment;
    }

    @Override
    public void onCustomCreateView(final ViewDataBinding view, ViewGroup container) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mPresenter.isConnected())
                    startActivity(new Intent(getActivity(), ListHeroesActivity.class));
                if (getActivity() != null)
                    getActivity().finish();
                else
                    showNetworkError();
            }
        }, mPresenter.timeToWait());
    }
}
