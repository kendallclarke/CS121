import java.io.*;
import java.util.Scanner;
import java.io.Serializable;

// Node class represents a node in the binary tree
// It implements the Serializable interface to allow object serialization
class Node implements Serializable {
    String data; // Data stored in the node
    Node left, right; // References to the left and right child nodes

    // Constructor to create a new node with the given data
    public Node(String item) {
        data = item;
        left = right = null; // Initially, the child nodes are set to null
    }
}

public class TwentyQuestionsGame {
    static Scanner scanner = new Scanner(System.in); // Scanner for reading user input

    // ANSI escape codes for purple and reset colors
    private static final String PURPLE = "\u001B[35m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Node root = constructTree(); // Construct the initial binary tree
        while (true) {
            playGame(root); // Play the game
            System.out.print(PURPLE + "Do you want to save the tree state? (yes/no): " + RESET);
            String save = scanner.nextLine().toLowerCase(); // Get user input to save the tree state
            if (save.equals("yes")) {
                System.out.print(PURPLE + "Enter filename to save: " + RESET);
                String filename = scanner.nextLine(); // Get the filename from the user
                saveTree(root, filename); // Save the tree state to the specified file
            }
            System.out.print(PURPLE + "Do you want to play again? (yes/no): " + RESET);
            String playAgain = scanner.nextLine().toLowerCase(); // Get user input to play again
            if (!playAgain.equals("yes")) {
                break; // Exit the loop if the user doesn't want to play again
            }
        }
    }

    // Construct the initial binary tree
    public static Node constructTree() {
        // Create the root node and child nodes
        Node root = new Node("Is it living?");
        root.left = new Node("Is it an object?");
        root.right = new Node("Is it a mammal?");
        root.left.left = new Node("Is it in a house?");
        root.left.right = new Node("Do you use it everyday?");
        root.right.left = new Node("Does it live in water?");
        root.right.right = new Node("Is it a pet?");
        root.left.left.left = new Node("Is it large?");
        root.left.left.right = new Node("Is it soft?");
        root.left.right.left = new Node("Is it a food?");
        root.left.right.right = new Node("Is it something you can wear?");
        root.right.left.left = new Node("Does it have a beak?");
        root.right.left.right = new Node("Does it have four legs?");
        root.right.right.left = new Node("Is it a fish?");
        root.right.right.right = new Node("Is it a bird?");
        root.left.right.left.left = new Node("Is it bread?");
        root.left.right.left.right = new Node("Is it a cat?");
        root.left.right.right.left = new Node("Is it a dog?");
        root.left.right.right.right = new Node("Is it a blanket?");
        root.right.left.left.left = new Node("Is it a book?");
        return root;
    }

    // Play the game
    public static void playGame(Node node) {
        Node current = node;
        while (current.left != null && current.right != null) {
            System.out.print(PURPLE + current.data + " (yes/no): " + RESET);
            String answer = scanner.nextLine().toLowerCase(); // Get user input
            if (answer.equals("yes")) {
                current = current.left; // Move to the left child if the answer is "yes"
            } else {
                current = current.right; // Move to the right child if the answer is "no"
            }
        }
        // Reached a leaf node, ask for the final guess
        System.out.print(PURPLE + "Is it " + current.data + "? (yes/no): " + RESET);
        String guess = scanner.nextLine().toLowerCase();
        if (guess.equals("yes")) {
            System.out.println(PURPLE + "Computer wins!" + RESET); // If the guess is correct, the computer wins
        } else {
            // If the guess is incorrect, prompt the user for a new question and answer
            System.out.print(PURPLE + "What question would help me guess correctly? " + RESET);
            String newQuestion = scanner.nextLine();
            System.out.print(PURPLE + "What's the answer for your object? " + RESET);
            String newAnswer = scanner.nextLine();
            // Update the current node with the new question
            // and create new child nodes for the answer and the original question
            current.data = newQuestion;
            current.left = new Node(newAnswer);
            current.right = new Node(current.data);
            System.out.println(PURPLE + "Thank you for teaching me!" + RESET);
        }
    }

    // Save the binary tree to a file
    public static void saveTree(Node root, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename); // Create a FileOutputStream for the specified file
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); // Create an ObjectOutputStream for object serialization
            objectOut.writeObject(root); // Serialize the root node of the binary tree
            objectOut.close();
            System.out.println(PURPLE + "Tree state saved successfully!" + RESET);
        } catch (IOException e) {
            System.out.println(PURPLE + "Error saving tree state: " + e.getMessage() + RESET); // Print an error message if an IOException occurs
        }
    }
}