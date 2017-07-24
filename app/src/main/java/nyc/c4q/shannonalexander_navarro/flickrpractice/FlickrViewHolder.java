package nyc.c4q.shannonalexander_navarro.flickrpractice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nyc.c4q.shannonalexander_navarro.flickrpractice.models.SinglePhoto;

/**
 * Created by shannonalexander-navarro on 7/23/17.
 */

public class FlickrViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private final Context context;


    public FlickrViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        imageView = (ImageView) itemView.findViewById(R.id.resultIV);
    }

    public void bind(SinglePhoto anImage) {

        String photoUrl = "https://farm" + anImage.getFarm() + ".staticflickr.com/" + anImage.getServer() +
                "/" + anImage.getId() + "_" + anImage.getSecret() + ".jpg";

        Picasso.with(context).load(photoUrl).fit().centerInside().into(imageView);
    }
}
