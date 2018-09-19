package br.com.ramon.cardoso.marvel;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import br.com.ramon.cardoso.marvel.listheroes.ListHeroes;
import br.com.ramon.cardoso.marvel.listheroes.ListHeroesPresenter;
import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesDataSource;
import br.com.ramon.cardoso.marvel.listheroes.data.source.ListHeroesRepository;
import br.com.ramon.cardoso.marvel.listheroes.data.source.remote.ListHeroesRemoteDataSource;
import br.com.ramon.cardoso.marvel.shared.SuperHero;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class ListHeroesTest {

    @Mock
    private ListHeroesRepository mRepository;

    @Mock
    private ListHeroesRemoteDataSource mDataSource;

    @Mock
    private ListHeroes.View mView;

    @Mock
    private Context mContext;

    @Mock
    private ListHeroesDataSource.Callback mCallback;

    private ListHeroesPresenter mPresenter;

    @Before
    public void setupMocksAndView() {
        MockitoAnnotations.initMocks(this);
        when(mView.isActive()).thenReturn(true);
    }

    @Test
    public void test_show_list_load_list_UI() {
        mPresenter = new ListHeroesPresenter(mView, mContext, mRepository);
        mPresenter.loadHeroes("spider");
        verify(mView).showLoadHeroes();
    }

    @Test
    public void test_show_list_result_UI() {
        mRepository = new ListHeroesRepository(mDataSource);
        mPresenter = new ListHeroesPresenter(mView, mContext, mRepository);

        final List<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(new SuperHero());
        superHeroes.add(new SuperHero());
        superHeroes.add(new SuperHero());

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mPresenter.onHeroesLoaded(superHeroes);
                return null;
            }
        }).when(mDataSource).loadHeroes("spider", mPresenter);

        mPresenter.loadHeroes("spider");

        verify(mView).showHeroes(superHeroes);
    }

    @Test
    public void test_show_empty_list_result_UI() {
        mRepository = new ListHeroesRepository(mDataSource);
        mPresenter = new ListHeroesPresenter(mView, mContext, mRepository);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mPresenter.onHeroesLoaded(null);
                return null;
            }
        }).when(mDataSource).loadHeroes("spider", mPresenter);

        mPresenter.loadHeroes("spider");

        verify(mView).showEmptyHeroes();
    }

}
