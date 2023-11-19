package organization;

import java.util.Arrays;

public class Department {
    private String name;
    private Employee[] employees;

    public Department(String name) {
        this.name = name;
        this.employees = new Employee[0];
    }

    public Department(Employee[] employees) {
        this.employees = Arrays.copyOf(employees, employees.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employees.length;
    }

    public int getTotalSalary() {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    public Employee getEmployeeByName(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    public void removeEmployee(String firstName, String lastName, String position) {
        Employee[] newEmployees = new Employee[employees.length - 1];
        int index = 0;
        for (Employee employee : employees) {
            if (!(employee.getFirstName().equals(firstName) &&
                    employee.getLastName().equals(lastName) &&
                    employee.getPosition().equals(position))) {
                newEmployees[index++] = employee;
            }
        }
        this.employees = newEmployees;
    }

    public void addEmployee(Employee employee) {
        employees = Arrays.copyOf(employees, employees.length + 1);
        employees[employees.length - 1] = employee;
    }

    public Employee[] getEmployees() {
        return Arrays.copyOf(employees, employees.length);
    }

    public Employee[] getSortedEmployees() {
        Employee[] sortedEmployees = Arrays.copyOf(employees, employees.length);
        Arrays.sort(sortedEmployees, (e1, e2) -> {
            int lastNameComparison = e1.getLastName().compareTo(e2.getLastName());
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }
            return e1.getFirstName().compareTo(e2.getFirstName());
        });
        return sortedEmployees;
    }
}
