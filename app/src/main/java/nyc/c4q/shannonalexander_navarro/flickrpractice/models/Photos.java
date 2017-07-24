package nyc.c4q.shannonalexander_navarro.flickrpractice.models;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 7/23/17.
 */

public class Photos {

    private int page;
    private int pages;
    private int perpage;
    private long total;
    private List<SinglePhoto> photo;

    public Photos(int page, int pages, int perpage, long total, List<SinglePhoto> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public long getTotal() {
        return total;
    }

    public List<SinglePhoto> getPhoto() {
        return photo;
    }
}
