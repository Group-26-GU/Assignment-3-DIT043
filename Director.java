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
        super.setSalaryGrossForce(UtilFunc.managerBonus(salaryGross, super.getDegree()) + bonus);
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
}
