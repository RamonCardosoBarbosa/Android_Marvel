package br.com.ramon.cardoso.marvel.listheroes.data.source.remote;

import java.util.Map;

import br.com.ramon.cardoso.marvel.shared.MarvelListResponse;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * This interface contains all API's endpoints necessary to fetch the {@link SuperHero} list
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public interface ListHeroesAPI {

    @GET("v1/public/characters")
    Call<MarvelListResponse<SuperHero>> loadHeroes(@QueryMap Map<String, String> options);

}
