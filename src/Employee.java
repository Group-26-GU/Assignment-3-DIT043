public class Employee {
    private String name;
    private final String id;
    private double salaryGross;

    public Employee(String id, String name, double salaryGross) {
        this.id = id;
        this.name = name;

        if (salaryGross < 0) {
            this.salaryGross = 0;
        } else {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaryGross(double salaryGross) {
        if (salaryGross < 0) {
            this.salaryGross = 0;
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
        return name + "'s gross salary is " + salaryGross + " SEK per month.";
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
