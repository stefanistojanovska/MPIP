package com.wp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wp.adapters.CustomListAdapter;
import com.wp.db.Repository;
import com.wp.holders.CustomListViewHolder;
import com.wp.models.Movie;
import com.wp.models.MovieList;
import com.wp.service.MoviesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.logging.Logger;

public class MoviesActivity extends AppCompatActivity {

    CustomListAdapter adapter;
    Repository repository;
    MoviesService service;
    MovieList movieList;

    Logger logger = Logger.getLogger("MoviesActivity");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logger.info("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
       // initListView();

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
                initData(query);
                initListView();



                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });




        return true;
    }
    public void initData(String query) {
       Call<MovieList> call = service.getMovieList(query,"3db28c7f");
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList movies = response.body();
               for(Movie m:movies.getData())
               {
                   repository.insert(m);
                   //movieList.add(m);
               }


                initListView();

            }


            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }

        });
    }

    public void initListView(){
        RecyclerView recyclerView =  findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CustomListAdapter(getItemViewOnClickListener(),movieList);
        recyclerView.setAdapter(adapter);




    }

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