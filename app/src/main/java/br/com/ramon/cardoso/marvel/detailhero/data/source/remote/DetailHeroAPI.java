package br.com.ramon.cardoso.marvel.detailhero.data.source.remote;

import java.util.Map;

import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.shared.MarvelListResponse;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * This interface contains all API's endpoints necessary to fetch the {@link SuperHero} and {@link Comic} details
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
public interface DetailHeroAPI {

    @GET("/v1/public/characters/{id}")
    Call<MarvelListResponse<SuperHero>> loadHero(@Path("id") int heroId,
                                                 @QueryMap Map<String, String> options);

    @GET("/v1/public/characters/{id}/comics")
    Call<MarvelListResponse<Comic>> loadComics(@Path("id") int heroId,
                                               @QueryMap Map<String, String> options);
}
