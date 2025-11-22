import java.util.Date;

public class Employee extends Person {
    private String employeeId;
    private String department;
    private String position;
    private double salary;
    private Date hireDate;

    public Employee() {
        super();
    }

    public Employee(String idNumber, String firstName, String lastName, Date birthday, String gender,
                    String phoneNumber, String email, String address,
                    String employeeId, String department, String position, double salary, Date hireDate) {
        super(idNumber, firstName, lastName, birthday, gender, phoneNumber, email, address);
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                "} " + super.toString();
    }
}
