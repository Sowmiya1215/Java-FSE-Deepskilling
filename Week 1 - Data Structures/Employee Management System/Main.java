public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);

        Employee e1 = new Employee(101, "Alice", "Manager", 70000);
        Employee e2 = new Employee(102, "Bob", "Developer", 55000);
        Employee e3 = new Employee(103, "Carol", "Tester", 50000);

        system.addEmployee(e1);
        system.addEmployee(e2);
        system.addEmployee(e3);

        System.out.println("All Employees:");
        system.traverseEmployees();

        System.out.println("\nSearching for employee with ID 102:");
        Employee found = system.searchEmployee(102);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID 101:");
        system.deleteEmployee(101);

        System.out.println("\nEmployees after deletion:");
        system.traverseEmployees();
    }
}
