package oops;
//Entity class

public class Emp {

    public int getId() {
        return eId;
    }

    public void setId(int eId) {
        this.eId = eId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return eName;
    }

    public void setName(String eName) {
        this.eName = eName;
    }

    private int eId ;
    private float salary ;
    private String eName;

    Emp(){
        System.out.println("Employee created");
    }
    void display(){
        System.out.println("Employee Id :" + this.eId);
        System.out.println("Employee Salary :" + this.salary);
        System.out.println("Employee Name :" + this.eName);
    }

@Override
    public String toString(){
        return "Employee detail - Id:" + this.eId + ",Name:" + this.eName + ",Salary:" + this.salary;
}

}
