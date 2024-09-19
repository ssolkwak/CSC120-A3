import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.
    System.out.print("How many rounds? ");

    Scanner input = new Scanner(System.in);

    String[] arr = {"Uh-huh...",
                    "How interesting!",
                    "Really?",
                    "Hmm...", 
                    "I see!", 
                    "That's great!"};
    Random rand = new Random();
    ArrayList<String> transcript = new ArrayList<>();
    int rounds = input.nextInt();

    String starter = "Hi there! what's on your mind?";
    String ender = "Thanks for chatting!";
    
    for (int i = 1; i <= rounds; i++){
      if (i == 1){
        System.out.println(starter);
        transcript.add(starter);
        input.nextLine();
      }

      String inputLine = input.nextLine();
      transcript.add(inputLine);
      
      String response;

      if (inputLine.contains("I") || inputLine.contains("me") || inputLine.contains("am") || inputLine.contains("you") || inputLine.contains("my") || inputLine.contains("your")){
        response = inputLine;
      } else {
        response = arr[rand.nextInt(arr.length)];
      }
      

      if (response.contains("I")){
        response = response.replace("I", "you");
      } else if (response.contains("you")){
        response = response.replace("you", "I");
      }
      if (response.contains("me")){
        response = response.replace("me", "you");
      }
      if (response.contains("am")){
        response = response.replace("am", "are");
      }
      if (response.contains("my")){
        response = response.replace("my", "your");
      } else if (response.contains("your")){
        response = response.replace("your", "my");
      }

      System.out.println(response);
      transcript.add(response);
    }
    System.out.println(ender + "\n");
    transcript.add(ender);

    System.out.println("TRANSCRIPT:");
    for(String line : transcript){
      System.out.println("\t" + line);
    }
    input.close();
  }
}
