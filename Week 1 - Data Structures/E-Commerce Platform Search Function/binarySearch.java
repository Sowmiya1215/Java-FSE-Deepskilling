import java.util.Arrays;
import java.util.Comparator;

public class binarySearch {

    public static Product binarySearch(Product[] products, String name) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(name);
            if (comparison == 0)
                return products[mid];
            else if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static class Product {
        String productName;

        public Product(String productName) {
            this.productName = productName;
        }

        @Override
        public String toString() {
            return "Product{name='" + productName + "'}";
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("Laptop"),
            new Product("Phone"),
            new Product("Tablet"),
            new Product("Camera")
        };

        Product result = binarySearch(products, "tablet");
        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Product not found.");
        }
    }
}
