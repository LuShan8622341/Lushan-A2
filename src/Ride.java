import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private double minHeight;
    private boolean isOpen;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int maxRider;
    private int numOfCycles = 0;

    public Ride() {}

    public Ride(String rideName, double minHeight, boolean isOpen, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.minHeight = minHeight;
        this.isOpen = isOpen;
        this.operator = operator;
        if (maxRider >= 1) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Failed to set maxRider, the value needs to be greater than 1.");
        }
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

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Failed to set maxRider, the value needs to be greater than 1.");
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
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
        if (operator == null) {
            System.out.println("Operator not exist.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("The ride has no visitors.");
            return;
        }
        System.out.println("The ride[" + rideName + "] start running!");
        int curRiderNum = 0;
        while (!visitorQueue.isEmpty() && curRiderNum < maxRider) {
            Visitor visitor = visitorQueue.peek();
            removeVisitorFromQueue(visitor);
            if (!checkVisitorFromHistory(visitor)) {
                addVisitorToHistory(visitor);
            }
            curRiderNum++;
        }
        numOfCycles++;
        System.out.println("The ride[" + rideName + "] run end!, " + curRiderNum + " visitors in this cycle, total cycles:" + numOfCycles);
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }

    public void exportRideHistory(String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write("idNumber,firstName,lastName,birthday,gender,phoneNumber,email,address,visitorId,ticketType,entryDate,hasPaid,visitCount\n");
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getIdNumber() + "," + visitor.getFirstName() + "," + visitor.getLastName() + "," + visitor.getBirthday() + ","
                        + visitor.getGender() + "," + visitor.getPhoneNumber() + "," + visitor.getEmail() + "," + visitor.getAddress() + ","
                        + visitor.getVisitorId() + "," + visitor.getTicketType() + "," + visitor.getEntryDate() + "," + visitor.isHasPaid() + ","
                        + visitor.getVisitCount() + "\n");
            }
            System.out.println("File exported to: " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
