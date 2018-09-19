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

import br.com.ramon.cardoso.marvel.detailhero.DetailHero;
import br.com.ramon.cardoso.marvel.detailhero.DetailHeroPresenter;
import br.com.ramon.cardoso.marvel.detailhero.data.Comic;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroDataSource;
import br.com.ramon.cardoso.marvel.detailhero.data.source.DetailHeroRepository;
import br.com.ramon.cardoso.marvel.detailhero.data.source.remote.DetailHeroRemoteDataSource;
import br.com.ramon.cardoso.marvel.shared.SuperHero;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Ramon Cardoso Barbosa (cardosoramonbarbosa@hotmail.com)
 * @since September/2018
 */

public class DetailHeroTest {

    @Mock
    private DetailHeroRepository mRepository;

    @Mock
    private DetailHeroRemoteDataSource mDataSource;

    @Mock
    private DetailHero.View mView;

    @Mock
    private Context mContext;

    @Mock
    private DetailHeroDataSource.Callback mCallback;

    private DetailHeroPresenter mPresenter;

    @Before
    public void setupMocksAndView() {
        MockitoAnnotations.initMocks(this);
        when(mView.isActive()).thenReturn(true);
    }

    @Test
    public void test_show_hero_UI() {
        mRepository = new DetailHeroRepository(mDataSource);
        mPresenter = new DetailHeroPresenter(mView, mContext, mRepository);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mPresenter.onHeroLoaded(new SuperHero());
                return null;
            }
        }).when(mDataSource).loadHero(1009610, mPresenter);

        mPresenter.loadHero(1009610);

        verify(mView).showHero(any(SuperHero.class));
    }

    @Test
    public void test_show_hero_comic_UI() {
        mRepository = new DetailHeroRepository(mDataSource);
        mPresenter = new DetailHeroPresenter(mView, mContext, mRepository);

        final List<Comic> comics = new ArrayList<>();
        comics.add(new Comic());
        comics.add(new Comic());
        comics.add(new Comic());

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mPresenter.onComicsLoaded(comics);
                return null;
            }
        }).when(mDataSource).loadComics(1009610, mPresenter);

        mRepository.loadComics(1009610, mPresenter);

        verify(mView).showComics(comics);
    }

    @Test
    public void test_show_hero_no_comic_UI() {
        mRepository = new DetailHeroRepository(mDataSource);
        mPresenter = new DetailHeroPresenter(mView, mContext, mRepository);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mPresenter.onComicsLoaded(null);
                return null;
            }
        }).when(mDataSource).loadComics(1009610, mPresenter);

        mPresenter.loadHero(1009610);

        verify(mView).showEmptyComics();
    }

}
