package hrsoftware;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class PaymentManager {
    private Map<Integer, Double> payments; // Maps employee ID to their payment

    public PaymentManager() {
        this.payments = new HashMap<>();
    }

    // Calculate and update the payment for an employee based on hours worked
    public void calculatePayment(Employee employee) {
        if (employee.getClockInTime() == null || employee.getClockOutTime() == null) {
            System.out.println("Clock-in or clock-out time missing for employee ID " + employee.getId());
            return;
        }
        
        LocalTime clockIn = LocalTime.parse(employee.getClockInTime());
        LocalTime clockOut = LocalTime.parse(employee.getClockOutTime());
        long hoursWorked = ChronoUnit.HOURS.between(clockIn, clockOut);
        
        double payment = hoursWorked * employee.getPaymentPerHour();
        payments.put(employee.getId(), payment);
    }

    // Get the payment for an employee
    public double getPayment(int employeeId) {
        return payments.getOrDefault(employeeId, 0.0);
    }
}
