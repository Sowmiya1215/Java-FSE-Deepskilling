public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7", "16GB")
                .setGraphicsCard("NVIDIA RTX 4060")
                .setStorage("1TB SSD")
                .setOperatingSystem("Windows 11")
                .build();
        Computer workstation = new Computer.Builder("Intel i9", "32GB")
                .setStorage("2TB SSD")
                .setOperatingSystem("Linux Ubuntu")
                .build();
        System.out.println("Basic Computer:\n" + basicComputer);
        System.out.println("\nGaming Computer:\n" + gamingComputer);
        System.out.println("\nWorkstation:\n" + workstation);
    }
}
