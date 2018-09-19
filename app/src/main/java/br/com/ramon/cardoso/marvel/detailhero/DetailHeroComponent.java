package br.com.ramon.cardoso.marvel.detailhero;

import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroRepositoryComponent;
import br.com.ramon.cardoso.marvel.modules.ContextModule;
import br.com.ramon.cardoso.marvel.network.NoNetworkPresenterModule;
import br.com.ramon.cardoso.marvel.utils.FragmentScoped;
import dagger.Component;

/**
 * This is a Component to make a injection dependence.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@FragmentScoped
@Component(dependencies = {DetailHeroRepositoryComponent.class},modules = {DetailHeroPresenterModule.class, NoNetworkPresenterModule.class, ContextModule.class})
public interface DetailHeroComponent {

    void inject(DetailHeroActivity activity);
}
