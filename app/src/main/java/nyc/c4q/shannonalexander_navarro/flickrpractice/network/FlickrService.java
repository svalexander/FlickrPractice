package nyc.c4q.shannonalexander_navarro.flickrpractice.network;

import nyc.c4q.shannonalexander_navarro.flickrpractice.models.FlickrResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shannonalexander-navarro on 7/23/17.
 */

public interface FlickrService {

    @GET("services/rest/?method=flickr.photos.search")
    Call<FlickrResponse> getSearchResults(@Query("api_key") String api_key, @Query("format") String json,
                                           @Query("nojsoncallback") int nojsoncallback, @Query("text") String searchTerm);
}
