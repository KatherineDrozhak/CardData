package com.example.katrindrozhak.carddata.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.katrindrozhak.carddata.R;
import com.example.katrindrozhak.carddata.models.Photo;
import com.example.katrindrozhak.carddata.views.IBaseView;
import com.squareup.picasso.Picasso;

public class PhotoViewHolder extends RecyclerView.ViewHolder implements IBaseView<Photo> {
    private ImageView image;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.photo);
    }

    @Override
    public void show(Context context, Photo model) {
        Picasso.with(context)
                .load(model.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(image);
    }
}
