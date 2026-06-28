public class Main {
    public static void main(String[] args) {
        double initialValue = 10000;
        double annualGrowthRate = 0.05; // 5%
        int years = 5;
        double futureValue = FinancialForecasting.forecastValueRecursive(initialValue, annualGrowthRate, years);
        System.out.printf("Predicted Future Value (Recursive): ₹%.2f%n", futureValue);
        Double[] memo = new Double[years + 1];
        double futureValueMemo = FinancialForecasting.forecastValueMemo(initialValue, annualGrowthRate, years, memo);
        System.out.printf("Predicted Future Value (Memoized): ₹%.2f%n", futureValueMemo);
    }
}
