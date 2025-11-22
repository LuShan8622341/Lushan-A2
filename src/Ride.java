import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private double minHeight;
    private boolean isOpen;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    public Ride() {}

    public Ride(String rideName, double minHeight, boolean isOpen, Employee operator) {
        this.rideName = rideName;
        this.minHeight = minHeight;
        this.isOpen = isOpen;
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", minHeight=" + minHeight +
                ", isOpen=" + isOpen +
                ", operator=" + operator +
                '}';
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            visitorQueue.add(visitor);
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName() + " has joined the ride[" + this.getRideName() + "].");
        } else {
            System.out.println("Failed to join, visitor not exist.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.contains(visitor)) {
            visitorQueue.remove(visitor);
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName() +  " has left the ride[" + this.getRideName() + "].");
        } else {
            System.out.println("Visitor is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("The ride has no visitors.");
        } else {
            System.out.println(rideName + " Visitor List:");
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor);
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName()  + " added to the ride[" + this.getRideName() + "] history.");
        } else {
            System.out.println("Failed to add. visitor not exist.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("The ride has no history visitors.");
        } else {
            System.out.println(rideName + " History Visitor List:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor);
            }
        }
    }

    @Override
    public void runOneCycle() {

    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }
}
