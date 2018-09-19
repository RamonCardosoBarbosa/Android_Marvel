package br.com.ramon.cardoso.marvel.listheroes.data.source;

import javax.inject.Singleton;

import br.com.ramon.cardoso.marvel.modules.ContextModule;
import br.com.ramon.cardoso.marvel.modules.NetworkModule;
import dagger.Component;

/**
 * This is a Component to make a injection dependence.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Singleton
@Component(modules = {ListHeroesRepositoryModule.class, NetworkModule.class, ContextModule.class})
public interface ListHeroesRepositoryComponent {

    ListHeroesRepository getRepository();
}
