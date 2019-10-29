package edu.wmdd.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView urlsListView;
    static ArrayList<UrlItem> itemsArrayList = new ArrayList<UrlItem>();
    private UrlListAdapter urlListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        String sharedData = i.getStringExtra(Intent.EXTRA_TEXT);
        if(sharedData != null) {
            UrlItem urlItem = new UrlItem();
            urlItem.url = sharedData;
            itemsArrayList.add(urlItem);
        }

        urlsListView = findViewById(R.id.urlsListView);
        urlsListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                UrlItem item = (UrlItem) adapter.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("permalink", item.url);
                startActivity(intent);
            }
        });

        urlListAdapter = new UrlListAdapter(this, itemsArrayList);
        urlsListView.setAdapter(urlListAdapter);
    }
}
