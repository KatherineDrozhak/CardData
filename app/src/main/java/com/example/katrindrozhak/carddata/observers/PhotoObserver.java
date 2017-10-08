package com.example.katrindrozhak.carddata.observers;

import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class PhotoObserver {

    public DisposableObserver<Photo> photoObserver(final PresenterResult<Photo> listener) {
        return new DisposableObserver<Photo>() {
            @Override
            public void onNext(@NonNull Photo photo) {
                if (listener != null) {
                    listener.onSuccess(photo);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                listener.onError();
                e.printStackTrace();

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
