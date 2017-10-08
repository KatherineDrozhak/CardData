package com.example.katrindrozhak.carddata.viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.katrindrozhak.carddata.R;
import com.example.katrindrozhak.carddata.adapters.UserAdapter;
import com.example.katrindrozhak.carddata.models.User;
import com.example.katrindrozhak.carddata.views.IBaseView;

import java.util.List;

public class UserViewHolder extends RecyclerView.ViewHolder implements IBaseView<List<User>> {

    private RecyclerView recycler;

    public UserViewHolder(View itemView) {
        super(itemView);
        recycler = (RecyclerView) itemView.findViewById(R.id.recycler_view);
    }

    @Override
    public void show(Context context, List<User> model) {
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        UserAdapter adapter = new UserAdapter(context, model);
        recycler.setAdapter(adapter);
    }
}
