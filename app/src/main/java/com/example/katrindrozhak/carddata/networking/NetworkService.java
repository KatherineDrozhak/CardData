package com.example.katrindrozhak.carddata.networking;

import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.models.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface NetworkService {

    @GET("/posts/{id}")
    Observable<Post> getPost(@Path("id") Integer id);

    @GET("/comments/{id}")
    Observable<Comment> getComment(@Path("id") Integer id);

    @GET("/users")
    Observable<List<User>> getUsers();

    @GET("/photos/{id}")
    Observable<Photo> getPhoto(@Path("id") Integer id);

    @GET("/todos/{id}")
    Observable<Todo> getTodo(@Path("id") Integer id);

}
