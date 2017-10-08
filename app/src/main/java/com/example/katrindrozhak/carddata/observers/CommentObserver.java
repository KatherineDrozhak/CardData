package com.example.katrindrozhak.carddata.observers;

import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class CommentObserver {

    public DisposableObserver<Comment> commentObserver(final PresenterResult<Comment> listener) {
        return new DisposableObserver<Comment>() {
            @Override
            public void onNext(@NonNull Comment comment) {
                if (listener != null) {
                    listener.onSuccess(comment);
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
