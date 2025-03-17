import java.util.Scanner;
import java.util.Random;

class Questions {
    private boolean fiftyFiftyUsed = false;
    private boolean callFriendUsed = false;
    private boolean skipUsed = false;
    private Scanner sc = new Scanner(System.in);
    
    void question() {
        for (int i = 1; i <= 10; i++) {
            switch (i) {
                case 1:
                    askQuestion("Who was the first President of India?",
                                new String[]{"Sardar Vallabhbhai Patel", "Dr. Rajendra Prasad", "Dr. B. R. Ambedkar", "Jawaharlal Nehru"},
                                2, 1000);
                    break;
                case 2:
                    askQuestion("What does 'HTTP' stand for in website addresses?",
                                new String[]{"HyperText Transmission Protocol", "HyperText Transfer Protocol", "Hyper Terminal Transfer Protocol", "High-Tech Transfer Protocol"},
                                2, 2000);
                    break;
                case 3:
                    askQuestion("What is the capital of Japan?",
                                new String[]{"Beijing", "Seoul", "Tokyo", "Bangkok"},
                                3, 5000);
                    break;
                case 4:
                    askQuestion("Who wrote 'Hamlet'?",
                                new String[]{"Charles Dickens", "J.K. Rowling", "William Shakespeare", "Mark Twain"},
                                3, 10000);
                    break;
                case 5:
                    askQuestion("Which is the smallest planet in our solar system?",
                                new String[]{"Mercury", "Venus", "Mars", "Neptune"},
                                1, 20000);
                    break;
                case 6:
                    askQuestion("Who invented the telephone?",
                                new String[]{"Alexander Graham Bell", "Nikola Tesla", "Thomas Edison", "Albert Einstein"},
                                1, 50000);
                    break;
                case 7:
                    askQuestion("What is the chemical symbol for Gold?",
                                new String[]{"Au", "Ag", "Pb", "Fe"},
                                1, 100000);
                    break;
                case 8:
                    askQuestion("What is the square root of 144?",
                                new String[]{"10", "11", "12", "14"},
                                3, 1000000);
                    break;
                case 9:
                    askQuestion("What is the hardest natural substance on Earth?",
                                new String[]{"Gold", "Iron", "Diamond", "Platinum"},
                                3, 5000000);
                    break;
                case 10:
                    askQuestion("Who discovered Penicillin?",
                                new String[]{"Alexander Fleming", "Louis Pasteur", "Marie Curie", "Joseph Lister"},
                                1, 10000000);
                    break;
            }
        }
    }

    void askQuestion(String question, String[] options, int correctAnswer, int prize) {
        System.out.println("\n" + question);
        displayOptions(options);
        System.out.println("Do you want to use a lifeline? (yes/no)");
        String useLifeline = sc.next();
        if (useLifeline.equalsIgnoreCase("yes")) {
            if (!useLifeline(options, correctAnswer)) {
                return; // Skip if the lifeline was used and the question was skipped.
            }
        }
        System.out.print("Enter your answer (1-4): ");
        int answer = sc.nextInt();
        if (answer == correctAnswer) {
            System.out.println("Correct! You won Rs." + prize);
        } else {
            endGame();
        }
    }

    void displayOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean useLifeline(String[] options, int correctAnswer) {
        System.out.println("Choose a lifeline:\n1. 50:50\n2. Call a Friend\n3. Skip");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                if (!fiftyFiftyUsed) {
                    fiftyFifty(options, correctAnswer);
                    fiftyFiftyUsed = true;
                } else {
                    System.out.println("50:50 already used!");
                }
                break;
            case 2:
                if (!callFriendUsed) {
                    callFriend(correctAnswer);
                    callFriendUsed = true;
                } else {
                    System.out.println("Call a Friend already used!");
                }
                break;
            case 3:
                if (!skipUsed) {
                    System.out.println("Skipping to next question!");
                    skipUsed = true;
                    return false; // Indicate skipping the question.
                } else {
                    System.out.println("Skip already used!");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
        return true; // Continue with the question.
    }

    void fiftyFifty(String[] options, int correctAnswer) {
        System.out.println("Applying 50:50 lifeline...");
        int removed = 0;
        for (int i = 0; i < options.length; i++) {
            if ((i + 1) != correctAnswer && removed < 2) {
                options[i] = "--Removed--";
                removed++;
            }
        }
        displayOptions(options);
    }

    void callFriend(int correctAnswer) {
        System.out.println("Calling a friend...");
        Random rand = new Random();
        if (rand.nextBoolean()) {
            System.out.println("Friend suggests: Option " + correctAnswer);
        } else {
            System.out.println("Friend is unsure, but suggests: Option " + ((correctAnswer % 4) + 1));
        }
    }

    void endGame() {
        System.out.println("Wrong answer! Game Over.");
        System.exit(0);
    }
}

public class Crorepathi{
    public static void main(String[] args) {
        System.out.println(" NAMASTEEE! MAI AAAPKA AMITHAB BACCHHAN . WELCOME TO KAUN BANEGA KARODPATHI ");
        System.out.println("------------------------------------------");
        System.out.println("Let me tell you the rules first:");
        System.out.println("------------------------------------------");
        System.out.println(
                "1. 10 questions with increasing rewards\n" +
                "2. Proceed only if the answer is correct\n" +
                "3. Game ends on the wrong answer\n" +
                "4. 3 lifelines (each can be used only once)\n" +
                "5. Lifeline option before answering\n" +
                "6. 50-50 removes two wrong options\n" +
                "7. Audience Poll suggests an answer\n" +
                "8. Skip moves to the next question");
        System.out.println("------------------------------------------");
        System.out.println("Let's start with the first question!");
        System.out.println("------------------------------------------");
        Questions q = new Questions();
        q.question();
    }
}

