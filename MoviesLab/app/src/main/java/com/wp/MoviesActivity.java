package com.wp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wp.adapters.CustomListAdapter;
import com.wp.holders.CustomListViewHolder;
import com.wp.viewmodels.MovieViewModel;

import java.util.logging.Logger;

public class MoviesActivity extends AppCompatActivity {
    //private RecyclerView recyclerView;
    CustomListAdapter adapter;
    //private List<Movie> movieList;
    //private Repository repository;
    Logger logger = Logger.getLogger("MoviesActivity");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logger.info("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        initListView();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                initData();


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });




        return true;
    }
    public void initData() {
        MovieViewModel moviesViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

       moviesViewModel.getAll().observe(this, data -> {
            adapter.updateDataset(data);
        });

    };
    public void initListView(){
        RecyclerView recyclerView =  findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomListAdapter(getItemViewOnClickListener());
        recyclerView.setAdapter(adapter);

    };
    private View.OnClickListener getItemViewOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomListViewHolder holder = (CustomListViewHolder) v.getTag();
                Long selectedTrackId = adapter.getClickedItemId(holder);


            }
        };
    }











}