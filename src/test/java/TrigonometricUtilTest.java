import nifreebie.task1.TrigonometricUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrigonometricUtilTest {
    private static final MathContext mc =
            new MathContext(30, RoundingMode.HALF_UP);

    private static final BigDecimal pi = new BigDecimal(Math.PI, mc);
    private static final BigDecimal halfPi = pi.divide(BigDecimal.valueOf(2), mc);

    private static final BigDecimal EPS =
            new BigDecimal("1E-15");

    static Stream<Arguments> cosArgsStream() {

        BigDecimal delta = new BigDecimal("1E-7", mc);


        return Stream.of(
                Arguments.of(pi.negate(), new BigDecimal("-1")),
                Arguments.of(pi, new BigDecimal("-1")),
                Arguments.of(BigDecimal.ZERO, BigDecimal.ONE),
                Arguments.of(halfPi.negate(), BigDecimal.ZERO),
                Arguments.of(halfPi, BigDecimal.ZERO),

                Arguments.of(pi.subtract(delta),
                        new BigDecimal("-0.999999999999995")),

                Arguments.of(pi.negate().add(delta),
                        new BigDecimal("-0.999999999999995")),

                Arguments.of(halfPi.subtract(delta),
                        new BigDecimal("0.0000001")),

                Arguments.of(halfPi.negate().add(delta),
                        new BigDecimal("0.0000001"))
        );
    }

    static Stream<Arguments> periodicityArgs() {
        BigDecimal twoPi = pi.multiply(BigDecimal.valueOf(2), mc);

        return Stream.of(
                Arguments.of(BigDecimal.ZERO, twoPi),
                Arguments.of(pi.divide(BigDecimal.valueOf(4), mc), twoPi),
                Arguments.of(pi.divide(BigDecimal.valueOf(2), mc), twoPi),
                Arguments.of(pi.multiply(new BigDecimal("0.75"), mc), twoPi),
                Arguments.of(pi, twoPi)
        );
    }

    static Stream<Arguments> intervalArgs() {

        BigDecimal halfPi = pi.divide(BigDecimal.valueOf(2), mc);

        return Stream.of(
                Arguments.of(BigDecimal.ZERO, BigDecimal.ONE),

                Arguments.of(
                        pi.divide(BigDecimal.valueOf(4), mc),
                        new BigDecimal("0.7071067811865476")
                ),

                Arguments.of(
                        halfPi,
                        BigDecimal.ZERO
                ),

                Arguments.of(
                        pi.multiply(new BigDecimal("0.75"), mc),
                        new BigDecimal("-0.7071067811865476")
                ),

                Arguments.of(
                        pi,
                        new BigDecimal("-1")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("cosArgsStream")
    void testCosCornerCases(BigDecimal x, BigDecimal expected) {

        BigDecimal result = TrigonometricUtil.cos(x, 100);

        BigDecimal difference =
                result.subtract(expected).abs();

        assertTrue(difference.compareTo(EPS) < 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.5", "1.2", "2.8", "5.0"})
    void testEvenFunction(BigDecimal x) {
        BigDecimal positive = TrigonometricUtil.cos(x);
        BigDecimal negative = TrigonometricUtil.cos(x.negate());

        BigDecimal difference =
                positive.subtract(negative).abs();

        assertTrue(difference.compareTo(EPS) < 0);
    }

    @ParameterizedTest
    @MethodSource("periodicityArgs")
    void testPeriodicity(BigDecimal x, BigDecimal period) {

        BigDecimal result1 = TrigonometricUtil.cos(x);
        BigDecimal result2 = TrigonometricUtil.cos(x.add(period));

        BigDecimal difference = result1.subtract(result2).abs();

        assertTrue(difference.compareTo(EPS) < 0);
    }

    @ParameterizedTest
    @MethodSource("intervalArgs")
    void testValuesOnInterval(BigDecimal x, BigDecimal expected) {

        BigDecimal result = TrigonometricUtil.cos(x);

        BigDecimal difference = result.subtract(expected).abs();

        assertTrue(difference.compareTo(EPS) < 0);
    }

    @Test
    void testNullArgument() {
        assertThrows(IllegalArgumentException.class,
                () -> TrigonometricUtil.cos(null));
    }
}
