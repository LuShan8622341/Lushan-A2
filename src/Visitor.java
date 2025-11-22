import java.util.Date;

public class Visitor extends Person {
    private String visitorId;
    private String ticketType;
    private Date entryDate;
    private boolean hasPaid;
    private int visitCount;

    public Visitor() {
        super();
    }

    public Visitor(String idNumber, String firstName, String lastName, Date birthday, String gender,
                   String phoneNumber, String email, String address,
                   String visitorId, String ticketType, Date entryDate,
                   boolean hasPaid, int visitCount) {

        super(idNumber, firstName, lastName, birthday, gender, phoneNumber, email, address);

        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.entryDate = entryDate;
        this.hasPaid = hasPaid;
        this.visitCount = visitCount;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId='" + visitorId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", entryDate=" + entryDate +
                ", hasPaid=" + hasPaid +
                ", visitCount=" + visitCount +
                "} " + super.toString();
    }
}
