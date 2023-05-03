import java.util.Scanner;

import javax.xml.stream.events.Characters;

import java.util.ArrayList;;
public class MainProgram {
    //TODO: test all function of Person, Student, and Employee first

    public static void main (String[] args){
        Persons listofPersons = new Persons();
        while (true){
            System.out.println("===================================================");
            System.out.println("Enter option from list below");
            System.out.println(
            "    1)Display complete directory\n" + 
            "    2)Enter new Person\n" + 
            "    3)Search for new person\n" +
            "    4)Modify Person information\n" +
            "    5)Delete a record.\n" +
            "    Q)Quit");
            Scanner inp = new Scanner(System.in);
            String userInput = inp.nextLine().toLowerCase();

            if (userInput.equals("q")) break;
            else if (userInput.equals("1")) System.out.println(listofPersons);
            else if (userInput.equals("2")) enterNewPerson(listofPersons, inp);
            else if  (userInput.equals("3")) {
                System.out.println("  Enter name of person you want to search for");
                String nameSearch = inp.nextLine();
                Persons res = listofPersons.search(nameSearch);
                System.out.println(res);
            }

            else if (userInput.equals("4")){
                System.out.println("   Enter the name of person you want to modify");
                String name = inp.nextLine();
                Persons modifyList = listofPersons.search(name);
                for (Person a : modifyList.getInternalList()){
                    System.out.println(a);
                    System.out.println("    Do you want to modify this person?");
                    char userCommand = Character.toLowerCase(inp.next().charAt(0));
                    
                }
            }

            else if (userInput.equals("5")){
                System.out.println("Please enter the index for the record you want to delete");
                int index = inp.nextInt();
                if (index < 0 || index >= listofPersons.getSize()){
                    System.out.println("Error. Invalid Index");
                    continue; //!move to another choice
                }
                System.out.println(listofPersons.getPerson(index));
                System.out.println("Do you want to delete this Person? Answer y/n");
                char userCommand = Character.toLowerCase(inp.next().charAt(0));
                if (userCommand == 'y'){
                    listofPersons.delete(index);
                }
            }
            
            else{
                System.out.println("Invalid Input. Please choose one of the command in the following menu");
            }

        }

    }




    

    public static void enterNewPerson(Persons P, Scanner k){
        System.out.println("Please enter name for person");
        String newName = k.nextLine();
        System.out.println("Please enter the address for person");
        String address = k.nextLine();
        System.out.println("Please enter the phone for person");
        String phone = k.nextLine();
        System.out.println("Is this person a student? Answer y/n");
        char userInput = Character.toLowerCase(k.next().charAt(0));
        //TODO: maybe we need to check for the case which user's answer does not contain y/n as first character
        if (userInput == 'y'){
            System.out.println("Please enter graduation year");
            int year = k.nextInt();
            Student newObj = new Student(newName, address, phone, year);
            P.add(newObj);
            return;
        }

        // pass here means userInput is not
        System.out.println(("Is this person an employee? Answer y/n"));
        //TODO: check user's answer right here like above
        if (userInput == 'y'){
            System.out.println("Please enter department");
            String department = k.nextLine();
            Employee newObj = new Employee(newName, address, phone, department);
            P.add(newObj);
            return;
        }

        Person newObj = new Person(newName, address, phone);
        P.add(newObj);
    }
    
}
