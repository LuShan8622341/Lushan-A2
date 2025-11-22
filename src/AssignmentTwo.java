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

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        System.out.println("\nPart Three:");
        assignmentTwo.partThree();

        System.out.println("\nPart FourA:");
        assignmentTwo.partFourA();
    }

    public void partThree(){
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);
        Visitor v3 = new Visitor("ID20003", "Charlie", "Green", new Date(), "Male", "0466 999 000", "charlie@email.com", "Sydney, Australia", "VIS003", "VIP", new Date(), true, 2);
        Visitor v4 = new Visitor("ID20004", "Diana", "White", new Date(), "Female", "0466 222 333", "diana@email.com", "Adelaide, Australia", "VIS004", "Standard", new Date(), true, 1);
        Visitor v5 = new Visitor("ID20005", "Ethan", "Black", new Date(), "Male", "0466 444 555", "ethan@email.com", "Perth, Australia", "VIS005", "VIP", new Date(), true, 4);

        Ride ride = new Ride("Superman Escape", 1.4, true, e1);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.printQueue();

        ride.removeVisitorFromQueue(v4);
        ride.printQueue();
    }

    public void partFourA(){
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);
        Visitor v3 = new Visitor("ID20003", "Charlie", "Green", new Date(), "Male", "0466 999 000", "charlie@email.com", "Sydney, Australia", "VIS003", "VIP", new Date(), true, 2);
        Visitor v4 = new Visitor("ID20004", "Diana", "White", new Date(), "Female", "0466 222 333", "diana@email.com", "Adelaide, Australia", "VIS004", "Standard", new Date(), true, 1);
        Visitor v5 = new Visitor("ID20005", "Ethan", "Black", new Date(), "Male", "0466 444 555", "ethan@email.com", "Perth, Australia", "VIS005", "VIP", new Date(), true, 4);

        Ride ride = new Ride("Superman Escape", 1.4, true, e1);

        if (!ride.checkVisitorFromHistory(v1)) {
            ride.addVisitorToHistory(v1);
        }
        if (!ride.checkVisitorFromHistory(v2)) {
            ride.addVisitorToHistory(v2);
        }
        if (!ride.checkVisitorFromHistory(v3)) {
            ride.addVisitorToHistory(v3);
        }
        if (!ride.checkVisitorFromHistory(v4)) {
            ride.addVisitorToHistory(v4);
        }
        if (!ride.checkVisitorFromHistory(v5)) {
            ride.addVisitorToHistory(v5);
        }
        System.out.println("Ride[" + ride.getRideName() + "] number of Visitors: " + ride.numberOfVisitors());
        ride.printRideHistory();
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
