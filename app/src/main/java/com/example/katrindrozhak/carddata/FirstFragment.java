package com.example.katrindrozhak.carddata;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.katrindrozhak.carddata.adapters.CardAdapter;
import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.models.User;
import com.example.katrindrozhak.carddata.networking.Service;
import com.example.katrindrozhak.carddata.presenter.CommentPresenter;
import com.example.katrindrozhak.carddata.presenter.PhotoPresenter;
import com.example.katrindrozhak.carddata.presenter.PostPresenter;
import com.example.katrindrozhak.carddata.presenter.PresenterResult;
import com.example.katrindrozhak.carddata.presenter.TodoPresenter;
import com.example.katrindrozhak.carddata.presenter.UsersPresenter;

import java.util.List;

import javax.inject.Inject;

public class FirstFragment extends BaseApp {
    private PostPresenter postPresenter;
    private CommentPresenter commentPresenter;
    private CardAdapter cardAdapter;
    public static final String DIALOG_TAG = "dialog";

    @Inject
    public Service service;
    private boolean isNotifiedAboutError = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_activity, container, false);

        getDeps().inject(this);
        return setUpRecyclerView(view);
    }

    private View setUpRecyclerView(View view) {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.container);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        cardAdapter = new CardAdapter(getActivity());
        cardAdapter.setDetailsListener(new OnShowDetailsListener() {
            @Override
            public void onShow(int type, int id) {
                switch (type) {
                    case 0:
                        postPresenter = new PostPresenter(service, new PresenterResult<Post>() {
                            @Override
                            public void onError() {
                                showErrorDialog();
                            }

                            @Override
                            public void onSuccess(Post result) {
                                cardAdapter.setPost(result);
                            }
                        });
                        postPresenter.showPostData(id);
                        break;
                    case 1:
                        commentPresenter = new CommentPresenter(service, new PresenterResult<Comment>() {
                            @Override
                            public void onError() {
                                showErrorDialog();
                            }

                            @Override
                            public void onSuccess(Comment result) {
                                cardAdapter.setComment(result);
                            }
                        });
                        commentPresenter.showCommentData(id);
                        break;

                }
            }
        });

        PhotoPresenter photoPresenter = new PhotoPresenter(service, new PresenterResult<Photo>() {

            @Override
            public void onError() {
                showErrorDialog();
            }

            @Override
            public void onSuccess(Photo result) {
                cardAdapter.setPhoto(result);
            }
        });
        photoPresenter.showPhotoData(3);

        TodoPresenter todoPresenter = new TodoPresenter(service, new PresenterResult<Todo>() {
            @Override
            public void onError() {
                showErrorDialog();
            }

            @Override
            public void onSuccess(Todo result) {
                cardAdapter.setTodo(result);
            }
        });

        todoPresenter.showTodoData(getRandomInteger(1, 200));

        UsersPresenter usersPresenter = new UsersPresenter(service, new PresenterResult<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                cardAdapter.setUsers(users);
            }

            @Override
            public void onError() {
                showErrorDialog();
            }
        });

        usersPresenter.showUsersData();

        recyclerView.setAdapter(cardAdapter);
        return recyclerView;

    }

    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    private void showErrorDialog() {
        if (!isNotifiedAboutError) {
            ErrorDialog errorDialog = new ErrorDialog();
            errorDialog.setCancelable(false);
            errorDialog.show(getActivity().getFragmentManager(), DIALOG_TAG);
            isNotifiedAboutError = true;
        }
    }
}
