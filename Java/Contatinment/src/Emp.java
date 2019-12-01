public class Emp {

    private int id;
    private String name;
    private int sal;

    private Date dob;

    //Rec
    public Emp( int id, String name, int sal, int day, int mon, int year ) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.dob = new Date( day, mon, year );
    }

    //Not recommended
    public Emp(int id, String name, int sal, Date dob) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.dob = new Date( dob.getDay(), dob.getMon(), dob.getYear() );
    }

    public void setDOB( int day, int mon, int year ) {
        //verification of emp docs and then decide
        if( year > 2001 ) {
            return;
        }
        dob.setDay( day );
        dob.setMon( mon );
        dob.setYear( year );
    }

    public void display() {
        System.out.println( id );
        System.out.println( name );
        System.out.println( sal );
        System.out.println( dob.getDay() + " " + dob.getMon() + " " + dob.getYear() );
    }

    public Date getDob() {

        //return dob; //not good

        //good
        Date dobCopy = new Date( dob.getDay(), dob.getMon(), dob.getYear() );
        return dobCopy;
    }
}
