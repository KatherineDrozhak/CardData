package com.example.katrindrozhak.carddata.presenter;

import com.example.katrindrozhak.carddata.models.User;
import com.example.katrindrozhak.carddata.networking.Service;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class UsersPresenter {

    private final Service service;
    private CompositeDisposable compositeDisposable;
    private PresenterResult<List<User>> resultListener;

    public UsersPresenter(Service service, PresenterResult<List<User>> listener) {
        this.service = service;
        resultListener = listener;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void showUsersData() {
        DisposableObserver<List<User>> subscription = service.getDisposableUsers(resultListener);
        compositeDisposable.add(subscription);
    }
}
