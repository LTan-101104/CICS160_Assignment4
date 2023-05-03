class Person{
    // private: only those in the same class can see
    // default: only those in the same package can see
    // protected: those in and outside package can see, but only through inheritance
    // public inside and outside package can see
    protected String name;
    protected String address;
    protected String phone;

    Person(String newName, String address, String phone){
        this.name = newName;
        this.address = address;
        this.phone = phone;
    }
    Person() {}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public String toString(){
        //this function acts as __str__ in Python
        return "Name:   " + this.getName() + "\nAdress: " + this.getAddress() + "\nPhone:  " + this.getPhone();
    }
}