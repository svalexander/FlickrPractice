package nyc.c4q.shannonalexander_navarro.flickrpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.flickrpractice.models.FlickrResponse;
import nyc.c4q.shannonalexander_navarro.flickrpractice.models.SinglePhoto;
import nyc.c4q.shannonalexander_navarro.flickrpractice.network.FlickrService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private FlickrAdapter flickrAdapter;
    private static final String BASE_URL = "https://api.flickr.com/";
    private static final String TAG = "success";
    private static final String API_KEY = BuildConfig.API_KEY;
    private List<SinglePhoto> flickrImages = new ArrayList<>();
    private EditText searchET;
    private Button saveBtn;
    private String searchTerm;
    Call<FlickrResponse> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchET = (EditText) findViewById(R.id.searchET);
        saveBtn = (Button) findViewById(R.id.enterBtn);
        getSearchTermOnClick();
        initRV();

    }

    @Override
    protected void onStart() {
        super.onStart();
        getFlickrJSON();
    }

    void getSearchTermOnClick() {

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchET.getText() != null) {
                    searchTerm = searchET.getText().toString();
                    //searchTerm = "slime";
                    Log.d("not blank et", searchTerm);

                } else {
                    searchTerm = "slime";
                    Log.d("blank et", searchTerm);
                }

                getFlickrJSON();
            }
        });
    }

    private void initRV() {
        rv = (RecyclerView) findViewById(R.id.resultRV);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        flickrAdapter = new FlickrAdapter(flickrImages);
        rv.setAdapter(flickrAdapter);
    }

    private void getFlickrJSON() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlickrService flickrService = retrofit.create(FlickrService.class);

        //Call<FlickrResponse> call = flickrService.getSearchResults(API_KEY, "json", 1, "slime");

        if (searchTerm != null) {
            call = flickrService.getSearchResults(API_KEY, "json", 1, searchTerm);

        } else {
            call = flickrService.getSearchResults(API_KEY, "json", 1, "slime");
        }

        call.enqueue(new Callback<FlickrResponse>() {
            @Override
            public void onResponse(Call<FlickrResponse> call, Response<FlickrResponse> response) {

                FlickrResponse flickrResponse = response.body();
                List<SinglePhoto> imageResults = flickrResponse.getPhotos().getPhoto();

                //this block of code will clear the data that I have in the rv and populate instead with what I am
                //getting from the API call; allows me to still have a working RV in case of failure
                flickrImages.clear();
                flickrImages.addAll(imageResults);
                flickrAdapter.notifyDataSetChanged();

                if (response.isSuccessful()) {
                    Log.d(TAG, "Success: " + flickrResponse.getPhotos().getPhoto().get(0).getTitle());
                } else {
                    try {
                        Log.d(TAG, "Error: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<FlickrResponse> call, Throwable t) {

                Log.e("FAILURE", "You got nothing " + call + t);
            }
        });
    }
}
