package com.example.katrindrozhak.carddata;

import com.example.katrindrozhak.carddata.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(FirstFragment firstFragment);
}
