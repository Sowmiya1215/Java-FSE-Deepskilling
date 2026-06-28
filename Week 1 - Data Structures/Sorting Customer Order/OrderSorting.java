public class OrderSorting {
    public static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order{id=" + orderId + ", name='" + customerName + "', price=" + totalPrice + "}";
        }
    }
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // optimization
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Alice", 2500.0),
            new Order(102, "Bob", 1500.0),
            new Order(103, "Charlie", 3500.0),
            new Order(104, "Daisy", 1000.0)
        };

        Order[] orders2 = orders1.clone(); // for quick sort

        System.out.println("== Original Orders ==");
        printOrders(orders1);

        System.out.println("\n== Bubble Sort by Total Price ==");
        bubbleSort(orders1);
        printOrders(orders1);

        System.out.println("\n== Quick Sort by Total Price ==");
        quickSort(orders2, 0, orders2.length - 1);
        printOrders(orders2);

        System.out.println("\n== Analysis ==");
        System.out.println("Bubble Sort Time Complexity: O(n^2)");
        System.out.println("Quick Sort Time Complexity: O(n log n) on average, O(n^2) worst-case");
        System.out.println("Quick Sort is preferred for large datasets due to its efficiency.");
    }
}
