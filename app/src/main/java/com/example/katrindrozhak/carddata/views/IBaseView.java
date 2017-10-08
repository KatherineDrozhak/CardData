package com.example.katrindrozhak.carddata.views;

import android.content.Context;

public interface IBaseView<T> {
    void show(Context context, T model);
}
