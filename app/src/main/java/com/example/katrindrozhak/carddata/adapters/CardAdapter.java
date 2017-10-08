package com.example.katrindrozhak.carddata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.katrindrozhak.carddata.OnShowDetailsListener;
import com.example.katrindrozhak.carddata.R;
import com.example.katrindrozhak.carddata.viewholders.CommentViewHolder;
import com.example.katrindrozhak.carddata.viewholders.PhotoViewHolder;
import com.example.katrindrozhak.carddata.viewholders.PostViewHolder;
import com.example.katrindrozhak.carddata.viewholders.TodoViewHolder;
import com.example.katrindrozhak.carddata.viewholders.UserViewHolder;
import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.models.User;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Post post;
    private Comment comment;
    private Photo photo;
    private Todo todo;
    private OnShowDetailsListener detailsListener;
    private Context context;
    private List<User> users;

    public CardAdapter(Context context) {
        super();
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_card, parent, false);
                return new PostViewHolder(view);
            case 1:
                View viewComment = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_card, parent, false);
                return new CommentViewHolder(viewComment);
            case 2:
                View viewPhoto = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_card, parent, false);
                return new PhotoViewHolder(viewPhoto);
            case 3:
                View viewTodo = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
                return new TodoViewHolder(viewTodo);
            case 4:
                View viewUsers = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_card, parent, false);
                return new UserViewHolder(viewUsers);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder == null) {
            return;
        }

        switch (holder.getItemViewType()) {
            case 0:
                final PostViewHolder postViewHolder = (PostViewHolder) holder;
                postViewHolder.confirmPost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer value = Integer.valueOf(postViewHolder.editText.getText().toString());
                        postDetail(position, value);
                    }
                });
                if (post != null) {
                    postViewHolder.showResponse(context, post);
                }
                break;
            case 1:
                final CommentViewHolder commentViewHolder = (CommentViewHolder) holder;
                commentViewHolder.commentConfirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer value = Integer.valueOf(commentViewHolder.commentEditText.getText().toString());
                        postDetail(position, value);
                    }
                });

                if (comment != null) {
                    commentViewHolder.showCommentResponse(context, comment);
                }
                break;

            case 2:
                final PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
                if (photo != null) {
                    photoViewHolder.showImage(context, photo);
                }
                break;
            case 3:
                final TodoViewHolder todoViewHolder = (TodoViewHolder) holder;
                if (todo != null) {
                    todoViewHolder.showResponseTodo(context, todo);
                }
                break;
            case 4:
                final UserViewHolder userVIewHolder = (UserViewHolder) holder;
                if (users != null) {
                    userVIewHolder.showResult(context, users);
                }
                break;
        }

    }

    private void postDetail(int type, int id) {
        detailsListener.onShow(type, id);
    }

    public void setPost(Post post) {
        this.post = post;
        notifyDataSetChanged();
    }

    public void setComment(Comment comment) {
        this.comment = comment;
        notifyDataSetChanged();
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        notifyDataSetChanged();
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
        notifyDataSetChanged();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public void setDetailsListener(OnShowDetailsListener listener) {
        this.detailsListener = listener;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}
