import java.util.Date;

public class AssignmentTwo {
    public static void main(String[] args) {
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);

        Ride r1 = new Ride("Superman Escape", 1.4, true, e1, 20);
        Ride r2 = new Ride("Wild West Falls Adventure Ride", 1.2, true, e2, 30);
        Ride r3 = new Ride("Scooby-Doo Spooky Coaster", 1.0, false, e1, 40);

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

        System.out.println("\nPart FourB:");
        assignmentTwo.partFourB();

        System.out.println("\nPart Five:");
        assignmentTwo.partFive();
    }

    public void partThree(){
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);
        Visitor v3 = new Visitor("ID20003", "Charlie", "Green", new Date(), "Male", "0466 999 000", "charlie@email.com", "Sydney, Australia", "VIS003", "VIP", new Date(), true, 2);
        Visitor v4 = new Visitor("ID20004", "Diana", "White", new Date(), "Female", "0466 222 333", "diana@email.com", "Adelaide, Australia", "VIS004", "Standard", new Date(), true, 1);
        Visitor v5 = new Visitor("ID20005", "Ethan", "Black", new Date(), "Male", "0466 444 555", "ethan@email.com", "Perth, Australia", "VIS005", "VIP", new Date(), true, 4);

        Ride ride = new Ride("Superman Escape", 1.4, true, e1, 20);

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

        Ride ride = new Ride("Superman Escape", 1.4, true, e1, 20);

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
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);
        Visitor v3 = new Visitor("ID20003", "Charlie", "Green", new Date(), "Male", "0466 999 000", "charlie@email.com", "Sydney, Australia", "VIS003", "VIP", new Date(), true, 2);
        Visitor v4 = new Visitor("ID20004", "Diana", "White", new Date(), "Female", "0466 222 333", "diana@email.com", "Adelaide, Australia", "VIS004", "Standard", new Date(), true, 1);
        Visitor v5 = new Visitor("ID20005", "Ethan", "Black", new Date(), "Male", "0466 444 555", "ethan@email.com", "Perth, Australia", "VIS005", "VIP", new Date(), true, 4);

        Ride ride = new Ride("Superman Escape", 1.4, true, e1, 20);

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
        ride.printRideHistory();

        ride.sortRideHistory(new VisitorComparator());
        System.out.println("Sorted Visitors:");
        ride.printRideHistory();
    }

    public void partFive(){
        Employee e1 = new Employee("ID10001", "John", "Doe", new Date(), "Male", "0400 111 222", "john.doe@email.com", "Gold Coast, Australia", "EMP001", "Operations", "Roller Coaster Operator", 55000.0, new Date());
        Employee e2 = new Employee("ID10002", "Emily", "Clark", new Date(), "Female", "0400 333 444", "emily.clark@email.com", "Sydney, Australia", "EMP002", "Operations", "Water Ride Operator", 53000.0, new Date());

        Visitor v1 = new Visitor("ID20001", "Alice", "Smith", new Date(), "Female", "0466 555 666", "alice@email.com", "Brisbane, Australia", "VIS001", "VIP", new Date(), true, 3);
        Visitor v2 = new Visitor("ID20002", "Bob", "Brown", new Date(), "Male", "0466 777 888", "bob@email.com", "Melbourne, Australia", "VIS002", "Standard", new Date(), true, 1);
        Visitor v3 = new Visitor("ID20003", "Charlie", "Green", new Date(), "Male", "0466 999 000", "charlie@email.com", "Sydney, Australia", "VIS003", "VIP", new Date(), true, 2);
        Visitor v4 = new Visitor("ID20004", "Diana", "White", new Date(), "Female", "0466 222 333", "diana@email.com", "Adelaide, Australia", "VIS004", "Standard", new Date(), true, 1);
        Visitor v5 = new Visitor("ID20005", "Ethan", "Black", new Date(), "Male", "0466 444 555", "ethan@email.com", "Perth, Australia", "VIS005", "VIP", new Date(), true, 4);
        Visitor v6 = new Visitor("ID20006", "Fiona", "Blue", new Date(), "Female", "0470 123 456", "fiona@email.com", "Gold Coast, Australia", "VIS006", "Standard", new Date(), false, 2);
        Visitor v7 = new Visitor("ID20007", "George", "Silver", new Date(), "Male", "0499 234 567", "george@email.com", "Sunshine Coast, Australia", "VIS007", "VIP", new Date(), true, 5);
        Visitor v8 = new Visitor("ID20008", "Hannah", "Rose", new Date(), "Female", "0471 345 678", "hannah@email.com", "Darwin, Australia", "VIS008", "Standard", new Date(), true, 1);
        Visitor v9 = new Visitor("ID20009", "Ian", "Gray", new Date(), "Male", "0469 456 789", "ian@email.com", "Canberra, Australia", "VIS009", "VIP", new Date(), false, 3);
        Visitor v10 = new Visitor("ID20010", "Jenny", "Gold", new Date(), "Female", "0477 567 890", "jenny@email.com", "Cairns, Australia", "VIS010", "Standard", new Date(), true, 2);
        Visitor v11 = new Visitor("ID20011", "Kevin", "Iron", new Date(), "Male", "0468 678 901", "kevin@email.com", "Hobart, Australia", "VIS011", "VIP", new Date(), true, 1);
        Visitor v12 = new Visitor("ID20012", "Lily", "Pearl", new Date(), "Female", "0480 789 012", "lily@email.com", "Newcastle, Australia", "VIS012", "Standard", new Date(), false, 4);
        Visitor v13 = new Visitor("ID20013", "Mark", "Copper", new Date(), "Male", "0466 890 123", "mark@email.com", "Townsville, Australia", "VIS013", "VIP", new Date(), true, 2);
        Visitor v14 = new Visitor("ID20014", "Natalie", "Brown", new Date(), "Female", "0455 901 234", "natalie@email.com", "Wollongong, Australia", "VIS014", "Standard", new Date(), true, 3);
        Visitor v15 = new Visitor("ID20015", "Oscar", "Ivory", new Date(), "Male", "0476 012 345", "oscar@email.com", "Geelong, Australia", "VIS015", "VIP", new Date(), false, 1);


        Ride ride = new Ride("Superman Escape", 1.4, true, e1, 5);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);
        ride.addVisitorToQueue(v7);
        ride.addVisitorToQueue(v8);
        ride.addVisitorToQueue(v9);
        ride.addVisitorToQueue(v10);
        ride.addVisitorToQueue(v11);
        ride.addVisitorToQueue(v12);
        ride.addVisitorToQueue(v13);
        ride.addVisitorToQueue(v14);
        ride.addVisitorToQueue(v15);

        System.out.println("All Visitors in the queue.:");
        ride.printQueue();
        System.out.println("Run one cycle:");
        ride.runOneCycle();
        System.out.println("All Visitors in the queue after one cycle is run:");
        ride.printQueue();
        System.out.println("All Visitors in the collection:");
        ride.printRideHistory();
    }

    public void partSix(){
    }
    public void partSeven(){
    }
}
