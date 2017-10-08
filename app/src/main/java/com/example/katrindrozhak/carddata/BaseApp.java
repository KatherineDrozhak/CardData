package com.example.katrindrozhak.carddata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.katrindrozhak.carddata.networking.NetworkModule;

public class BaseApp extends Fragment {

    Deps deps;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deps = DaggerDeps.builder().networkModule(new NetworkModule()).build();
    }

    public Deps getDeps() {
        return deps;
    }
}
