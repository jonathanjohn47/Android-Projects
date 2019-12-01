public class Emp {

    private int id;
    private String name;
    private int sal;

    public Emp(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + sal;
    }
}



class EmpComparator implements Comparator{

    public int compare( Object o1, Object o2 ) {

        Emp e1 = (Emp) o1;
        Emp e2 = (Emp) o2;

        if( e1.getSal() == e2.getSal() ) {
            return 0;
        }

        if( e1.getSal() > e2.getSal() ) {
            return 1;
        }

        return -1;
    }
}

class EmpNameComparator implements Comparator {

    public int compare( Object o1, Object o2 ) {

        Emp e1 = (Emp) o1;
        Emp e2 = (Emp) o2;

        return e1.getName().compareTo( e2.getName() );

    }
}
