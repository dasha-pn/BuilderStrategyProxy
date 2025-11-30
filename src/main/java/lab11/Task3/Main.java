package lab11.Task3;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== USING PROXY ===");
        MyImage img1 = new ProxyImage("apps.png");
        System.out.println("ProxyImage object created.");

        System.out.println("Now calling display()...");
        img1.display();


        System.out.println("\n=== USING REAL IMAGE DIRECTLY ===");
        MyImage img2 = new RealImage("apps_10.jpeg");
        System.out.println("RealImage object created.");

        System.out.println("Now calling display()...");
        img2.display();
    }
}
