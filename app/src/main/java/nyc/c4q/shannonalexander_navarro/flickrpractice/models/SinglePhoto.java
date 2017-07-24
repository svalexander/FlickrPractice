package nyc.c4q.shannonalexander_navarro.flickrpractice.models;

/**
 * Created by shannonalexander-navarro on 7/23/17.
 */

public class SinglePhoto {

private long id;
    private String owner;
    private String secret;
    private long server;
    private int farm;
    private String title;
    private int ispublic;
    private int isfriend;
    private int isfamily;

    public SinglePhoto(long id, String owner, String secret, long server, int farm, String title, int ispublic, int isfriend, int isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }

    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getSecret() {
        return secret;
    }

    public long getServer() {
        return server;
    }

    public int getFarm() {
        return farm;
    }

    public String getTitle() {
        return title;
    }

    public int getIspublic() {
        return ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }
}
