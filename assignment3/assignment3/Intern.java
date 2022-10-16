package assignment3;
public class Intern extends Employee {
    private int gpa;
    private double basicSalary;

    public Intern(String id, String name, double salaryGross, int gpa) throws DefaultException, CannotBeBlankException {
        super(id, name, UtilFunc.internSalary(salaryGross, gpa));
        if(gpa < 1 || gpa > 10){
            throw new DefaultException(gpa + " outside range. Must be between 0-10.");

        }else if (salaryGross < 0){
                throw new DefaultException("Salary must be greater than zero.");
        }else{
        this.gpa = gpa;
        this.basicSalary = salaryGross;
        }
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa)throws DefaultException {
        if(gpa < 0 || gpa > 10){
            throw new DefaultException(gpa + " outside range. Must be between 0-10.");
        }else{
            this.gpa = gpa;
            super.setSalaryGross(UtilFunc.internSalary(basicSalary, gpa));
        }
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    @Override
    public void setSalaryGross(double salaryGross) throws DefaultException {
        basicSalary = salaryGross;
        if(basicSalary <= 0){
            throw new DefaultException("Salary must be greater than zero.");
        }
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
