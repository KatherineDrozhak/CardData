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
import com.example.katrindrozhak.carddata.models.Comment;
import com.example.katrindrozhak.carddata.views.IBaseView;

public class CommentViewHolder extends RecyclerView.ViewHolder implements IBaseView<Comment> {

    public EditText commentEditText;
    public Button commentConfirmButton;
    private TextView postIdComment;
    private TextView commentId;
    private TextView commentName;
    private TextView commentEmail;
    private TextView commentBody;

    public CommentViewHolder(View itemView) {
        super(itemView);

        commentEditText = (EditText) itemView.findViewById(R.id.comments_value);
        commentConfirmButton = (Button) itemView.findViewById(R.id.button_comments);
        postIdComment = (TextView) itemView.findViewById(R.id.post_id_comments);
        commentId = (TextView) itemView.findViewById(R.id.comments_id);
        commentName = (TextView) itemView.findViewById(R.id.comments_name);
        commentEmail = (TextView) itemView.findViewById(R.id.comments_email);
        commentBody = (TextView) itemView.findViewById(R.id.comments_body);
    }

    private Spannable makeField(Context context, int titleStringId, String fieldValue) {
        String title = context.getString(titleStringId);
        return SpannableText.setupBoldText(title + fieldValue, 0, title.length());
    }

    @Override
    public void show(Context context, Comment model) {
        postIdComment.setText(makeField(context, R.string.post_id_text, model.getPostId().toString()));
        commentId.setText(makeField(context, R.string.id_text, model.getId().toString()));
        commentName.setText(makeField(context, R.string.name_text, model.getName()));
        commentEmail.setText(makeField(context, R.string.email_text, model.getEmail()));
        commentBody.setText(makeField(context, R.string.body_text, model.getBody()));
    }
}
