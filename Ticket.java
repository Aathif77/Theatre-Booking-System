

public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;    //bringing attributes of person class

     // I have used getters, constructors and setters too,
    // setters haven't been used in my code, made it for display purpose.
    public Person getPerson() {
        return person;
    }

    public Ticket(Person person) {
        this.person = person;
    }

    public Ticket(int row, int seat, double price, Person person) {
        this.row=row; this.seat=seat; this.price=price;this.person=person;
    }

    public String print(){               //method created and called in theatre class
        System.out.println("Name: "+person.getName());
        System.out.println("Surname: "+person.getSurname());
        System.out.println("Email: "+ person.getEmail());
        System.out.println("Row Number: "+ row);
        System.out.println("Seat Number: "+ seat);
        System.out.println("Price: "+price);
        return "\n";
    }



    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}