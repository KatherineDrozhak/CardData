package com.example.katrindrozhak.carddata.observers;

import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class TodoObserver {

    public DisposableObserver<Todo> todoObserver(final PresenterResult<Todo> listener) {
        return new DisposableObserver<Todo>() {
            @Override
            public void onNext(@NonNull Todo todo) {
                if (listener != null) {
                    listener.onSuccess(todo);
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
