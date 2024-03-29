package hrsoftware;

public class Employee {
    private int id;
    private String name;
    private double paymentPerHour;
    private String clockInTime;
    private String clockOutTime;
    private String shiftTime;
    
    // Constructor
    public Employee(int id, String name, double paymentPerHour) {
        this.id = id;
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPaymentPerHour() {
        return paymentPerHour;
    }
    
    public String getClockInTime() {
        return clockInTime;
    }
    
    public void setClockInTime(String clockInTime) {
        this.clockInTime = clockInTime;
    }
    
    public String getClockOutTime() {
        return clockOutTime;
    }
    
    public void setClockOutTime(String clockOutTime) {
        this.clockOutTime = clockOutTime;
    }
    
    public String getShiftTime() {
        return shiftTime;
    }
    
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }
}
