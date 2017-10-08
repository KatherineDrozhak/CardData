package com.example.katrindrozhak.carddata.presenter;

import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.networking.Service;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class CommentPresenter {

    private final Service service;
    private CompositeDisposable compositeDisposable;
    private PresenterResult<Comment> resultListener;

    public CommentPresenter(Service service, PresenterResult<Comment> listener) {
        this.service = service;
        resultListener = listener;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void showCommentData(Integer i) {
        DisposableObserver<Comment> subscription = service.getDisposableComment(i, resultListener);
        compositeDisposable.add(subscription);
    }

}
