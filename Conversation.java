import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Conversation {

  public static void main(String[] arguments) {
    
    /**
     * Prints to ask how many rounds of conversation the user wants to have
     */
    System.out.print("How many rounds? ");
    
    /**
     * Creates a scanner called input
     */
    Scanner input = new Scanner(System.in);

    /**
     * Creates static string array with "canned" random responses
     */
    String[] arr = {"Uh-huh...",
                    "How interesting!",
                    "Really?",
                    "Hmm...", 
                    "I see!", 
                    "That's great!"};

    /**
     * Creates random object
     */
    Random rand = new Random();

    /** 
     * Creates Arraylist that stores lines for transcript
     */
    ArrayList<String> transcript = new ArrayList<>();

    /** 
     * Reads user input of total rounds wanted
     */
    int rounds = input.nextInt();

    /**
     * Stores conversation starter and ender to string variables
     */
    String starter = "Hi there! what's on your mind?";
    String ender = "Thanks for chatting!";
    
    /**
     * Loop that runs as long as current round is within the total number of rounds
     */
    for (int i = 1; i <= rounds; i++){
      
      /** 
       * Prints starter string before the first round 
       * Adds the starter string to the transcript
       */
      if (i == 1){
        System.out.println(starter);
        transcript.add(starter);
        input.nextLine();
      }

      /** 
       * Reads user input line and store it in transcript
       */
      String inputLine = input.nextLine();
      transcript.add(inputLine);
      
      /**
       * String variable for bot response
       */
      String response;

      /**
       * Check if chatbot should give a response of modified input line or a random response from the ArrayList
       * @return T/F: does the inputLine contains any mirror words to be replaced?
       */
      if (inputLine.contains("I") || inputLine.contains("me") || inputLine.contains("am") || inputLine.contains("you") || inputLine.contains("my") || inputLine.contains("your")){
        response = inputLine;

        /** 
         * Detects and replace each mirror words. 
         */ 
        if (response.contains("I'm")){
          response = response.replace("'m", "_'m_");
        }
        if (response.contains("you're")){
          response = response.replace("'re", "'m");
        }
        if (response.contains("_'m_")){
          response = response.replace("_'m_", "'re");
        }
        if (response.contains("I")){
          response = response.replace("I", "_I_");
        }
        if (response.contains("am")){
          response = response.replace("am", "are");
        }
        if (response.contains("you are")){
          response = response.replace("you are", "I am");
        }
        if (response.contains("you")){
          response = response.replace("you", "I");
        }
        if (response.contains("_I_")){
          response = response.replace("_I_", "you");
        }
        if (response.contains("me")){
          response = response.replace("me", "you");
        }
        if (response.contains("my")){
          response = response.replace("my", "_my_");
        }
        if (response.contains("your")){
          response = response.replace("your", "my");
        } 
        if (response.contains("_my_")){
          response = response.replace("_my_", "my");
        }
        /** 
         * Checks if the string ends with . 
         * if so, replaces . with ? 
         */ 
        if (response.charAt(response.length()-1) == '.'){
          response = response.replace('.','?');
        }
      } else {
        /**
         * If not containing mirror words, set response to random 
         */ 
        response = arr[rand.nextInt(arr.length)];
      }
      
      /** Prints response and add it to the transcript
       */
      System.out.println(response);
      transcript.add(response);
    }
    /** 
     * Prints ender string and add it to the transcript
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
