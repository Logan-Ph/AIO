public class Employee {
    private String employeeId, employeeName;
    private int salaryPerHour, noOfLeavingDay = 0, noOfTravelDay = 0;

    public Employee(String employeeId, String employeeName, int salaryPerHour) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salaryPerHour = salaryPerHour;
    }

    public Employee(String employeeId, String employeeName, int salaryPerHour, int noOfLeavingDay, int noOfTravelDay) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salaryPerHour = salaryPerHour;
        this.noOfLeavingDay = noOfLeavingDay;
        this.noOfTravelDay = noOfTravelDay;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getNoOfLeavingDay() {
        return noOfLeavingDay;
    }

    public void setNoOfLeavingDay(int noOfLeavingDay) {
        this.noOfLeavingDay = noOfLeavingDay;
    }

    public int getNoOfTravelDay() {
        return noOfTravelDay;
    }

    public void setNoOfTravelDay(int noOfTravelDay) {
        this.noOfTravelDay = noOfTravelDay;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int calculateWeeklySalary() {
        return salaryPerHour * 8 * (5 - noOfLeavingDay + noOfTravelDay / 2);
    }

    public int estimateWeeklySalary() {
        return salaryPerHour * 8 * (5 - 0 + 0 / 2);
    }

    public int compareTo(Employee obj) {
        if (obj.noOfTravelDay > this.noOfTravelDay) {
            return 1;
        } else if (obj.noOfTravelDay == this.noOfTravelDay) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "[Name:"+getEmployeeName()+" - Salary Per Hour: "+getSalaryPerHour()+" - Weekly Salary: "+calculateWeeklySalary()+"]";
    }
}
