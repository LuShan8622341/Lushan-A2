import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private double minHeight;
    private boolean isOpen;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>(); // Queue of visitors waiting
    private LinkedList<Visitor> rideHistory = new LinkedList<>(); // History of visitors who have ridden
    private int maxRider; // Maximum number of riders per cycle
    private int numOfCycles = 0; // Total cycles the ride has completed

    // Constructors
    public Ride() {}

    public Ride(String rideName, double minHeight, boolean isOpen, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.minHeight = minHeight;
        this.isOpen = isOpen;
        this.operator = operator;

        // Ensure maxRider is valid
        if (maxRider >= 1) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Failed to set maxRider, the value needs to be greater than 1.");
        }
    }

    // Getters and Setters
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

    // Add a visitor to the waiting queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            visitorQueue.add(visitor);
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName() + " has joined the ride[" + this.getRideName() + "].");
        } else {
            System.out.println("Failed to join, visitor not exist.");
        }
    }

    // Remove a visitor from the queue
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.contains(visitor)) {
            visitorQueue.remove(visitor);
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName() +  " has left the ride[" + this.getRideName() + "].");
        } else {
            System.out.println("Visitor is not in the queue.");
        }
    }

    // Print the current queue of visitors
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

    // Add a visitor into the ride history list
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName()  + " added to the ride[" + this.getRideName() + "] history.");
        } else {
            System.out.println("Failed to add. visitor not exist.");
        }
    }

    // Check if a visitor exists in ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // Get number of visitors in ride history
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // Print all past visitors in the ride history
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

    // Run a ride cycle, loading up to maxRider visitors
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

        // Load visitors until max capacity reached
        while (!visitorQueue.isEmpty() && curRiderNum < maxRider) {
            Visitor visitor = visitorQueue.peek();  // Get first visitor in queue
            removeVisitorFromQueue(visitor); // Remove from queue

            // Only add if the visitor hasn't been recorded before
            if (!checkVisitorFromHistory(visitor)) {
                addVisitorToHistory(visitor);
            }
            curRiderNum++;
        }
        numOfCycles++;
        System.out.println("The ride[" + rideName + "] run end!, " + curRiderNum + " visitors in this cycle, total cycles:" + numOfCycles);
    }

    // Sort ride history using a custom comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }

    // Export ride history to a CSV file
    public void exportRideHistory(String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            // Write CSV header
            writer.write("idNumber,firstName,lastName,birthday,gender,phoneNumber,email,address,visitorId,ticketType,entryDate,hasPaid,visitCount\n");
            // Write each visitor as a CSV row
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

    // Import ride history from CSV file
    public void importRideHistory(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String row;
            reader.readLine(); // Skip header row
            int count = 0;

            // Read each line and parse into Visitor
            while ((row = reader.readLine()) != null) {
                // Split using regex to avoid splitting city, country incorrectly
                String[] visitorInfoArr = row.split(",(?! )");
                if (visitorInfoArr.length == 13) {
                    // Parse date format used by Date.toString()
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    // Extract each field
                    String idNumber = visitorInfoArr[0];
                    String firstName = visitorInfoArr[1];
                    String lastName = visitorInfoArr[2];
                    Date birthday = sdf.parse(visitorInfoArr[3]);
                    String gender = visitorInfoArr[4];
                    String phoneNumber = visitorInfoArr[5];
                    String email = visitorInfoArr[6];
                    String address = visitorInfoArr[7];
                    String visitorId = visitorInfoArr[8];
                    String ticketType = visitorInfoArr[9];
                    Date entryDate = sdf.parse(visitorInfoArr[10]);
                    boolean hasPaid = Boolean.parseBoolean(visitorInfoArr[11]);
                    int visitCount = Integer.parseInt(visitorInfoArr[12]);
                    // Create Visitor object and add to history
                    Visitor visitor = new Visitor(idNumber, firstName, lastName, birthday, gender, phoneNumber, email, address, visitorId, ticketType, entryDate, hasPaid, visitCount);
                    rideHistory.add(visitor);
                    count++;
                } else {
                    System.out.println("Missing visitor info fields: " + row);
                }
            }
            System.out.println(filename + " has been imported, " + count + " visitors has been add to history.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
