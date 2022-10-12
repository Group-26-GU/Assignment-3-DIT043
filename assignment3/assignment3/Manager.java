package assignment3;


public class Manager extends Employee {
    private String degree;
    private double basicSalary;

    public Manager(String id, String name, double salaryGross, String degree){
        super(id, name, UtilFunc.managerBonus(salaryGross, degree));
        if(degree.isBlank() || ( !degree.equals("BSc") && !degree.equals("MSc") && !degree.equals("PhD"))){
              throw new DefaultException("Degree must be one of the options: BSc, MSc or PhD.");
      
          }else{
              this.basicSalary = salaryGross;
              this.degree = degree;
          }
    }

  
                                 // getters and setters
    public String getDegree() {
        return degree;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setDegree(String degree){
        if(degree.isBlank() || !degree.equals("BSc") || !degree.equals("MSc") || !degree.equals("PhD")){
            this.degree = degree;
            super.setSalaryGross(UtilFunc.managerBonus(basicSalary, degree));
        }
        else throw new DefaultException("Degree must be one of the options: BSc, MSc or PhD.");     
    }

    public void setSalaryGrossForce(double salaryGross, double basicSalary) {
        super.setSalaryGross(salaryGross);
        this.basicSalary = basicSalary;
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
