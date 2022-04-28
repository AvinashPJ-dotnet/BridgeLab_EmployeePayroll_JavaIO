import java.util.*;

public class EmployeePayrollService {
    List<EmployeePayrollData> employeePayrollList;

    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO)){
            return new EmployeePayrollFileIOService().countEntries();
        }
        return 0;
    }

    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().printData();
        }
    }

    enum IOService{CONSOLE_IO,FILE_IO};

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
    public void writeEmployeePayrollData() {
        System.out.println("Employee Payroll data: \n");
        employeePayrollList.forEach(System.out::println);
    }

    public void writeEmployeePayrollData(IOService ioService){
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Writing"+employeePayrollList);
        else if(ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().write(employeePayrollList);
    }
}
