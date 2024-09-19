import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Conversation {

  public static void main(String[] arguments) {
    
    // Ask how many rounds
    System.out.print("How many rounds? ");
    
    // Scanner object
    Scanner input = new Scanner(System.in);

    // Canned random responses in string array
    String[] arr = {"Uh-huh...",
                    "How interesting!",
                    "Really?",
                    "Hmm...", 
                    "I see!", 
                    "That's great!"};

    // Random object
    Random rand = new Random();

    // Arraylist that stores lines for transcript
    ArrayList<String> transcript = new ArrayList<>();

    // User input total rounds
    int rounds = input.nextInt();

    // Conversation starter and ender
    String starter = "Hi there! what's on your mind?";
    String ender = "Thanks for chatting!";
    
    // For current round is within the total number of rounds
    for (int i = 1; i <= rounds; i++){
      
      // Print starter before the first round
      if (i == 1){
        System.out.println(starter);
        transcript.add(starter);
        input.nextLine();
      }

      // Reads user input line and store in transcript
      String inputLine = input.nextLine();
      transcript.add(inputLine);
      
      String response;

      // Check if chatbot should give a response with modified input line or a random response
      if (inputLine.contains("I") || inputLine.contains("me") || inputLine.contains("am") || inputLine.contains("you") || inputLine.contains("my") || inputLine.contains("your")){
        response = inputLine;

        // Detect and replace words. *** Make sure once replaced word doesn't get replaced again
        if (response.contains("I")){
          response = response.replaceAll("I", "_I_");
        }
        if (response.contains("am")){
          response = response.replaceAll("am", "are");
        }
        if (response.contains("you are")){
          response = response.replaceAll("you are", "I am");
        }
        if (response.contains("you")){
          response = response.replaceAll("you", "I");
        }
        if (response.contains("_I_")){
          response = response.replaceAll("_I_", "you");
        }
        if (response.contains("me")){
          response = response.replaceAll("me", "you");
        }
        if (response.contains("my")){
          response = response.replaceAll("my", "_my_");
        }
        if (response.contains("your")){
          response = response.replaceAll("your", "my");
        } 
        if (response.contains("_my_")){
          response = response.replaceAll("_my_", "my");
        }
        if (response.charAt(response.length()-1) == '.'){
          response = response.replace('.','?');
        }
      } else {
        response = arr[rand.nextInt(arr.length)];
      }
      
      // Print response and add to transcript
      System.out.println(response);
      transcript.add(response);
    }
    // Print ender and add to transcript
    System.out.println(ender + "\n");
    transcript.add(ender);

    // Print transcript
    System.out.println("TRANSCRIPT:");
    for(String line : transcript){
      System.out.println("\t" + line);
    }
    // Close scanner
    input.close();
  }
}
