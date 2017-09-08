package com.example.nttungpc.storyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lvStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvStory = (ListView) findViewById(R.id.lv_story);
        StoryAdapter storyAdapter = new StoryAdapter(this,R.layout.item_list_story,DatabaseHandle.getInstance(this).getListStory());
        DatabaseHandle.getInstance(this).getListStory();
        lvStory.setAdapter(storyAdapter);

    }
}
