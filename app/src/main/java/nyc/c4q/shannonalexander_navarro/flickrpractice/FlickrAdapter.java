package nyc.c4q.shannonalexander_navarro.flickrpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.flickrpractice.models.SinglePhoto;

/**
 * Created by shannonalexander-navarro on 7/23/17.
 */

public class FlickrAdapter extends RecyclerView.Adapter<FlickrViewHolder> {

    private List<SinglePhoto> imageResults = new ArrayList<>();

    public FlickrAdapter(List<SinglePhoto> imageResults) {
        this.imageResults = imageResults;
    }

    @Override
    public FlickrViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FlickrViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FlickrViewHolder flickrViewHolder, int position) {

        SinglePhoto anImage = imageResults.get(position);
        flickrViewHolder.bind(anImage);
    }

    @Override
    public int getItemCount() {
        return imageResults.size();
    }
}
