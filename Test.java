public class Test {

    /**
     * runs two methods to test functions in the OccupantInfo and Occupant classes
     * @author Stephen Johnston
     */
    public static void main(String[] args) {
        givenOccupants_whenCompare_thenReturnComparison();
        givenAddresses_whenCorrectFormatting_thenReturnAddresses();
    }

    /**
     * tests that the compareTo() method from Occupant works correctly 
     * outputs test outcome to console
     */
    private static void givenOccupants_whenCompare_thenReturnComparison() {
        Occupant occupant1 = new Occupant("B", "B", "address", 0);
        Occupant occupant2 = new Occupant("A", "C", "address", 0);
        Occupant occupant3 = new Occupant("B", "C", "address", 0);
        if (occupant1.compareTo(occupant2) < 0 && occupant2.compareTo(occupant3) < 0) {
            System.out.println("Occupant comparison works");
        } else System.out.println("Occupant comparison error");
    }

    /**
     * tests that the generateAddress() method from OccupantInfo works correctly 
     * outputs test outcome to console
     */
    private static void givenAddresses_whenCorrectFormatting_thenReturnAddresses() {
        String address1 = OccupantInfo.generateAddress("123, MAIN, ST", "SEATTLE", "WA");
        String address2 = OccupantInfo.generateAddress("123 main st", "seattle", "wa");
        if (address1.equals(address2) && address1.equals("123 Main St., Seattle, WA")) {
            System.out.println("Address generation works");
        } else System.out.println("Address generation error");
    }

}


