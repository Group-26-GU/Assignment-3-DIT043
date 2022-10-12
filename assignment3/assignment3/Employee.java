package assignment3;
public class Employee {
    private String name;
    private final String id;
    private double salaryGross;

    public Employee(String id, String name, double salaryGross) throws CannotBeBlankException, DefaultException {
        this.id = id;
        this.name = name;
        if(name.isBlank()){
            throw new CannotBeBlankException("Name");
        }
        if(id.isBlank()){
            throw new CannotBeBlankException("ID");
        }
        if(salaryGross < 0){
            throw new DefaultException("Salary must be greater than zero.");
        } else{
            this.salaryGross = UtilFunc.trunc(salaryGross, 2);
        }
    }

                                    // jetters and setters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalaryGross() {
        return salaryGross;
    }

    public void setName(String name) throws CannotBeBlankException {
        if(name.isBlank()){
            throw new CannotBeBlankException("Name");
        }
        this.name = name;
    }

    public void setSalaryGross(double salaryGross) throws DefaultException {
        if (salaryGross <= 0 && !(this instanceof Intern)) {
            throw new DefaultException("Salary must be greater than zero.");
        } else {
            this.salaryGross = UtilFunc.trunc(salaryGross, 2);
        }
    }

    public double getSalaryNet() {
        return UtilFunc.trunc(salaryGross * 0.9, 2);
    }

    public double getBasicSalary() {
        return salaryGross;
    }

    @Override
    public String toString() {
        String salaryGrossString = String.format("%.2f", salaryGross);
        return name + "'s gross salary is " + salaryGrossString + " SEK per month.";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Employee other = (Employee) obj;
        return id == other.id;
    }

    
}
