public class InvalidSalException extends Exception {

    private int sal;
    private long time;


    public InvalidSalException(int sal, long time, String message) {
        super( message );
        this.sal = sal;
        this.time = time;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " --> " + sal  + " " + time;
    }
}
