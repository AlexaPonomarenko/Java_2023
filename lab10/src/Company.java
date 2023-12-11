import java.util.ArrayList;

public class Company {
    private String name;
    private Employee ceo;
    private ArrayList<Department> departments;

    public Company(String name, Employee ceo, ArrayList<Department> departments) {
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

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "Company: " + name + "; CEO: " + ceo + ";\nDepartments: " + departments;
    }
}