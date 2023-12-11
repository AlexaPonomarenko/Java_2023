import java.util.ArrayList;

public class Department {
    private String name;
    private Employee headOfDepartment;
    private ArrayList<Employee> employees;

    public Department(String name, Employee headOfDepartment, ArrayList<Employee> employees) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public Employee getHeadOfDepartment() {
        return headOfDepartment;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department: " + name + ", Head: " + headOfDepartment + "; Employees: " + employees;
    }
}