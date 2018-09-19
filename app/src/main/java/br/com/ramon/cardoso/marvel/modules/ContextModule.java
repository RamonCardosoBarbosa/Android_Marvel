package br.com.ramon.cardoso.marvel.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Module to make a injection dependence of a Context.
 *
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

@Module
public class ContextModule {

    private final Context mContext;

    /**
     * Instantiates a new Application module.
     *
     * @param context the context
     */
    public ContextModule(Context context) {
        mContext = context;
    }

    /**
     * Provide a context.
     *
     * @return the context
     */
    @Provides
    public Context provideContext() {
        return mContext;
    }

}
