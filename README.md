to run (in terminal, from project directory):
    javac OccupantInfo.java 
    java OccupantInfo

input is given as a .txt file, output is displayed in the terminal

assumptions made and notes about problem solving:: 
"where the occupant(s) is older than 18" is interpreted as all the occupants aged at least 18, because this makes sense in a real world scenario
address formatting errors are to be fixed, ex. "123 Main St., Seattle, WA" should be treated as the same address as "123 main st, seattle, Wa"
    however apparent address content errors are not fixed as they should require further user interaction in a realworld scenario, so
    "Tacoma, WA" and "Tacoma, FL" addresses are treated as different, even though the latter is likely a user error
the input data is to be read from a text file in the project directory
individual occupants were best represented by a new class, Occupant.java, while a HashMap was sufficient to organize the addresses
because this was meant to be a standalone executable, for testing I wrote a class that outputs test outcomes to the console
    because it was not a given that JUnit would be present on the environment this program is to be run on 
    however, on a larger scale project I would have done more indepth testing utilizing JUnit