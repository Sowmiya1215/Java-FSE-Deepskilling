public class linearSearch {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
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

        Product result = linearSearch(products, "camera");
        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Product not found.");
        }
    }
}
