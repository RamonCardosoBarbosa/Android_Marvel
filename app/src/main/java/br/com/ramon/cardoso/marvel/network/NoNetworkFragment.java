package br.com.ramon.cardoso.marvel.network;


import android.animation.Animator;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.databinding.NoNetworkFragmentBinding;
import br.com.ramon.cardoso.marvel.utils.AbstractFragment;
import br.com.ramon.cardoso.marvel.utils.ActivityUtils;

/**
 * This fragment is responsible to bind the view
 * and logical of view's elements of no network use case
 * <p>
 * Is part of View on architecture MVP
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public class NoNetworkFragment extends AbstractFragment<NoNetwork.Presenter> implements NoNetwork.View, View.OnClickListener, Animator.AnimatorListener {

    private NoNetworkFragmentBinding binding;

    public NoNetworkFragment() {
    }

    public static NoNetworkFragment newInstance() {
        return new NoNetworkFragment();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.no_network_fragment;
    }

    @Override
    public void onCustomCreateView(ViewDataBinding view, ViewGroup container) {
        binding = (NoNetworkFragmentBinding) view;
        binding.setClickHandler(this);
        binding.noConnectionAnimation.addAnimatorListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mPresenter.isConnected() && getActivity() != null)
            ActivityUtils.removeFragmentFromActivity(getActivity(), NoNetworkFragment.this);
        else
            binding.noConnectionAnimation.playAnimation();
    }

    @Override
    public void onAnimationStart(Animator animator) {
        binding.noConnectionText.setVisibility(View.INVISIBLE);
        binding.tryAgainButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        binding.noConnectionText.setVisibility(View.VISIBLE);
        binding.tryAgainButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
