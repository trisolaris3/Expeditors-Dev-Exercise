import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * OccupantInfo- program to display households and number of members, followed by sorted information about each resident
 * given and input file containing the names of the occupants with their address and age
 * @author    Stephen Johnston
 */

public class OccupantInfo {
    
   /**
   * reads from the file 'input.txt' and uses the information to 
   * prints out each address and the number of occupants living there
   * then prints out a list of occupants over the age of 18 sorted by first name then last name
   * and the age and address of each occupant
   * @param arg A string array containing command line arguments
   * @exception IOException
   * @return no return value
   */
    public static void main(String[] args) throws IOException {
        // initialize data structures, BufferedReader
        File inputData = new File("input.txt");
        BufferedReader inputReader = new BufferedReader(new FileReader(inputData));
        String personString;
        HashMap<String, Integer> households = new HashMap<String, Integer>();
        ArrayList<Occupant> occupants = new ArrayList<Occupant>();

        // parse each line of input, correct the corresponding address, and store information in HashMap households and ArrayList occupants
        while ((personString = inputReader.readLine()) != null) {
            String[] personArr = personString.split("\",\"|\""); // split string using regular expressions
            String address = generateAddress(personArr[3], personArr[4], personArr[5]);
            if (households.containsKey(address)) {
                households.put(address, households.get(address) + 1);
            } else households.put(address, 1);
            if (Integer.parseInt(personArr[6]) >= 18) {
                occupants.add(new Occupant(personArr[1], personArr[2], address, Integer.parseInt(personArr[6])));
            }
        }

        // print addresses and their number of residents 
        System.out.println("\nAddresses and numbers of residents: ");
        for (String address : households.keySet()) {
            System.out.println("Address: " + address + "\nOccupants: " + households.get(address));
        }
        System.out.println();
        
        // print information about the occupants 
        Collections.sort(occupants);
        System.out.println("Occupants at least age 18: ");
        for (Occupant o : occupants) {
            System.out.println(o.toString());
        }
        System.out.println();

        inputReader.close();
    }   
    
    /**
    * corrects the formatting of an address by removing unnecessary commas, fixing capitalization, and making sure street types end with a period
    * @param street
    * @param city
    * @param state
    * @exception does not throw exceptions
    * @return a String representing a corrected address
    */
    public static String generateAddress(String street, String city, String state) {
        String[] streetSubstrings = street.split(" ");
        street = "";
        for (String s : streetSubstrings) {
            if (s.charAt(s.length() - 1) == ',') s = s.substring(0, s.length() - 1); 
            if (s.length() > 1) s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase(); 
            if (s.equals("St") || s.equals("Blvd") || s.equals("Ave")) s += "."; 
            street += s + " ";
        }
        city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
        return street.substring(0, street.length() - 1) + ", " + city + ", " + state.toUpperCase();
    }

}
