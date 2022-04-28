import java.util.*;

public class EmployeePayrollService {
    List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner scanner = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(scanner);
        employeePayrollService.writeEmployeePayrollData();
    }

    public void readEmployeePayrollData(Scanner in){
        System.out.println("Enter id: ");
        int id = in.nextInt();
        System.out.println("Enter Name: ");
        String name = in.next();
        System.out.println("Enter Salary: ");
        double salary = in.nextInt();
        employeePayrollList.add(new EmployeePayrollData(id,name,salary));
    }

    private void writeEmployeePayrollData(){
        System.out.println("Employee Payroll data: \n");
        employeePayrollList.forEach(System.out::println);
    }
}
