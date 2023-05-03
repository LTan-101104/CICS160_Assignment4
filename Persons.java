import java.util.ArrayList;
public class Persons {

    private ArrayList<Person> list;
    private int size;
    Persons(){
        this.list = new ArrayList<Person>();
        this.size = 0;
    }

    // design this accordingly in order for it to print all the person object inside the list
    public String toString(){ //! checked 
        String res = "";
        for (Person obj : this.list){
            res += (obj.toString() + "\n_______________________________________________\n");
        }
        return res; // ! Not clear why we need to have this return statement, by the way it is null not any String
    }

    public void add(Person obj){ //! checked
        this.list.add(obj);
        this.size ++;
    }

    public int getSize(){ //!checked
        return this.size;
    }

    public Persons search(String name){ //! checked
        // currently this only add if it is the same string, does not ignore cases
        Persons res = new Persons();
        for (Person obj : this.list){
            if (obj.getName().equals(name)) res.add(obj);
        }
        return res;
    }

    public void delete(int i){ //! checked
        this.list.remove(i);
        this.size --;
    }

    public ArrayList<Person> getInternalList(){ //for aturo grader to check
        return this.list;
    }

}
