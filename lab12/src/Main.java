import java.util.*;

public class Main {
    private final static String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hank", "Riley", "Sophia", "Liam", "Isabella", "Ethan"};
    private final static String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Turner", "Martinez", "Rodriguez", "Thompson"};

    public static void main(String[] args) {
        Company company = new Company("Big Company", generateEmployee(),
                new HashSet<>(Set.of(
                        new Department("IT Department", generateEmployee(),
                                new HashSet<>(Set.of(generateEmployee(), generateEmployee()))),
                        new Department("Finance Department", generateEmployee(),
                                new HashSet<>(Set.of(generateEmployee(), generateEmployee()))),
                        new Department("HR Department", generateEmployee(),
                                new HashSet<>(Set.of(generateEmployee(), generateEmployee())))
                )));

        System.out.println("Biggest salary in the company is " + maxSalaryInCompany(company));
        Department department = highSalaryEmployeeDep(company);
        System.out.println(department == null ? "No such department" : department);
        System.out.println("List of all employees:\n" + listOfAllEmployees(company));
        System.out.println("Map with average salaries: " + averageSalaryMap(company));
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
        Iterator iterator = company.getDepartments().iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            int headSalary = ((Department) obj).getHeadOfDepartment().getSalary();
            Iterator employeeIterator = ((Department) obj).getEmployees().iterator();
            while (employeeIterator.hasNext()) {
                Object employee = employeeIterator.next();
                if (((Employee) employee).getSalary() > headSalary) return ((Department) obj);
            }
        }
        return null;
    }

    public static HashSet<Employee> listOfAllEmployees(Company company) {
        HashSet<Employee> list = new HashSet<>(Set.of(company.getCEO()));
        Iterator<Department> iterator = company.getDepartments().iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            list.add(department.getHeadOfDepartment());
            list.addAll(department.getEmployees());
        }
        return list;
    }

    public static HashMap<String, Double> averageSalaryMap(Company company) {
        HashMap<String, Double> averageSalary = new HashMap<>();
        averageSalary.put("CEO", (double) company.getCEO().getSalary());
        for(Department department : company.getDepartments()) {
            int sumSalary = department.getHeadOfDepartment().getSalary();
            for(Employee employee : department.getEmployees()) {
                sumSalary += employee.getSalary();
            }
            averageSalary.put(department.getName(), sumSalary/3.);
        }
        return averageSalary;
    }

    private static Employee generateEmployee() {
        return new Employee(firstNames[new Random().nextInt(firstNames.length - 1)],
                lastNames[new Random().nextInt(firstNames.length - 1)],
                new Random().nextInt(3000, 6500));
    }
}