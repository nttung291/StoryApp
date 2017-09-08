package com.example.nttungpc.storyapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nttung PC on 9/5/2017.
 */

public class StoryAdapter extends ArrayAdapter<StoryModel>{
    private static final String TAG = "decodeString";
    private Context context;
    private int resource;
    private List<StoryModel> storyModelList;

    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<StoryModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.storyModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource,parent,false);
        StoryModel storyModel = storyModelList.get(position);
        View viewBookmark = convertView.findViewById(R.id.v_bookmark);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = convertView.findViewById(R.id.tv_author);
        ImageView ivStoryimage = convertView.findViewById(R.id.iv_storyimage);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());
        Log.d(TAG, "getView: " + storyModel.getAuthor());

        String base64String = storyModel.getImage();
        String base64Image = base64String.split(",")[1];
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        ivStoryimage.setImageBitmap(decodedByte);

        return convertView;
    }
}
