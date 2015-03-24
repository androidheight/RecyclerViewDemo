package program.androidheight.recyclerviewdemo;

/**
 * Created by PRABHU on 22-03-2015.
 */
public class RecyclerModal {
    private String name;
    private String number;
    private int imageUrl;

    public RecyclerModal(){

    }
    public RecyclerModal( String name,String number, int imageUrl) {
        super();
        this.imageUrl = imageUrl;
        this.name = name;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
