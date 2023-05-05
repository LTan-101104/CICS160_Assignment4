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
                System.out.println("*Enter name of person you want to search for"); //TODO: need to ask again about whether or not we should treat uppercase and lowercase as the same in this operation
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
                    char userCommand = Character.toLowerCase(inp.nextLine().charAt(0));
                    if (userCommand == 'y'){
                        while (true){
                            System.out.println("*Please enter the number associated with the field you want to modify:\n" 
                            + "     1)Name\n" 
                            + "     2)Address\n"
                            + "     3)Phone\n");
                            userCommand = Character.toLowerCase(inp.nextLine().charAt(0));
                            System.out.println("*Enter the new value that you want to assign to the field");
                            String valueChange = inp.nextLine();
                            if (userCommand == '1') a.setName(valueChange);
                            else if (userCommand == '2') a.setAddress(valueChange);
                            else if (userCommand == '3') a.setPhone(valueChange);
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
                char userCommand = Character.toLowerCase(inp.nextLine().charAt(0));
                if (userCommand == 'y'){
                    listofPersons.delete(index);
                }
            }
            
            else{ //!checked
                System.out.println("Invalid Input. Please choose one of number of the associated command in the following menu.");
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
        char userInput = Character.toLowerCase(k.nextLine().charAt(0));
        if (userInput == 'y'){
            System.out.println("*Please enter graduation year");
            int year = k.nextInt();
            k.nextLine(); //move cursor to new line, good habit although this is not oriinally a problem since the first print statement will take care of this
            Student newObj = new Student(newName, address, phone, year);
            P.add(newObj);
            return;
        }
        System.out.println(("*Is this person an employee? Answer y to confirm. Press any other keys to cancel."));
        userInput = Character.toLowerCase(k.nextLine().charAt(0));
        if (userInput == 'y'){
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
