import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class QuizInterface {

    private ArrayList<String> stringStorage = new ArrayList<String>();
    private Map<String, State> stateTreeMap = new TreeMap<>();

    public QuizInterface() {
    }

    public void runQuiz() {
        this.readFile();
        this.getStates();
        this.quiz();
    }

    private void quiz() {
        int correctGuesses = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nWelcome to the state capital quiz!");
        System.out.println("This quiz will pick a random state and ask you to input the capital! Good luck!");
        System.out.println("Enter 'Exit' at any time to end the quiz.");
        while (true) {
            String randomState = this.stringStorage.get(this.randomNumber());
            System.out.println("\nWhat is the capital of the following state: "
                    + this.stateTreeMap.get(randomState));
            String input = userInput.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting quiz, you got " + correctGuesses + " state capitals right!");
                userInput.close();
                System.exit(0);
            } else if (input.equalsIgnoreCase(this.stateTreeMap.get(randomState).getCapital())) {
                System.out.println("Good job, you got it!");
                correctGuesses++;
            } else {
                System.out.println("Sorry, you got it wrong! The correct answer was "
                        + this.stateTreeMap.get(randomState).getCapital());
            }
        }
    }

    private void readFile() {
        try {
            File myObj = new File("states.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                this.stringStorage.add(data);
                if (this.stringStorage.size() == 3) {
                    State state = new State(stringStorage.get(1), stringStorage.get(0), stringStorage.get(2));
                    this.stateTreeMap.put(state.getAbbr(), state);
                    this.stringStorage.clear();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(
                    "states.txt not found! Please ensure the text file is in the same directory as the Java files!");
            System.out.println(
                    "Exiting program...");
            System.exit(1);
        }
    }

    private void getStates() {
        if (this.stringStorage.size() != 0) {
            this.stringStorage.clear();
        }
        for (String key : this.stateTreeMap.keySet()) {
            this.stringStorage.add(this.stateTreeMap.get(key).getAbbr());
        }
    }

    private int randomNumber() {
        Random randInt = new Random();
        return randInt.nextInt(this.stateTreeMap.size());
    }
}
