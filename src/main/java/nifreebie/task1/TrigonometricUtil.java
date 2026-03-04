package nifreebie.task1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TrigonometricUtil {

    private static final MathContext mc = new MathContext(30, RoundingMode.HALF_UP);

    public static BigDecimal cos(BigDecimal x) {
        return cos(x, Integer.MAX_VALUE);
    }

    public static BigDecimal cos(BigDecimal x, int n) {

        if (x == null) {
            throw new IllegalArgumentException("аргумент не должен быть null");
        }

        if (x.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        }

        BigDecimal result = BigDecimal.ONE;
        BigDecimal term = BigDecimal.ONE;
        BigDecimal xSquared = x.multiply(x, mc);

        for (int i = 1; i < n; i++) {

            BigDecimal old = result;

            BigDecimal denominator =
                    BigDecimal.valueOf((2L * i - 1) * (2L * i));

            term = term.multiply(xSquared.negate(), mc)
                    .divide(denominator, mc);

            result = result.add(term, mc);

            if (result.subtract(old).abs().compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
        }

        return result;
    }
}
