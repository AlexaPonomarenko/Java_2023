import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    private final static String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hank", "Riley", "Sophia", "Liam", "Isabella", "Ethan"};
    private final static String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Turner", "Martinez", "Rodriguez", "Thompson"};

    public static void main(String[] args) {
        Company company = new Company("Big Company", generateEmployee(),
                new ArrayList<>(List.of(
                        new Department("IT Department", generateEmployee(),
                                new ArrayList<>(List.of(generateEmployee(), generateEmployee()))),
                        new Department("Finance Department", generateEmployee(),
                                new ArrayList<>(List.of(generateEmployee(), generateEmployee()))),
                        new Department("HR Department", generateEmployee(),
                                new ArrayList<>(List.of(generateEmployee(), generateEmployee())))
                )));

        System.out.println("Biggest salary in the company is " + maxSalaryInCompany(company));
        Department department = highSalaryEmployeeDep(company);
        System.out.println(department == null ? "No such department" : department);
        System.out.println("List of all employees:\n" + listOfAllEmployees(company));
    }

    public static int maxSalaryInCompany(Company company) {
        int maxSalary = company.getCEO().getSalary();
        for (Department department : company.getDepartments()) {
            if (department.getHeadOfDepartment().getSalary() > maxSalary)
                maxSalary = department.getHeadOfDepartment().getSalary();
            for (Employee employee : department.getEmployees()) {
                if (employee.getSalary() > maxSalary) maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public static Department highSalaryEmployeeDep(Company company) {
        Iterator iterator = company.getDepartments().listIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            int headSalary = ((Department) obj).getHeadOfDepartment().getSalary();
            Iterator employeeIterator = ((Department) obj).getEmployees().listIterator();
            while (employeeIterator.hasNext()) {
                Object employee = employeeIterator.next();
                if (((Employee) employee).getSalary() > headSalary) return ((Department) obj);
            }
        }
        return null;
    }

    public static ArrayList<Employee> listOfAllEmployees(Company company) {
        ArrayList<Employee> list = new ArrayList<>(List.of(company.getCEO()));
        Iterator<Department> iterator = company.getDepartments().listIterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            list.add(department.getHeadOfDepartment());
            list.addAll(department.getEmployees());
        }
        return list;
    }

    private static Employee generateEmployee() {
        return new Employee(firstNames[new Random().nextInt(firstNames.length - 1)],
                lastNames[new Random().nextInt(firstNames.length - 1)],
                new Random().nextInt(3000, 6500));
    }
}