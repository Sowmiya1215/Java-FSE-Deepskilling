public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        context.executePayment(250.75);
        context.setPaymentStrategy(new PayPalPayment("john@example.com"));
        context.executePayment(180.50);
        context.setPaymentStrategy(null);
        context.executePayment(99.99);
    }
}
