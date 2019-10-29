package edu.wmdd.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView urlsListView;
    static ArrayList<String> itemsArrayList;
    private UrlListAdapter urlListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlsListView = findViewById(R.id.urlsListView);

        urlsListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                String item = (String) adapter.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(), item.getPermalink(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("permalink", item);
                startActivity(intent);
            }
        });
    }
}
