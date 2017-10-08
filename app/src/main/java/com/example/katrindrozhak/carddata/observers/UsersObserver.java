package com.example.katrindrozhak.carddata.observers;

import com.example.katrindrozhak.carddata.models.User;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class UsersObserver {

    public DisposableObserver<List<User>> usersObserver(final PresenterResult<List<User>> listener) {
        return new DisposableObserver<List<User>>() {
            @Override
            public void onNext(@NonNull List<User> users) {
                if (listener != null) {
                    listener.onSuccess(users);
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
