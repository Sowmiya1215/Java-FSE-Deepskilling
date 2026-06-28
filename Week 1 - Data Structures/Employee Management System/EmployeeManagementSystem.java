public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
        } else {
            System.out.println("Employee array is full!");
        }
    }
    public Employee searchEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                return employees[i];
            }
        }
        return null;
    }
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
    public void deleteEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                System.out.println("Employee " + empId + " deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
