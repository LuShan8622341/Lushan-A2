import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Sort by ticketType: VIP first
        int ticketCompare = ticketPriority(v1.getTicketType()) - ticketPriority(v2.getTicketType());
        if (ticketCompare != 0) {
            return ticketCompare;
        }

        // Reverse order by visitCount
        int visitCountCompare = Integer.compare(v2.getVisitCount(), v1.getVisitCount());
        if (visitCountCompare != 0) {
            return visitCountCompare;
        }

        // Alphabetical order of firstName
        return v1.getFirstName().compareTo(v2.getFirstName());
    }

    private int ticketPriority(String ticketType) {
        switch (ticketType.toUpperCase()) {
            case "VIP": return 1;
            case "STANDARD": return 2;
            default: return 3; // other ticket types have the lowest priority
        }
    }
}