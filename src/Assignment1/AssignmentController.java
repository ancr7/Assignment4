package Assignment1;

import java.util.Scanner;

public class AssignmentController {

  public static void main(String args[]) {
    System.out.println("Enter Input in given format:");
    System.out.println("-name {name} ");

    // 1. read data from the console
    Scanner input = new Scanner(System.in);
    String inputString = input.nextLine();
    inputString = inputString.trim();

    // 2. call service method to process the input (service.processInput();)
//    ItemModel model = new ItemModel();
    AssignmentService service = new AssignmentService();
    double total = service.processInput(inputString);

    // 3. print output in the console return from service method
    if (total >= 0) System.out.println(total);

  }
}
