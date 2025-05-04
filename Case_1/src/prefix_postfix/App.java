package prefix_postfix;

import java.util.Scanner;


public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan ekspresi dalam notasi infix (gunakan spasi antara angka dan operator, misal: 5 + 4 / 5): ");
    String input = scanner.nextLine();

    if (!ExpressionConverter.isValidInfix(input)) {
      System.out.println("Notasi infix tidak valid.");
      return;
    }

    String postfix = ExpressionConverter.toPostfix(input);
    String prefix = ExpressionConverter.toPrefix(input);
    int postfixResult = ExpressionConverter.evaluatePostfix(postfix);
    int prefixResult = ExpressionConverter.evaluatePrefix(prefix);

    System.out.println("Postfix : " + postfix);
    System.out.println("Prefix  : " + prefix);
    System.out.println("Hasil dari Postfix : " + postfixResult);
    System.out.println("Hasil dari Prefix  : " + prefixResult);
  }
}
