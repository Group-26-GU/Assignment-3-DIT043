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

    public String retrieve(String id){
        return employees.get(id).toString();
    }

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


    public String removeEmployee(String id){  //1.4
        boolean containsKey= employees.containsKey(id);

        if(containsKey){
            employees.remove(id);
            return "Employee" + id + " was successfully removed.";
        }
        else { return "";}
    } //exception ADD LATER
}
