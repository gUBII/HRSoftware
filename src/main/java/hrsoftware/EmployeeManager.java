package hrsoftware;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private Map<Integer, Employee> employees;

    public EmployeeManager() {
        this.employees = new HashMap<>();
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        if (employee != null && !employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
        }
    }

    // Update an existing employee
    public void updateEmployee(int id, Employee updatedEmployee) {
        if (updatedEmployee != null && employees.containsKey(id)) {
            employees.put(id, updatedEmployee);
        }
    }

    // Delete an employee
    public void deleteEmployee(int id) {
        employees.remove(id);
    }

    // Retrieve an employee by ID
    public Employee getEmployee(int id) {
        return employees.get(id);
    }
    
    // Retrieve all employees
    public Map<Integer, Employee> getAllEmployees() {
        return new HashMap<>(employees);
    }
}
