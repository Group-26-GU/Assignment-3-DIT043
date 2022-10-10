public class Intern extends Employee {
    private int gpa;
    private double basicSalary;

    public Intern(String id, String name, double salaryGross, int gpa) {
        super(id, name, UtilFunc.internSalary(salaryGross, gpa));
        this.gpa = gpa;
        this.basicSalary = salaryGross;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
        super.setSalaryGross(UtilFunc.internSalary(basicSalary, gpa));
    }

    @Override
    public void setSalaryGross(double salaryGross) {
        basicSalary = salaryGross;
        super.setSalaryGross(UtilFunc.internSalary(basicSalary, gpa));
    }

                                                                        // net salary with no taxes
    @Override
    public double getSalaryNet() {
        return UtilFunc.trunc(super.getSalaryGross(), 2);
    }

    @Override
    public String toString() {
        return super.toString() + " GPA: " + gpa;
    }
}
