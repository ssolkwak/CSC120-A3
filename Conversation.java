import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Conversation {

  public static void main(String[] arguments) {

    /**
     * Creates a scanner object
     */
    Scanner input = new Scanner(System.in);

    /**
     * Creates a random object
     */
    Random rand = new Random();

    /**
     * Creates static string array with "canned" random responses
     */
    String[] randRes = {"Uh-huh...",
                    "How interesting!",
                    "Really?",
                    "Hmm...", 
                    "I see!", 
                    "That's great!"};

    /**
     * Creates a Map of String sets to store mirror word pairs
     */
    Map<String,String> mirrorWords = new HashMap<String,String>();

    /**
     * Add mirror word pairs to the Map mirrorWords
     * @param key: word to be replaced, value: word to replace
     */
    mirrorWords.put("I","you");
    mirrorWords.put("You","I");
    mirrorWords.put("you","I");
    mirrorWords.put("am","are");
    mirrorWords.put("I'm","you're");
    mirrorWords.put("You're","I'm");
    mirrorWords.put("you're","I'm");
    mirrorWords.put("me","you");
    mirrorWords.put("your","my");
    mirrorWords.put("my","your");
    mirrorWords.put("mine","yours");
    mirrorWords.put("yours","mine");

    /**
     * Stores conversation starter and ender as string objects
     */
    String starter = "Hi there! what's on your mind?";
    String ender = "Thanks for chatting!";

    /** 
     * Creates an Arraylist of Strings that stores lines for the transcript of the conversation
     */
    ArrayList<String> transcript = new ArrayList<>();

    /**
     * Prints the inquiry to ask how many rounds of conversation the user wants to have
     */
    System.out.print("How many rounds? ");

    /** 
     * Reads user input of total rounds wanted and saves it in int variable
     */
    int rounds = input.nextInt();

    /**
     * Loop iterates as long as current round is within the total number of rounds
     */
    for (int i = 1; i <= rounds; i++){
      /** 
       * Prints starter string before the first round 
       * Adds the starter string to the transcript
       * Gets ready to read the next input line
       */
      if (i == 1){
        System.out.println(starter);
        transcript.add(starter);
        input.nextLine();
      }

      /** 
       * Reads and stores user input line and adds it to the transcript
       */
      String inputLine = input.nextLine();
      transcript.add(inputLine);
      
      /**
       * Creates StringBuffer for constructing appropriate bot response
       */
      StringBuffer formResponse = new StringBuffer();

      /**
       * Splits user inputLine by words and store in a string array inputWords
       */
      String[] inputWords = inputLine.split(" ");

      /**
       * Loops through each word of the inputWords
       */
      for (String word : inputWords){
        /**
         * Sets initial length of formResponse before going through mirror words loop
         */
        int initLength = formResponse.length();
        /**
         * Loops through mirrorWords by each key of the keySet
         */
        for (String key : mirrorWords.keySet()){
          /**
           * Checks if current word is a mirror word that needs to be replaced
           * T/F: if current word is equal to the current mirrorWords key
           */
          if (word.equals(key)){
            /**
             * Adds corresponding replacement mirror word to formResponse followed by a space
             */
            formResponse.append(mirrorWords.get(key) + " ");
          }
        }
        /**
         * Checks if anything was added to formResponse
         * T/F: if current length of formResponse is equal to the length before mirror word loop
         */
        if (formResponse.length() == initLength){
          /**
           * Adds current word(not modified) to formResponse followed by a space
           */
          formResponse.append(word + " ");
        }
      }

      /**
       * Removes excess space at the end of formResponse
       */
      formResponse = formResponse.delete(formResponse.length()-1, formResponse.length());

      /**
       * Converts StringBuffer to String to be stored in String variable response
       */
      String response = formResponse.toString();
      
      /**
       * Checks if there was any mirror words detected and replaced
       * T/F: if contructed response is equal to the initial inputLine user entered
       */
      if (response.equals(inputLine)){
        /**
         * Sets response to one randomly selected from the canned responses
         */
        response = randRes[rand.nextInt(randRes.length)];
      } 
      /**
       * If there was any mirror words replaced, and if the response ends with a period
       */
      else if (response.endsWith(".")){
        /**
         * Replaces the period at the end with a question mark
         */
        response = response.substring(0, response.length()-1) + "?";
      }

      /** Prints response and add it to the transcript
       */
      System.out.println(response);
      transcript.add(response);
    }
    /** 
     * Prints ender string and an empty line then adds them to the transcript
     */
    System.out.println(ender + "\n");
    transcript.add(ender);

    /** 
     * Prints the entire transcript
     */
    System.out.println("TRANSCRIPT:");
    for(String line : transcript){
      System.out.println("\t" + line);
    }
    /**
     * Closes scanner
     */
    input.close();
  }
}
