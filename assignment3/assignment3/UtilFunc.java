package assignment3;
import java.util.List;

public class UtilFunc {
    public static double trunc(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        int scale = (int) Math.pow(10, places);
        return (double) (int) (value * scale) / scale;
    }

    public static double managerBonus(double salaryGross, String degree) {
        switch (degree) {
            case "BSc":
                return trunc(salaryGross * 1.1, 2);
            case "MSc":
                return trunc(salaryGross * 1.2, 2);
            case "PhD":
                return trunc(salaryGross * 1.35, 2);
            default:
                return salaryGross;
        }
    }

    public static double internSalary(double salaryGross, int gpa) {
        if(gpa <= 5) {
            return 0;
        } else if(gpa <= 7) {
            return salaryGross;
        } else {
            return salaryGross + 1000;
        }
    }

    public static List<Employee> sortBySalary(List<Employee> values) {
        List<Employee> employees = values;
        employees.sort((e1, e2) -> {
            if (e1.getSalaryGross() > e2.getSalaryGross()) {
                return 1;
            } else if (e1.getSalaryGross() < e2.getSalaryGross()) {
                return -1;
            } else {
                return 0;
            }
        });

        return employees;
    }
}