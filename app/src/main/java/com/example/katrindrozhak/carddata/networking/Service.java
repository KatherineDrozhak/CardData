package com.example.katrindrozhak.carddata.networking;

import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.models.User;
import com.example.katrindrozhak.carddata.observers.CommentObserver;
import com.example.katrindrozhak.carddata.observers.PhotoObserver;
import com.example.katrindrozhak.carddata.observers.PostObserver;
import com.example.katrindrozhak.carddata.observers.TodoObserver;
import com.example.katrindrozhak.carddata.observers.UsersObserver;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Service {

    private final NetworkService networkService;

    @Inject
    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public DisposableObserver<Post> getDisposablePost(Integer i, PresenterResult<Post> listener) {
        Observable<Post> call = networkService.getPost(i);
        return call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new PostObserver().postObserver(listener));
    }

    public DisposableObserver<Comment> getDisposableComment(Integer i, PresenterResult<Comment> listener) {
        Observable<Comment> call = networkService.getComment(i);
        return call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CommentObserver().commentObserver(listener));
    }

    public DisposableObserver<Todo> getDisposableTodo(Integer i, PresenterResult<Todo> listener) {
        Observable<Todo> call = networkService.getTodo(i);
        return call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new TodoObserver().todoObserver(listener));
    }

    public DisposableObserver<Photo> getDisposablePhoto(Integer i, PresenterResult<Photo> listener) {
        Observable<Photo> call = networkService.getPhoto(i);
        return call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new PhotoObserver().photoObserver(listener));
    }

    public DisposableObserver<List<User>> getDisposableUsers(PresenterResult<List<User>> listener) {
        Observable<List<User>> call = networkService.getUsers();

        return call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new UsersObserver().usersObserver(listener));

    }

}
