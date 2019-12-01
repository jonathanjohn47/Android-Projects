public class BankAccount implements Loggable{

    private int accNo;
    private String name;

    public BankAccount(int accNo, String name) {
        this.accNo = accNo;
        this.name = name;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void log() {
        System.out.println("BA.log()");
    }

    @Override
    public void info() {
        System.out.println("BA.info()");
    }
}
