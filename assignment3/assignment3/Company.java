package assignment3;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Map;

public class Company {
    private HashMap<String, Employee> employees = new LinkedHashMap<>();

    public String createEmployee(String id, String name, Double salaryGross) throws DefaultException {
        if(employees.containsKey(id)) {
            throw new DefaultException("Cannot register. ID " + id + " is already registered.");
        } else {
            employees.put(id, new Employee(id, name, salaryGross));

            return "Employee " + id + " was registered successfully.";
        }
    }

                                                        // overwritten for subclases
                                                        // Manager
    public String createEmployee(String id, String name, Double salaryGross, String degree) throws DefaultException {
        if(employees.containsKey(id)) {
            return "Cannot register. ID " + id + " is already registered.";
        } else {
            employees.put(id, new Manager(id, name, salaryGross, degree));

            return "Employee " + id + " was registered successfully.";
        }
    }
    
                                                            // Director
    public String createEmployee(String id, String name, Double salaryGross, String degree, String department) throws DefaultException {
        if(employees.containsKey(id)) {
            return "Cannot register. ID " + id + " is already registered.";
        } else {
            employees.put(id, new Director(id, name, salaryGross, degree, department));

            return "Employee " + id + " was registered successfully.";
        }
    }
        
                                                                // Intern
    public String createEmployee(String id, String name, Double salaryGross, int gpa) throws DefaultException {
        if(employees.containsKey(id)) {
            return "Cannot register. ID " + id + " is already registered.";
        } else {
            employees.put(id, new Intern(id, name, salaryGross, gpa));

            return "Employee " + id + " was registered successfully.";
        }
    }

                                                        // 1.4 remove an employee
    public String removeEmployee(String id) throws DefaultException { 
        boolean containsKey= employees.containsKey(id);

        if(containsKey){
            employees.remove(id);
            return "Employee " + id + " was successfully removed.";
        }
        else { 
            throw new DefaultException("Employee "+ id +" was not registered yet.");
        }
    }
                                                        // 1.5 retrieve a string from an employee 
    public String printEmployee(String id) throws DefaultException {
        if(employees.containsKey(id)) {
            return employees.get(id).toString();
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }
    }

                                                        // 1.6 retrieve a string from all employees
    public String printAllEmployees() {
        if(employees.isEmpty()){
            throw new NoEmployeesException();
        } else {
            String result = "All registered employees:\n";
            for (var employee : employees.values()) {
                result += employee.toString() + "\n";
            }

            return result;
        }
    }
                                                        // 1.7 retrieve total expenses
    public double getGrossSumm() {
        double summ = 0;
        for(var key: employees.keySet()) {
            summ += employees.get(key).getSalaryGross();
        }
        return summ;
    }

    public  double getTotalNetSalary() {
        if(employees.isEmpty()){
            throw new NoEmployeesException();
        } else {
            double summ = 0;
            for(var key: employees.keySet()) {
                summ += employees.get(key).getSalaryNet();
            }
            return summ;
        }
    }

    public String printSortedEmployees() {
        if(employees.isEmpty()){
            throw new NoEmployeesException();
        } else {
            String result = "Employees sorted by gross salary (ascending order):\n";
            List<Employee> sortedEmployees = UtilFunc.sortBySalary(new ArrayList<Employee>(employees.values()));
            for (var employee : sortedEmployees) {
                result += employee.toString() + "\n";
            }
            return result;
        }
    }
    

    public String updatedSuccesfully(String id){
        return "Employee " + id + " was updated successfully";
    }
    public String updateEmployeeName(String id, String newName) throws CannotBeBlankException, DefaultException {
        if(employees.containsKey(id)) {
            try {
                employees.get(id).setName(newName);
            } catch (CannotBeBlankException e) {
                throw new CannotBeBlankException("Name");
            }
            return updatedSuccesfully(id);
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }
    }

    public String updateGrossSalary(String id, Double newSalary) throws DefaultException {
        if(employees.containsKey(id)) {
            try {
                if(newSalary > 0){
                    employees.get(id).setSalaryGross(newSalary);
                    return updatedSuccesfully(id);
                } else{
                    throw new DefaultException("Salary must be greater than zero.");
                }
            } catch (DefaultException exception) {
                throw new DefaultException(exception.getMessage());
            }
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }
    }

    public String updateManagerDegree(String id, String newDegree)throws DefaultException{
        if(newDegree.isBlank() || (!newDegree.equals("BSc") && !newDegree.equals("MSc") && !newDegree.equals("PhD"))){
            throw new DefaultException("Degree must be one of the options: BSc, MSc or PhD.");
        }
        if(employees.containsKey(id)) {
            if (employees.get(id) instanceof Manager){
                ((Manager) employees.get(id)).setDegree(newDegree);
                return updatedSuccesfully(id);
            } else return "";
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }      
    }

    public String updateDirectorDept(String id, String newDeparment) throws DefaultException {
        if(employees.containsKey(id)) {
            if (employees.get(id) instanceof Director){
               if (!Objects.equals(newDeparment, "") && (newDeparment.equals("Business") || newDeparment.equals("Human Resources") || newDeparment.equals("Technical"))){
               ((Director) employees.get(id)).setDepartment(newDeparment);
                return updatedSuccesfully(id);
                }else{
                   throw new DefaultException("Department must be one of the options: Business, Human Resources or Technical.");
               }
            }
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }
        return "";
    }

    public String updateInternGPA( String id, int gpa) throws DefaultException {
        if(employees.containsKey(id)) {
            if (employees.get(id) instanceof Intern){
                ((Intern) employees.get(id)).setGpa(gpa);
                return updatedSuccesfully(id);
            }
            else return "";
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }
    }

    public double getNetSalary(String id) throws DefaultException {
        if(employees.containsKey(id)) {
            if(employees.containsKey(id)) {
                return employees.get(id).getSalaryNet();
            } else {
                throw new DefaultException("Employee " + id + " was not registered yet.");
            }
        } else {
            throw new DefaultException("Employee " + id + " was not registered yet.");
        }
    }

    public Map<String, Integer> mapEachDegree(){
        if(employees.isEmpty()){
            throw new NoEmployeesException();
        } else {
            Map<String, Integer> result = new HashMap<>();
            int numBsc = 0, numMsc = 0, numPhd = 0;
            // String line1="", line2="", line3="";
            for( var employee: employees.values()){
                if (employee instanceof Manager){
                    if(Objects.equals(((Manager) employee).getDegree(), "BSc")){
                        numBsc += 1;
                    } else if (Objects.equals(((Manager) employee).getDegree(), "MSc")) {
                        numMsc += 1;
                    } else if (Objects.equals(((Manager) employee).getDegree(), "PhD")) {
                        numPhd += 1;
                    }
                }
            }
            // line1 = (numBsc==0 ? "BSc: => " + numBsc : null);
            // line2 = (numMsc==0 ? "MSc: => " + numMsc : null);
            // line1 = (numPhd==0 ? "PhD: => " + numPhd : null);
            if(numBsc > 0) result.put("BSc", numBsc);
            if(numMsc > 0) result.put("MSc", numMsc);
            if(numPhd > 0) result.put("PhD", numPhd);
    
            // return "Academic background of employees: /n " + line1 + "/n" + line2+ "/n" + line3 + "/n";
            return result;
        }
    }

    public String promoteToManager(String id, String degree)throws DefaultException{
        try {   if(employees.containsKey(id)){
                Employee promotedEmployee = employees.get(id);
                Manager manager = new Manager(promotedEmployee.getId(), promotedEmployee.getName(), promotedEmployee.getBasicSalary(), degree);
                employees.put(id, manager);
                return id + " promoted successfully to Manager.";
        }
        else { throw new DefaultException("Employee " + id + " was not registered yet.");
        } 
            
        } catch (DefaultException e) {
            throw new DefaultException(e.getMessage());
        }

    }

    public String promoteToIntern(String id, int gpa){
        if(employees.containsKey(id)){
            Employee promotedEmployee = employees.get(id);
            Intern intern = new Intern(promotedEmployee.getId(), promotedEmployee.getName(), promotedEmployee.getBasicSalary(), gpa);
            employees.put(id, intern);
            return id + " promoted successfully to Intern.";
        }
        else { throw new DefaultException("Employee " + id + " was not registered yet."); } 
    }

    public String promoteToDirector(String id, String degree, String department){
        if(employees.containsKey(id)){
            Employee promotedEmployee = employees.get(id);
            Director director = new Director(promotedEmployee.getId(), promotedEmployee.getName(), promotedEmployee.getBasicSalary(), degree, department);
            employees.put(id, director);
            return id + " promoted successfully to Director.";
        }
        else { throw new DefaultException("Employee " + id + " was not registered yet."); } 
    }
}
