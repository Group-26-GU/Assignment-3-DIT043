import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Company {
    private HashMap<String, Employee> employees = new HashMap<>();

    public String registerEmployee(String id, String name, Double salaryGross){
        employees.put(id, new Employee(id, name, salaryGross));

        return "Employee " + id + " was registered successfully.";
    }

    public void updateName(String id, String newName){
        employees.get(id).setName(newName);
    }

    public void updateSalary(String id, Double newSalary){
        employees.get(id).setSalaryGross(newSalary);
    }
    
                                                        // 1.4 remove an employee
    public String removeEmployee(String id){ 
        boolean containsKey= employees.containsKey(id);

        if(containsKey){
            employees.remove(id);
            return "Employee" + id + " was successfully removed.";
        }
        else { return "";}
    } //exception ADD LATER
                                                        // 1.5 retrieve a string from an employee 
    public String retrieve(String id){
        return employees.get(id).toString();
    }

                                                        // 1.6 retrieve a string from all employees
    public String retrieveAll() { 
        String result = "All registered employees:\n";
        for (var employee : employees.values()) {
            result += employee.toString() + "\n";
        }

        return result;
    }
                                                        // 1.7 retrieve total expenses
    public double getGrossSumm() {
        double summ = 0;
        for(var key: employees.keySet()) {
            summ += employees.get(key).getSalaryGross();
        }
        return summ;
    }

    public  double getNetSumm() {
        double summ = 0;
        for(var key: employees.keySet()) {
            summ += employees.get(key).getSalaryNet();
        }
        return summ;
    }

    public String sortBySalary() {
        String result = "Employees sorted by salary (ascending order):\n";
        List<Employee> sortedEmployees = UtilFunc.sortBySalary(new ArrayList<Employee>(employees.values()));
        for (var employee : sortedEmployees) {
            result += employee.toString() + "\n";
        }
        return result;
}}
    

