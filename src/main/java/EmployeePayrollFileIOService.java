import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {

    public void write(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });

        try {
            Files.write(Paths.get("payroll-file.txt"),empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try{
            Files.lines(new File("payroll-file.txt").toPath()).forEach(System.out::println);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public long countEntries() {
        long count = 0;
        try{count = Files.lines(new File("payroll-file.txt").toPath()).count();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return count;
    }
}
