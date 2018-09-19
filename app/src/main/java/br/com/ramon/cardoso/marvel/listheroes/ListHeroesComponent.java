package br.com.ramon.cardoso.marvel.listheroes;

import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesRepositoryComponent;
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
@Component(dependencies = {ListHeroesRepositoryComponent.class}, modules = {ListHeroesPresenterModule.class, NoNetworkPresenterModule.class, ContextModule.class})
public interface ListHeroesComponent {

    void inject(ListHeroesActivity activity);
}
