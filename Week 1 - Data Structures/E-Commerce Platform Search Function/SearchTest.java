import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Mouse", "Accessories"),
            new Product(3, "Keyboard", "Accessories"),
            new Product(4, "Monitor", "Electronics"),
        };

        Product result1 = SearchUtils.linearSearch(products, "Mouse");
        System.out.println("Linear Search: " + (result1 != null ? result1 : "Not found"));

        Product result2 = SearchUtils.binarySearch(products, "Mouse");
        System.out.println("Binary Search: " + (result2 != null ? result2 : "Not found"));
    }
    public static class Product {
        int id;
        String productName;
        String category;

        public Product(int id, String productName, String category) {
            this.id = id;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + productName + "', category='" + category + "'}";
        }
    }
    public static class SearchUtils {
        public static Product linearSearch(Product[] products, String name) {
            for (Product product : products) {
                if (product.productName.equalsIgnoreCase(name)) {
                    return product;
                }
            }
            return null;
        }
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
    }
}
