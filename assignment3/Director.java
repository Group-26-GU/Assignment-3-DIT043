package assignment3;
public class Director extends Manager {
    private String department;
    private final double bonus = 5000;

    public Director(String id, String name, double salaryGross, String degree, String department) {
        super(id, name, salaryGross, degree);
        setSalaryGross(salaryGross);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void setSalaryGross(double salaryGross) {
        super.setSalaryGrossForce(UtilFunc.managerBonus(super.getBasicSalary(), super.getDegree()) + bonus, super.getBasicSalary());
    }

    @Override
    public void setDegree(String degree) {
        super.setDegree(degree);
        super.setSalaryGrossForce(UtilFunc.managerBonus(super.getBasicSalary(), degree) + bonus, super.getBasicSalary());
    }

    @Override
    public double getSalaryNet() {
        if(super.getSalaryGross() >= 30000 && super.getSalaryGross() <= 50000) {
            return UtilFunc.trunc(super.getSalaryGross() * 0.8, 2);
        } else if(super.getSalaryGross() > 50000) {
            return UtilFunc.trunc((30000 * 0.8 + (super.getSalaryGross() - 30000) * 0.6), 2);
        } else {
            return super.getSalaryNet();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Dept: " + department;
    }
}
