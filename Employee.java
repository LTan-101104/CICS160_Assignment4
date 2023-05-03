public class Employee extends Person{
    private String department;

    Employee (String newName, String address, String phone, String department){
        super(newName, address, phone);
        this.department = department;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String toString(){ 
        return super.toString() + "\nDepartment:    " + this.department;
    }
}
