package com.example.katrindrozhak.carddata.presenter;

import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.networking.Service;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class TodoPresenter {

    private final Service service;
    private CompositeDisposable compositeDisposable;
    private PresenterResult<Todo> resultListener;

    public TodoPresenter(Service service, PresenterResult<Todo> listener) {
        this.service = service;
        resultListener = listener;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void showTodoData(Integer i) {
        DisposableObserver<Todo> subscription = service.getDisposableTodo(i, resultListener);
        compositeDisposable.add(subscription);
    }
}
