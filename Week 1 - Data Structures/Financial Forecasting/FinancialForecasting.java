public class FinancialForecasting {
    public static double forecastValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            return forecastValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
        }
    }
    public static double forecastValueMemo(double presentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != null) return memo[years];

        memo[years] = forecastValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
