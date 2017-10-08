package com.example.katrindrozhak.carddata.presenter;

import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.networking.Service;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class PostPresenter {

    private final Service service;
    private CompositeDisposable compositeDisposable;
    private PresenterResult<Post> resultListener;

    public PostPresenter(Service service, PresenterResult<Post> listener) {
        this.service = service;
        resultListener = listener;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void showPostData(Integer i) {
        DisposableObserver<Post> subscription = service.getDisposablePost(i, resultListener);
        compositeDisposable.add(subscription);
    }
}
