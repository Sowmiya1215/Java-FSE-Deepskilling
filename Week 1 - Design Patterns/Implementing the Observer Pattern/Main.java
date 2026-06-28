public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("Mobile1");
        Observer webApp = new WebApp("Web1");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(105.5);

        stockMarket.removeObserver(webApp);
        stockMarket.setStockPrice(110.0);
    }
}
