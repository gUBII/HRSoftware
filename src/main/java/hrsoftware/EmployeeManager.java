package hrsoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    // Remove an employee by ID
    public boolean removeEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }

    // Update an employee
    public boolean updateEmployee(Employee updatedEmployee) {
        int index = findEmployeeIndexById(updatedEmployee.getId());
        if (index >= 0) {
            employees.set(index, updatedEmployee);
            return true;
        }
        return false;
    }

    // Find an employee by ID
    public Employee findEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Helper method to find an employee's index by ID
    private int findEmployeeIndexById(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
