import java.util.Scanner;
public class MainProgram {

    public static void main (String[] args){
        Persons listofPersons = new Persons();
        while (true){
            System.out.println("\n=========================================================================");
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

            if (userInput.equals("q")) break; //!checked
            else if (userInput.equals("1")) System.out.println("\n" + listofPersons); //! checked
            else if (userInput.equals("2")) enterNewPerson(listofPersons, inp); //! checked, works fine now but may have problem when accidentially not choose y or n
            else if  (userInput.equals("3")) { //!checked
                System.out.println("*Enter name of person you want to search for"); 
                String nameSearch = inp.nextLine();
                Persons res = listofPersons.search(nameSearch);
                if (res.getSize() == 0) {
                    System.out.println("Not found");
                    continue;
                }
                System.out.println("\n" + res);
            }

            else if (userInput.equals("4")){ //!checked
                System.out.println("*Enter the name of person record you want to modify");
                String name = inp.nextLine();
                Persons modifyList = listofPersons.search(name);
                if (modifyList.getSize() == 0){
                    System.out.println("Not found");
                    continue;
                }
                for (Person a : modifyList.getInternalList()){
                    System.out.println(a);
                    System.out.println("*Do you want to modify this person? Answer y to confirm. Press any other keys to cancel.");
                    String userCommand = inp.nextLine().toLowerCase();
                    if (userCommand.equals("y")){
                        while (true){
                            System.out.println("*Please enter the number associated with the field you want to modify:\n" 
                            + "     1)Name\n" 
                            + "     2)Address\n"
                            + "     3)Phone\n");
                            userCommand = inp.nextLine().toLowerCase();
                            System.out.println("*Enter the new value that you want to assign to the field");
                            String valueChange = inp.nextLine();
                            if (userCommand.equals("1")) a.setName(valueChange);
                            else if (userCommand.equals("2")) a.setAddress(valueChange);
                            else if (userCommand.equals("3")) a.setPhone(valueChange);
                            else{
                                System.out.println("Invalid input. Please choose the associated number of the field you want to modify below.\n");
                                continue;
                            } 
                            break; 
                        }
                    }
                }
            }

            else if (userInput.equals("5")){ //!checked
                System.out.println("*Please enter the index for the record you want to delete");
                int index = inp.nextInt(); 
                inp.nextLine(); // end current line and move to a complete new line
                if (index < 0 || index >= listofPersons.getSize()){
                    System.out.println("Error. Invalid Index."); //! quick and interesting note: the problem above does not appear when this if runs, simply because this print statement already turn to a new line for us, so in the next big while loop, the nextLine is already on a completely new line
                    continue; //!move to another choice
                }
                System.out.println(listofPersons.getPerson(index));
                System.out.println("*Do you want to delete this Person? Answer y to confirm. Press any other keys to cancel."); 
                String userCommand = inp.nextLine().toLowerCase();
                if (userCommand.equals("y")){
                    listofPersons.delete(index);
                }
            }
            
            else{ //!checked
                System.out.println("Invalid Input. Please choose one of the associated commands in the following menu.");
            }

        }

    }



    public static void enterNewPerson(Persons P, Scanner k){
        System.out.println("*Please enter name for person");
        String newName = k.nextLine();
        System.out.println("*Please enter the address for person");
        String address = k.nextLine();
        System.out.println("*Please enter the phone for person");
        String phone = k.nextLine();
        System.out.println("*Is this person a student? Answer y to confirm. Press any other keys to cancel.");
        String userInput = k.nextLine().toLowerCase();
        if (userInput.equals("y")){
            System.out.println("*Please enter graduation year");
            int year = k.nextInt();
            k.nextLine(); //move cursor to new line, good habit although this is not oriinally a problem since the first print statement will take care of this
            Student newObj = new Student(newName, address, phone, year);
            P.add(newObj);
            return;
        }
        System.out.println(("*Is this person an employee? Answer y to confirm. Press any other keys to cancel."));
        userInput = k.nextLine().toLowerCase();
        if (userInput.equals("y")){
            System.out.println("*Please enter department");
            String department = k.nextLine(); 
            Employee newObj = new Employee(newName, address, phone, department);
            P.add(newObj);
            return;
        }

        Person newObj = new Person(newName, address, phone);
        P.add(newObj);
    }
    
}
