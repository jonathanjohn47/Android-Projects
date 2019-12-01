package in.bitcode.customview2;

public class Task {

    private int mId;
    private String mTitle;
    private boolean mIsDone;

    public Task( int id, String title, boolean isDone ) {
        mId = id;
        mTitle = title;
        mIsDone = isDone;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public boolean isIsDone() {
        return mIsDone;
    }

    public void setIsDone(boolean isDone) {
        this.mIsDone = isDone;
    }
}
