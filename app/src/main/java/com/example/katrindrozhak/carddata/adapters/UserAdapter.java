package com.example.katrindrozhak.carddata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.katrindrozhak.carddata.R;
import com.example.katrindrozhak.carddata.SpannableText;
import com.example.katrindrozhak.carddata.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> users) {
        super();
        this.context = context;
        userList = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.nameText.setText(makeField(R.string.name_text, user.getName()));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;

        ViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.text_name);
        }
    }

    private Spannable makeField(int titleStringId, String fieldValue) {
        String title = context.getString(titleStringId);
        return SpannableText.setupBoldText(title + fieldValue, 0, title.length());
    }
}
