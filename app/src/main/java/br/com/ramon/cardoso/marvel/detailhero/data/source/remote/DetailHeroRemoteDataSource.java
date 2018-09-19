package br.com.ramon.cardoso.marvel.detailhero.data.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.common.collect.ImmutableMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.ramon.cardoso.marvel.R;
import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroDataSource;
import br.com.ramon.cardoso.marvel.shared.MarvelListResponse;
import br.com.ramon.cardoso.marvel.shared.SuperHero;
import br.com.ramon.cardoso.marvel.utils.Requests;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * This class is responsible of establish the communication
 * with API and to fetch and parse the {@link SuperHero} and {{@link Comic}}
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */
@Singleton
public class DetailHeroRemoteDataSource implements DetailHeroDataSource {

    private final Retrofit mRetrofit;
    private final Context mContext;

    @Inject
    public DetailHeroRemoteDataSource(Retrofit retrofit, Context context) {
        mRetrofit = retrofit;
        mContext = context;
    }

    @Override
    public void loadHero(int id, final Callback callback) {
        String[] keys = {"apikey", "hash", "ts"};
        Object[] values = {mContext.getString(R.string.api_key),
                mContext.getString(R.string.api_hash),
                mContext.getString(R.string.api_timestamp)};

        ImmutableMap<String, String> options = Requests.buildParams(keys, values);

        Call<MarvelListResponse<SuperHero>> queue = mRetrofit.create(DetailHeroAPI.class).loadHero(id, options);
        queue.enqueue(new retrofit2.Callback<MarvelListResponse<SuperHero>>() {
            @Override
            public void onResponse(@NonNull Call<MarvelListResponse<SuperHero>> call, @NonNull Response<MarvelListResponse<SuperHero>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getData() != null && response.body().getData().getResults() != null && response.body().getData().getResults().size() > 0) {
                    callback.onHeroLoaded(response.body().getData().getResults().get(0));
                } else
                    callback.showCommunicationError();
            }

            @Override
            public void onFailure(Call<MarvelListResponse<SuperHero>> call, Throwable t) {
                callback.showCommunicationError();
            }
        });
    }

    @Override
    public void loadComics(int id, final Callback callback) {
        String[] keys = {"apikey", "hash", "ts"};
        Object[] values = {mContext.getString(R.string.api_key),
                mContext.getString(R.string.api_hash),
                mContext.getString(R.string.api_timestamp)};

        ImmutableMap<String, String> options = Requests.buildParams(keys, values);

        Call<MarvelListResponse<Comic>> queue = mRetrofit.create(DetailHeroAPI.class).loadComics(id, options);
        queue.enqueue(new retrofit2.Callback<MarvelListResponse<Comic>>() {
            @Override
            public void onResponse(@NonNull Call<MarvelListResponse<Comic>> call, @NonNull Response<MarvelListResponse<Comic>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getData() != null && response.body().getData().getResults() != null && response.body().getData().getResults().size() > 0) {
                    callback.onComicsLoaded(response.body().getData().getResults());
                } else
                    callback.onComicsLoaded(null);
            }

            @Override
            public void onFailure(Call<MarvelListResponse<Comic>> call, Throwable t) {
                callback.showCommunicationError();
            }
        });
    }
}
