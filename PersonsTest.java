import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import org.junit.Test;

public class PersonsTest { //Note that we seem to have to mention <something> Test, with something as the class we want to test. 
                            // If we don't do that, it is seemingly that we cannot insanitate object from class Peron
    
    @Test
    public void addTest(){ 
        Persons listObj = new Persons();
        Person obj1 = new Person("Tan Le", "90 Butterfield Terrace", "4132104427");
        Student obj2 = new Student("Phuc", "70 Amity Street", "452354454235", 2027);
        Employee obj3 = new Employee("Hoang", "89 Union Street", "3153412421", "Military Department");
        Person obj4 = new Person("Vladimir", "780 Eagle Landing", "2143242313412");
        ArrayList<Person> myArray = new ArrayList<Person>();
        myArray.add(obj1);
        myArray.add(obj2);
        myArray.add(obj3);
        myArray.add(obj4);

        listObj.add(obj1);
        listObj.add(obj2);
        listObj.add(obj3);
        listObj.add(obj4);

        assertEquals(myArray, listObj.getInternalList());
        myArray.remove(obj4);
        assertNotEquals(myArray, listObj.getInternalList());
    }

    @Test
    public void deleteTest(){
        //initialize objects for testing
        Persons listObj = new Persons();
        Person obj1 = new Person("Tan Le", "90 Butterfield Terrace", "4132104427");
        Student obj2 = new Student("Phuc", "70 Amity Street", "452354454235", 2027);
        Employee obj3 = new Employee("Hoang", "89 Union Street", "3153412421", "Military Department");
        Person obj4 = new Person("Vladimir", "780 Eagle Landing", "2143242313412");
        ArrayList<Person> myArray = new ArrayList<Person>();
        myArray.add(obj1);
        myArray.add(obj2);
        myArray.add(obj3);
        myArray.add(obj4);
        listObj.add(obj1);
        listObj.add(obj2);
        listObj.add(obj3);
        listObj.add(obj4);

        //testing
        myArray.remove(0);
        listObj.delete(0);
        assertEquals(myArray, listObj.getInternalList());
        myArray.remove(2);
        listObj.delete(2);
        assertEquals(myArray, listObj.getInternalList());
        myArray.add(obj4);
        assertNotEquals(myArray, listObj.getInternalList());

    }


}    

