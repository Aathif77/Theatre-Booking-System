
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;


public class Theatre {


    static int[] Row1 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] Row2 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] Row3 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static ArrayList <Ticket> receipt = new ArrayList<>();



    public static void main(String[] args) throws IOException {         // main method validated , switch case is used
        System.out.println(" \n*** Welcome to the New Theatre ***\n");


        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("-----------------------------");

            Scanner input = new Scanner(System.in);
            System.out.print("Enter option:");
            String user_input1 = input.nextLine();

            switch (user_input1) {            //used enhanced switch
                case "1" -> buy_ticket();
                case "2" -> print_seating_area();
                case "3" -> cancel_ticket();
                case "4" -> show_available();
                case "5" -> save();
                case "6" -> load();
                case "7" -> show_tickets_info();
                case "8" -> sort_tickets();
                case "0" -> {
                    System.out.println("\n*** Thank You ***\n");
                    System.exit(0);                                 // when entered 0 this program will end
                }
                default -> System.out.println("Please try a valid option!");
            }
        }
    }
    public static void buy_ticket() {       // method1 , used try catch validation for input mismatch exception
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter row number:");
            int row_num = input.nextInt();
            if (row_num == 1 || row_num == 2 || row_num == 3) {
                System.out.print("Enter seat number: ");
                int seat_num = input.nextInt();
                if (seat_num != 0) {
                    switch (row_num) {
                        case 1 -> {
                            if (seat_num < Row1.length) {
                                if (Row1[seat_num] == 0) {
                                    System.out.println("This seat is available!\n");
                                    Row1[seat_num] = 1;
                                    System.out.print("Please enter your Name:");
                                    String name = input.next();
                                    System.out.print("Please enter your Surname:");
                                    String surname = input.next();
                                    System.out.print("Please enter your Email:");
                                    String email = input.next();
                                    System.out.println("\n *** Your Ticket is booked ***");
                                    Ticket ticket1 = new Ticket(1, seat_num, 100, new Person(name, surname, email));   //bringing the methods of another class.
                                    receipt.add(ticket1);                                                               // adding to the arraylist
                                } else {
                                    System.out.println("This seat is not available!");
                                }
                            } else {
                                System.out.println("Please enter valid seat number!");
                            }
                        }
                        case 2 -> {
                            if (seat_num < Row2.length) {
                                if (Row2[seat_num] == 0) {
                                    System.out.println("This seat is available!\n");
                                    Row2[seat_num] = 1;
                                    System.out.print("Please enter your Name:");
                                    String name = input.next();
                                    System.out.print("Please enter your Surname:");
                                    String surname = input.next();
                                    System.out.print("Please enter your Email:");
                                    String email = input.next();
                                    System.out.println("\n *** Your Ticket is booked ***");
                                    Ticket ticket2 = new Ticket(2, seat_num, 200, new Person(name, surname, email));
                                    receipt.add(ticket2);
                                } else {
                                    System.out.println("This seat is not available!");
                                }
                            } else {
                                System.out.println("Please enter valid seat number!");
                            }
                        }
                        case 3 -> {
                            if (seat_num < Row3.length) {
                                if (Row3[seat_num] == 0) {
                                    System.out.println("This seat is available!\n");
                                    Row3[seat_num] = 1;
                                    System.out.print("Please enter your Name:");
                                    String name = input.next();
                                    System.out.print("Please enter your Surname:");
                                    String surname = input.next();
                                    System.out.print("Please enter your Email:");
                                    String email = input.next();
                                    System.out.println("\n *** Your Ticket is booked ***");
                                    Ticket ticket3 = new Ticket(3, seat_num, 300, new Person(name, surname, email));
                                    receipt.add(ticket3);
                                } else {
                                    System.out.println("This seat is not available!");
                                }
                            } else {
                                System.out.println("Please enter valid seat number!");
                            }
                        }
                    }
                } else {
                    System.out.println("Please enter valid seat number!");
                }
            } else {
                System.out.println("Please enter valid Row number!");
            }
        }catch(InputMismatchException e){
            System.out.println("Enter a valid integer!");
        }
    }

    public static void print_seating_area() {  // printing of the stage and rows , I have used copy of range function,
                                               // so I can split the array and leave a space to get the required output

        System.out.println("\n      ***********");
        System.out.println("       * STAGE *");
        System.out.println("      ***********");
        System.out.print("     ");

        int[] Row1_split1= Arrays.copyOfRange(Row1,1,7);int[] Row1_split2=Arrays.copyOfRange(Row1,7,13);
        System.out.print(Arrays.toString(Row1_split1).replace(",", "").replace("[", "").replace("]", "").replace(" ", "").replace("0","o").replace("1","x"));
        System.out.print(" ");
        System.out.print(Arrays.toString(Row1_split2).replace(",", "").replace("[", "").replace("]", "").replace(" ", "").replace("0","o").replace("1","x"));
        System.out.println("            ");
        System.out.print("   ");

        int[] Row2_split1= Arrays.copyOfRange(Row2,1,9);int[] Row2_split2=Arrays.copyOfRange(Row2,9,17);
        System.out.print(Arrays.toString(Row2_split1).replace(",", "").replace("[", "").replace("]", "").replace(" ", "").replace("0","o").replace("1","x"));
        System.out.print(" ");
        System.out.println(Arrays.toString(Row2_split2).replace(",", "").replace("[", "").replace("]", "").replace(" ", "").replace("0","o").replace("1","x"));
        System.out.print(" ");

        int[] Row3_split1= Arrays.copyOfRange(Row3,1,11);
        int[] Row3_split2=Arrays.copyOfRange(Row3,11,21);
        System.out.print(Arrays.toString(Row3_split1).replace(",", "").replace("[", "").replace("]", "").replace(" ", "").replace("0","o").replace("1","x"));
        System.out.print(" ");
        System.out.println(Arrays.toString(Row3_split2).replace(",", "").replace("[", "").replace("]", "").replace(" ", "").replace("0","o").replace("1","x"));

        }




    public static void cancel_ticket() {  // this will cancel the bought tickets, I have used try catch here as well for input mismatch exception
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter row number: ");
            int row_num2 = input.nextInt();
            if (row_num2 == 1 || row_num2 == 2 || row_num2 == 3) {
                System.out.print("Enter seat number:");
                int seat_num2 = input.nextInt();
                if (seat_num2 != 0) {
                    switch (row_num2) {
                        case 1 -> {                                // used enhanced switch case
                            if (seat_num2 < Row1.length) {
                                if (Row1[seat_num2] == 1) {
                                    System.out.println("This seat is available again!");
                                    Row1[seat_num2] = 0;
                                    receipt.removeIf(row1_remove -> row1_remove.getRow() == 1 && row1_remove.getSeat() == seat_num2);    // this will remove the data from the array, this is a lambda expression
                                } else {
                                    System.out.println("This seat is not booked!");
                                }
                            } else {
                                System.out.println("Please enter valid Seat number!");
                            }
                        }
                        case 2 -> {
                            if (seat_num2 < Row2.length) {
                                if (Row2[seat_num2] == 1) {
                                    System.out.println("This seat is available again!");
                                    Row2[seat_num2] = 0;
                                    receipt.removeIf(row2_remove -> row2_remove.getRow() == 2 && row2_remove.getSeat() == seat_num2);
                                } else {
                                    System.out.println("This seat is not booked!");
                                }
                            } else {
                                System.out.println("Please enter valid Seat number!");
                            }
                        }
                        case 3 -> {
                            if (seat_num2 < Row3.length) {
                                if (Row3[seat_num2] == 1) {
                                    System.out.println("This seat is available again!");
                                    Row3[seat_num2] = 0;
                                    receipt.removeIf(row3_remove -> row3_remove.getRow() == 3 && row3_remove.getSeat() == seat_num2);
                                } else {
                                    System.out.println("This seat is not booked!");
                                }
                            } else {
                                System.out.println("Please enter valid Seat number!");
                            }
                        }
                    }

                } else {
                    System.out.println(" Please enter valid seat number!");
                }
            } else {
                System.out.println("Please enter valid row number!");
            }
        }catch (InputMismatchException e){
            System.out.println("Enter a valid integer!");
        }
    }
    public static void show_available() { // this will show the available seats
        List<Integer> Available_seats=new ArrayList<>(); List<Integer> Available_seats2=new ArrayList<>(); List<Integer> Available_seats3=new ArrayList<>(); // I have added arraylist for this
        for (int i=1;i< Row1.length;i++) {
            if (Row1[i] == 1) {
                continue;
            }Available_seats.add(i);   // add to the arraylist
        }
        for (int j=1;j< Row2.length;j++) {
            if (Row2[j] == 1) {
                continue;
            }Available_seats2.add(j);
        }
        for (int k=1;k< Row3.length;k++){
            if (Row3[k] == 1) {
                continue;
            }Available_seats3.add(k);
        }
        String show_seat= Available_seats.toString();String show_seat2=Available_seats2.toString();String show_seat3=Available_seats3.toString();
        System.out.println("Seats available in Row 1:"+" "+show_seat.replace("[","").replace("]","")+".");
        System.out.println("Seats available in Row 2:"+" "+show_seat2.replace("[","").replace("]","")+".");
        System.out.println("Seats available in Row 3:"+" "+show_seat3.replace("[","").replace("]","")+".");
    }

    public static void save() throws IOException {    // saving to a file


        File Seat_info = new File("Seat_Info.txt"); // creating a new file by providing the file name to be created
        if (Seat_info.createNewFile()) {
            System.out.println("File created");                        // I have used the code which I used in method above in order to save to the file
        } else {
            System.out.println("File already exists");
        }
        List<Integer> Available_seats=new ArrayList<>(); List<Integer> Available_seats2=new ArrayList<>(); List<Integer> Available_seats3=new ArrayList<>();
        for (int i=1;i< Row1.length;i++) {
            if (Row1[i] == 1) {
                continue;
            }Available_seats.add(i);
        }
        for (int j=1;j< Row2.length;j++) {
            if (Row2[j] == 1) {
                continue;
            }Available_seats2.add(j);
        }
        for (int k=1;k< Row3.length;k++){
            if (Row3[k] == 1) {
                continue;
            }Available_seats3.add(k);                    // usage of printWriter function to write to a file
        }
        String show_seat= Available_seats.toString();String show_seat2=Available_seats2.toString();String show_seat3=Available_seats3.toString();
        PrintWriter Seat_count=new PrintWriter("Seat_Info.txt");
        Seat_count.println("Seats available in Row 1:"+" "+show_seat.replace("[","").replace("]","")+".");
        Seat_count.println("Seats available in Row 2:"+" "+show_seat2.replace("[","").replace("]","")+".");
        Seat_count.println("Seats available in Row 3:"+" "+show_seat3.replace("[","").replace("]","")+".");

        System.out.println("Successfully wrote to the file");

        Seat_count.close();

    }

    public static void load() throws FileNotFoundException {  //loading a file by reading
        File Seat_count =new File("Seat_Info.txt");
        Scanner Read_file=new Scanner(Seat_count);
        while (Read_file.hasNextLine()){
            String load_file=Read_file.nextLine();
            System.out.println(load_file);
        }Read_file.close();
    }
    public static void show_tickets_info(){    // this will output  the ticket info
        System.out.println("\n *** RECEIPT ***\n");
        double total = 0;
        for ( Ticket i:receipt) {
            System.out.println(i.print());  // the method print from ticket class is called here

            total += i.getPrice();

        } System.out.println("The total price will be: "+total);

    }


    public static void sort_tickets(){
        receipt.sort((o1, o2) -> (int) (o1.getPrice() - (o2.getPrice()))); // usage of comparator , autocorrected to lambda expression.
        System.out.println("\n Receipts are sorted out based on: Prices\n ");
        double total = 0;
        for ( Ticket i:receipt) {
            System.out.println(i.print());  // calling the method show tickets for printing in the required way

            total += i.getPrice();

        } System.out.println("The total price will be: "+total);



    }
}

/*REFERENCES USED
1. https://www.javatpoint.com/operators-in-java#:~:text=Java%20OR%20Operator%20Example%3A%20Logical,condition%20is%20true%20or%20false.
2.https://stackoverflow.com/questions/34360578/skip-int-element-in-array-if-it-is-equal-to-6-when-printing
3.https://www.tutorialspoint.com/How-to-divide-an-array-into-half-in-java#:~:text=Using%20the%20copyOfRange()%20method,2%20to%20length%20to%20other.
4.http://www.beginwithjava.com/java/file-input-output/writing-text-file.html#:~:text=The%20simplest%20way%20to%20write,for%20writing%20to%20the%20console.
5. www.w3schools.com
6.https://youtu.be/fe0HtMsqKAs
7.https://youtu.be/zJcpWNefWt4
8.https://youtu.be/cqm8hwkN1ochttps://youtu.be/cqm8hwkN1oc
9.https://youtu.be/eboNNUADeIc
10. lecture slides (blackboard)

*/




