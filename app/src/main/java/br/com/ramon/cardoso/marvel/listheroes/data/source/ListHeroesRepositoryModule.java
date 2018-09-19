package br.com.ramon.cardoso.marvel.listheroes.data.source;

import javax.inject.Singleton;

import br.com.ramon.cardoso.marvel.listheroes.data.source.remote.ListHeroesRemoteDataSource;
import dagger.Binds;
import dagger.Module;

/**
 * This is a Module to make a injection dependence.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Module
abstract class ListHeroesRepositoryModule {

    @Singleton
    @Binds
    abstract ListHeroesDataSource provideDataSource(ListHeroesRemoteDataSource remoteDataSource);
}
