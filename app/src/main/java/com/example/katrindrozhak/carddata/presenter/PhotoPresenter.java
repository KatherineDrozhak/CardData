package com.example.katrindrozhak.carddata.presenter;

import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.networking.Service;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class PhotoPresenter {

    private final Service service;
    private CompositeDisposable compositeDisposable;
    private PresenterResult<Photo> resultListener;

    public PhotoPresenter(Service service, PresenterResult<Photo> listener) {
        this.service = service;
        resultListener = listener;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void showPhotoData(Integer i) {
        DisposableObserver<Photo> subscription = service.getDisposablePhoto(i, resultListener);
        compositeDisposable.add(subscription);
    }

}
