package com.example.katrindrozhak.carddata.observers;

import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class PostObserver {

    public DisposableObserver<Post> postObserver(final PresenterResult<Post> listener) {
        return new DisposableObserver<Post>() {
            @Override
            public void onNext(@NonNull Post post) {
                if (listener != null) {
                    listener.onSuccess(post);
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
