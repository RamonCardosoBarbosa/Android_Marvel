package br.com.ramon.cardoso.marvel.listheroes.data.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.common.collect.ImmutableMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesDataSource;
import br.com.ramon.cardoso.marvel.shared.MarvelListResponse;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.Requests;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * This class is responsible of establish the communication
 * with API and to fetch and parse the {@link SuperHero} list
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Singleton
public class ListHeroesRemoteDataSource implements ListHeroesDataSource {

    private final Retrofit mRetrofit;
    private final Context mContext;

    @Inject
    public ListHeroesRemoteDataSource(Retrofit retrofit, Context context) {
        mRetrofit = retrofit;
        mContext = context;
    }

    @Override
    public void loadHeroes(String query, final Callback callback) {

        String[] keys = {"nameStartsWith", "apikey", "hash", "ts"};
        Object[] values = {query,
                mContext.getString(R.string.api_key),
                mContext.getString(R.string.api_hash),
                mContext.getString(R.string.api_timestamp)};

        ImmutableMap<String, String> options = Requests.buildParams(keys, values);

        Call<MarvelListResponse<SuperHero>> queue = mRetrofit.create(ListHeroesAPI.class).loadHeroes(options);
        queue.enqueue(new retrofit2.Callback<MarvelListResponse<SuperHero>>() {
            @Override
            public void onResponse(@NonNull Call<MarvelListResponse<SuperHero>> call, @NonNull Response<MarvelListResponse<SuperHero>> response) {
                if (response.isSuccessful() && response.body() != null)
                    callback.onHeroesLoaded(response.body().getData().getResults());
                else
                    callback.showCommunicationError();
            }

            @Override
            public void onFailure(Call<MarvelListResponse<SuperHero>> call, Throwable t) {
                callback.showCommunicationError();
            }
        });
    }
}
