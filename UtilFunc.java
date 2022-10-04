import java.math.RoundingMode;
import java.math.BigDecimal;

public class UtilFunc {
    public static double trunc(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_DOWN);
        return bd.doubleValue();
    }
}
