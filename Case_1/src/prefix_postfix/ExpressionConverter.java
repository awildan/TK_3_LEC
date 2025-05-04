package prefix_postfix;

public class ExpressionConverter {

  private static boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
  }

  private static int precedence(String op) {
    if (op.equals("+") || op.equals("-")) return 1;
    if (op.equals("*") || op.equals("/")) return 2;
    return 0;
  }

  public static boolean isValidInfix(String expr) {
    String[] tokens = expr.trim().split("\\s+");
    boolean expectOperand = true;
    for (String token : tokens) {
      if (expectOperand) {
        if (!token.matches("\\d+")) return false;
      } else {
        if (!isOperator(token)) return false;
      }
      expectOperand = !expectOperand;
    }
    return !expectOperand; // ekspresi harus diakhiri dengan operand
  }

  public static String toPostfix(String infix) {
    StackLinkedList operatorStack = new StackLinkedList();
    StringBuilder postfix = new StringBuilder();
    String[] tokens = infix.trim().split("\\s+");

    for (String token : tokens) {
      if (token.matches("\\d+")) {
        postfix.append(token);
      } else if (isOperator(token)) {
        while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
          postfix.append(operatorStack.pop());
        }
        operatorStack.push(token);
      }
    }

    while (!operatorStack.isEmpty()) {
      postfix.append(operatorStack.pop());
    }

    return postfix.toString();
  }

  public static String toPrefix(String infix) {
    StackLinkedList operatorStack = new StackLinkedList();
    StackLinkedList operandStack = new StackLinkedList();
    String[] tokens = infix.trim().split("\\s+");

    for (String token : tokens) {
      if (token.matches("\\d+")) {
        operandStack.push(token);
      } else if (isOperator(token)) {
        while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
          String op = operatorStack.pop();
          String b = operandStack.pop();
          String a = operandStack.pop();
          operandStack.push(op + a + b);
        }
        operatorStack.push(token);
      }
    }

    while (!operatorStack.isEmpty()) {
      String op = operatorStack.pop();
      String b = operandStack.pop();
      String a = operandStack.pop();
      operandStack.push(op + a + b);
    }

    return operandStack.pop();
  }

  public static int evaluatePostfix(String postfix) {
    StackLinkedList stack = new StackLinkedList();
    for (char ch : postfix.toCharArray()) {
      if (Character.isDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else {
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        int result = switch (ch) {
          case '+' -> a + b;
          case '-' -> a - b;
          case '*' -> a * b;
          case '/' -> a / b;
          default -> throw new IllegalArgumentException("Operator tidak valid");
        };
        stack.push(String.valueOf(result));
      }
    }
    return Integer.parseInt(stack.pop());
  }

  public static int evaluatePrefix(String prefix) {
    StackLinkedList stack = new StackLinkedList();
    for (int i = prefix.length() - 1; i >= 0; i--) {
      char ch = prefix.charAt(i);
      if (Character.isDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else {
        int a = Integer.parseInt(stack.pop());
        int b = Integer.parseInt(stack.pop());
        int result = switch (ch) {
          case '+' -> a + b;
          case '-' -> a - b;
          case '*' -> a * b;
          case '/' -> a / b;
          default -> throw new IllegalArgumentException("Operator tidak valid");
        };
        stack.push(String.valueOf(result));
      }
    }
    return Integer.parseInt(stack.pop());
  }
}
