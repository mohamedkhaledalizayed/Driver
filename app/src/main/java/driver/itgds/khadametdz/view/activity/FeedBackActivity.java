package driver.itgds.khadametdz.view.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import java.util.ArrayList;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.view.adapter.FeedBackAdapter;


public class FeedBackActivity extends AppCompatActivity {

    private FeedBackAdapter mAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("FeedBack");

        recyclerView=findViewById(R.id.feed_back_recycler);
        mAdapter = new FeedBackAdapter(this,new ArrayList<String>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }



}
