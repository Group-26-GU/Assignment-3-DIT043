import java.math.RoundingMode;
import java.math.BigDecimal;

public class UtilFunc {
    public static double trunc(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_DOWN);
        return bd.doubleValue();
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
}