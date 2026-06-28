public class Main {
    public static void main(String[] args) {
        Notifier basicEmail = new EmailNotifier();
        Notifier emailWithSMS = new SMSNotifierDecorator(basicEmail);
        Notifier fullNotifier = new SlackNotifierDecorator(emailWithSMS);
        fullNotifier.send("System update scheduled at 9 PM.");
    }
}
