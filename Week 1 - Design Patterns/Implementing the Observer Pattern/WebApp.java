public class WebApp implements Observer {
    private String webId;

    public WebApp(String webId) {
        this.webId = webId;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("WebApp [" + webId + "] - Stock price updated: $" + stockPrice);
    }
}
