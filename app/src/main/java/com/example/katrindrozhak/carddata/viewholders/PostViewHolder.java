package com.example.katrindrozhak.carddata.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.katrindrozhak.carddata.R;
import com.example.katrindrozhak.carddata.SpannableText;
import com.example.katrindrozhak.carddata.models.Post;
import com.example.katrindrozhak.carddata.views.IBaseView;

public class PostViewHolder extends RecyclerView.ViewHolder implements IBaseView<Post> {
    public EditText editText;
    public Button confirmPost;
    private TextView postUserId;
    private TextView postId;
    private TextView titlePost;
    private TextView bodyPost;

    public PostViewHolder(View itemView) {
        super(itemView);

        editText = (EditText) itemView.findViewById(R.id.posts_value);
        confirmPost = (Button) itemView.findViewById(R.id.button_posts);
        postUserId = (TextView) itemView.findViewById(R.id.user_id_posts);
        postId = (TextView) itemView.findViewById(R.id.id_posts);
        titlePost = (TextView) itemView.findViewById(R.id.title_posts);
        bodyPost = (TextView) itemView.findViewById(R.id.body_posts);

    }

    private Spannable makeField(Context context, int titleStringId, String fieldValue) {
        String title = context.getString(titleStringId);
        return SpannableText.setupBoldText(title + fieldValue, 0, title.length());
    }

    @Override
    public void show(Context context, Post model) {
        postUserId.setText(makeField(context, R.string.user_id_text, model.getUserId().toString()));
        postId.setText(makeField(context, R.string.id_text, model.getId().toString()));
        titlePost.setText(makeField(context, R.string.title_text, model.getTitle()));
        bodyPost.setText(makeField(context, R.string.body_text, model.getBody()));
    }
}
