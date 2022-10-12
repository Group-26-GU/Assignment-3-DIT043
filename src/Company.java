import java.util.HashMap;

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

   public String promoteToManager(String id, String degree){
        if(employees.containsKey(id)){
            Employee promotedEmployee = employees.get(id);
            Manager manager = new Manager(promotedEmployee.getId(), promotedEmployee.getName(), promotedEmployee.getBasicSalary(), degree);
            employees.put(id, manager);
            return "Employee " + id + " was promoted to manager successfully.";
        }
        else { return null;} 
    }

    public String promoteToIntern(String id, int gpa){
        if(employees.containsKey(id)){
            Employee promotedEmployee = employees.get(id);
            Intern intern = new Intern(promotedEmployee.getId(), promotedEmployee.getName(), promotedEmployee.getBasicSalary(), gpa);
            employees.put(id, intern);
            return "Employee " + id + " was promoted to intern successfully.";
        }
        else { return null;} 
    }

    public String promoteToDirector(String id, String degree, String department){
        if(employees.containsKey(id)){
            Employee promotedEmployee = employees.get(id);
            Director director = new Director(promotedEmployee.getId(), promotedEmployee.getName(), promotedEmployee.getBasicSalary(), degree, department);
            employees.put(id, director);
            return "Employee " + id + " was promoted to director successfully.";
        }
        else { return null;} 
    }
}






    

