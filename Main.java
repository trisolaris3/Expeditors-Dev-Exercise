import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // processing input
        File inputData = new File("input.txt");
        BufferedReader inputReader = new BufferedReader(new FileReader(inputData));
        String personString;
        HashMap<String, Integer> households = new HashMap<String, Integer>();
        ArrayList<Occupant> occupants = new ArrayList<Occupant>();

        while ((personString = inputReader.readLine()) != null) {
            String[] personArr = personString.split("\",\"|\"");
            String address = generateAddress(personArr[3], personArr[4], personArr[5]);
            if (households.containsKey(address)) {
                households.put(address, households.get(address) + 1);
            } else households.put(address, 1);
            if (Integer.parseInt(personArr[6]) >= 18) {
                occupants.add(new Occupant(personArr[1], personArr[2], address, Integer.parseInt(personArr[6])));
            }
        }

        // printing addresses 
        System.out.println("\nAddresses and numbers of residents: ");
        for (String address : households.keySet()) {
            System.out.println("Address: " + address + "\nOccupants: " + households.get(address));
        }
        System.out.println();
        
        // printing occupants
        Collections.sort(occupants);
        System.out.println("Occupants at least age 18: ");
        for (Occupant o : occupants) {
            System.out.println(o.toString());
        }
        System.out.println();

        inputReader.close();
    }   
    
    // remove commas, correct capitalization, add periods
    public static String generateAddress(String street, String city, String state) {
        String[] streetSubstrings = street.split(" ");
        street = "";
        for (String s : streetSubstrings) {
            if (s.charAt(s.length() - 1) == ',') s = s.substring(0, s.length() - 1); // remove unnecessary commas
            if (s.length() > 1) s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase(); // fix capitalization
            if (s.equals("St") || s.equals("Blvd") || s.equals("Ave")) s += "."; // make sure street types end with a period
            street += s + " ";
        }
        city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
        return street.substring(0, street.length() - 1) + ", " + city + ", " + state.toUpperCase();
    }

}
