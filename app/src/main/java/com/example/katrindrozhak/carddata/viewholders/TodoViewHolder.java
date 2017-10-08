package com.example.katrindrozhak.carddata.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.View;
import android.widget.TextView;

import com.example.katrindrozhak.carddata.R;
import com.example.katrindrozhak.carddata.SpannableText;
import com.example.katrindrozhak.carddata.models.Todo;
import com.example.katrindrozhak.carddata.views.IBaseView;

public class TodoViewHolder extends RecyclerView.ViewHolder implements IBaseView<Todo> {
    private TextView userIdTodo;
    private TextView idTodo;
    private TextView titleTodo;
    private TextView completedTodo;

    public TodoViewHolder(View itemView) {
        super(itemView);

        userIdTodo = (TextView) itemView.findViewById(R.id.user_id_todo);
        idTodo = (TextView) itemView.findViewById(R.id.id_todo);
        titleTodo = (TextView) itemView.findViewById(R.id.title_todo);
        completedTodo = (TextView) itemView.findViewById(R.id.completed_todo);
    }

    private Spannable makeField(Context context, int titleStringId, String fieldValue) {
        String title = context.getString(titleStringId);
        return SpannableText.setupBoldText(title + fieldValue, 0, title.length());
    }

    @Override
    public void show(Context context, Todo model) {
        userIdTodo.setText(makeField(context, R.string.user_id_text, model.getUserId().toString()));
        idTodo.setText(makeField(context, R.string.id_text, model.getId().toString()));
        titleTodo.setText(makeField(context, R.string.title_text, model.getTitle()));
        completedTodo.setText(makeField(context, R.string.completed_text, model.getCompleted()));
    }
}
