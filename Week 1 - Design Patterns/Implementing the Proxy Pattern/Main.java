public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");
        Image image2 = new ProxyImage("city.jpg");

        System.out.println("First call - Lazy loading:");
        image1.display();  // Loads from remote
        image2.display();  // Loads from remote

        System.out.println("\nSecond call - Using cache:");
        image1.display();  // Uses cached version
        image2.display();  // Uses cached version
    }
}
