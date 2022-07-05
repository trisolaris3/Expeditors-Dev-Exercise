/**
 * Occupant- class to store the name, age, and address of a resident
 * @author    Stephen Johnston
 */

public class Occupant implements Comparable<Occupant> {
    
    private String first, last, address;
    private int age;

    /**
     * @param first
     * @param last
     * @param address
     * @param age
     */
    public Occupant(String first, String last, String address, int age) {
        this.first = first;
        this.last = last;
        this.address = address;
        this.age = age;
    }

    /**
     * @param none
     * @exception none
     * @return String representing occupant's first name
     */
    public String getFirst() {
        return this.first;
    }

    /**
     * @param none
     * @exception none
     * @return String representing occupant's last name
     */
    public String getLast() {
        return this.last;
    }

    /**
     * allows for occupants to be easily sorted in a collection based on last then first names
     * @param another occupant
     * @exception none
     * @return an int determining which Occupant object should be displayed first based on last then first names
     */
    @Override
    public int compareTo(Occupant o) {
        if (this.last.equals(o.getLast())) return this.first.compareTo(o.getFirst());
        return this.last.compareTo(o.getLast());
    }

    /**
     * @param none
     * @exception none
     * @return a String describing an occupant
     */
    @Override
    public String toString() {
        return "Name: " + this.last + ", " + this.first + "\nAddress: " + this.address + "\nAge: " + this.age;
    }

}
