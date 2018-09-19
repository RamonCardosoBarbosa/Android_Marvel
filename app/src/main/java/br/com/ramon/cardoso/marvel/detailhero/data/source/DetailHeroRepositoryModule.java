package br.com.ramon.cardoso.marvel.detailhero.data.source;

import javax.inject.Singleton;

import br.com.ramon.cardoso.marvel.detailhero.data.source.remote.DetailHeroRemoteDataSource;
import dagger.Binds;
import dagger.Module;

/**
 *  * This is a Module to make a injection dependence.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Module
abstract class DetailHeroRepositoryModule {

    @Singleton
    @Binds
    abstract DetailHeroDataSource provideDataSource(DetailHeroRemoteDataSource remoteDataSource);
}
