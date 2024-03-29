package hrsoftware;

import java.util.HashMap;
import java.util.Map;

public class ShiftManager {
    private Map<Integer, String> shiftTimes; // Maps employee ID to their shift time

    public ShiftManager() {
        this.shiftTimes = new HashMap<>();
    }

    // Assign a shift time to an employee
    public void assignShift(int employeeId, String shiftTime) {
        shiftTimes.put(employeeId, shiftTime);
    }

    // Remove a shift assignment
    public boolean removeShift(int employeeId) {
        if (shiftTimes.containsKey(employeeId)) {
            shiftTimes.remove(employeeId);
            return true;
        }
        return false;
    }

    // Get an employee's shift time
    public String getShiftTime(int employeeId) {
        return shiftTimes.getOrDefault(employeeId, "No shift assigned");
    }
}
