public class MobileApp implements Observer {
    private String appId;

    public MobileApp(String appId) {
        this.appId = appId;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("MobileApp [" + appId + "] - Stock price updated: $" + stockPrice);
    }
}
