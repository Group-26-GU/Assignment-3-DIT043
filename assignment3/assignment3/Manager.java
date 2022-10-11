package assignment3;
public class Manager extends Employee {
    private String degree;
    private double basicSalary;

    public Manager(String id, String name, double salaryGross, String degree) {
        super(id, name, UtilFunc.managerBonus(salaryGross, degree));
        this.basicSalary = salaryGross;
        this.degree = degree;
    }

                                        // getters and setters
    public String getDegree() {
        return degree;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setDegree(String degree) {
        this.degree = degree;
        super.setSalaryGross(UtilFunc.managerBonus(basicSalary, degree));
    }

    public void setSalaryGrossForce(double salaryGross) {
        super.setSalaryGross(salaryGross);
        this.basicSalary = salaryGross;
    }

    @Override
    public void setSalaryGross(double salaryGross) {
        super.setSalaryGross(UtilFunc.managerBonus(salaryGross, degree));
        this.basicSalary = salaryGross;
    }

    @Override
    public String toString() {
        return degree + " " + super.toString();
    }
}
