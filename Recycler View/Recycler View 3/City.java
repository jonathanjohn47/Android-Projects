package in.bitcode.recyclerview1;

public class City {

    private String mName;
    private int mImageId;


    public City(String name, int imageId) {
        this.mName = name;
        this.mImageId = imageId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }
}
