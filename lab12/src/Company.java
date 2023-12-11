import java.util.HashSet;

public class Company {
    private String name;
    private Employee ceo;
    private HashSet<Department> departments;

    public Company(String name, Employee ceo, HashSet<Department> departments) {
        this.name = name;
        this.ceo = ceo;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public Employee getCEO() {
        return ceo;
    }

    public HashSet<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "Company: " + name + "; CEO: " + ceo + ";\nDepartments: " + departments;
    }
}