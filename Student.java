public class Student extends Person{
    // in java, it seems that you don't need something like a super.__init__ function like that in Python
    // All attributes from mother class will be passed for son, so are all the methods

    private int year;

    Student(String newName, String address, String phone, int year){
        // ! super acts like super.__init__, which will call the father class and assign all the old attributes that this derive from the higher class
        super(newName, address, phone);
        this.year = year;
    }

    public void setGraduationYear(int year){
        this.year = year;
    }

    public int getGraduationYear(){
        return this.year;
    }

    public String toString(){ //TODO: may want to find a way to inherit part of this from person
        return super.toString() + "\nGraduation year:   " + this.year;
    }
}
