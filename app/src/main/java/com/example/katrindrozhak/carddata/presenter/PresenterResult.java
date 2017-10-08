package com.example.katrindrozhak.carddata.presenter;

public interface PresenterResult<T> {

    void onError();

    void onSuccess(T result);
}
