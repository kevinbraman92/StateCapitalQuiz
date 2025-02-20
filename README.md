# StateCapitalQuiz
A fun quiz program that gives a user a state and asks for the state capital. Keeps track of correct guesses. 

To run simply run Main.java. The file will handle everything else. Make sure to have all the files in the same directory for the program to work correctly. 

The program implementation involves reading from a text file all the state information and entering it into a TreeMap object. 
An ArrayList is used to temporarily hold the string values as they are read from the file to ensure the State objects are created correctly, before being entered into the TreeMap using the format (Key: State Abbreviation, Value: State object). 
The orginal ArrayList is reused and all the state abbreviations are copied over into it. For the quiz function, a random integer is created and used to pick a random index variable from the ArrayList. This variable is used as a key vlaue to pick a state from
the TreeMap and the user's input is crossed-referenced with the data values from the TreeMap. 
