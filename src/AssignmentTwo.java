import java.util.Date;

public class AssignmentTwo {
    public static void main(String[] args) {
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);

        Ride r1 = new Ride("Superman Escape", 1.4, true, e1);
        Ride r2 = new Ride("Wild West Falls Adventure Ride", 1.2, true, e2);
        Ride r3 = new Ride("Scooby-Doo Spooky Coaster", 1.0, false, e1);

        System.out.println("Employees List:");
        System.out.println(e1);
        System.out.println(e2);

        System.out.println("");
        System.out.println("Visitors List:");
        System.out.println(v1);
        System.out.println(v2);

        System.out.println("");
        System.out.println("Rides List:");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }

    public void partThree(){
    }
    public void partFourA(){
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
}
