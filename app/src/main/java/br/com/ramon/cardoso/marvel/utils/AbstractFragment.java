package br.com.ramon.cardoso.marvel.utils;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This class contains all base implementation for a fragment
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public abstract class AbstractFragment<T> extends Fragment implements BaseView<T> {
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding inflate = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        onCustomCreateView(inflate, container);
        return inflate.getRoot();
    }

    @Override
    public void showNetworkError() {
        if (getActivity() != null && getActivity() instanceof AbstractActivity)
            ((AbstractActivity) getActivity()).showNetworkError();
    }

    @Override
    public void setPresenter(T presenter) {
        mPresenter = presenter;
    }

    public abstract int getLayoutRes();

    public abstract void onCustomCreateView(ViewDataBinding view, ViewGroup container);
}
