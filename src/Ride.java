public class Ride {
    private String rideName;
    private double minHeight;
    private boolean isOpen;
    private Employee operator;

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
}
