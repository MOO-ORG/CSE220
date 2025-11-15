public class StackAndQueueAssgnTaskTester {

    // You have to write this method
    // YOU MUST SUBMIT THIS METHOD
    // Hint: You need to traverse each characters of the String
    public static void evalMathExpression(String expression) {
        // You can create Stack and Queue object here to use
        
        // Validate balanced parentheses
        if (!isBalanced(expression)) {
            System.out.println("Invalid Expression");
            return;
        }
        
        // Convert infix to postfix
        String postfix = infixToPostfix(expression);
        
        // Evaluate postfix
        int result = evaluatePostfix(postfix);
        
        System.out.println("Postfix: " + postfix);
        System.out.println("Result: " + result);
    }
    
    private static boolean isBalanced(String expression) {
        Stack stack = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = (char) stack.pop();
                if ((ch == ')' && top != '(') || 
                    (ch == ']' && top != '[') || 
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private static int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }
    
    private static String infixToPostfix(String expression) {
        Stack stack = new Stack();
        StringBuilder postfix = new StringBuilder();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == ' ') {
                continue;
            }
            
            if (Character.isDigit(ch)) {
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    postfix.append(expression.charAt(i));
                    i++;
                }
                i--;
                postfix.append(' ');
            } else if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                char open = (ch == ')') ? '(' : (ch == ']') ? '[' : '{';
                while (!stack.isEmpty() && (char) stack.peek() != open) {
                    postfix.append((char) stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!stack.isEmpty() && 
                       precedence((char) stack.peek()) >= precedence(ch) && 
                       ch != '^') {
                    postfix.append((char) stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append((char) stack.pop()).append(' ');
        }
        
        return postfix.toString().trim();
    }
    
    private static int evaluatePostfix(String postfix) {
        Stack stack = new Stack();
        String[] tokens = postfix.split(" ");
        
        for (String token : tokens) {
            if (token.isEmpty()) continue;
            
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                int result = 0;
                
                switch (token.charAt(0)) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/': result = a / b; break;
                    case '^': result = (int) Math.pow(a, b); break;
                }
                
                stack.push(result);
            }
        }
        
        return (int) stack.pop();
    }

    // DO NOT CHANGE ANYTHING IN THE DRIVER CODE
    public static void main(String[] args) {
        
        System.out.println("================ Test 01 ================");

        System.out.println("This should print:");
        System.out.println("Postfix: 3 5 2 8 - * +\nResult: -27");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("3 + 5 * (2 - 8)");
        System.out.println("=========================================");

        System.out.println("================ Test 02 ================");

        System.out.println("This should print:");
        System.out.println("Invalid Expression");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("(2 + 3)) * ((4 - 1)");
        System.out.println("=========================================");

        System.out.println("================ Test 03 ================");

        System.out.println("This should print:");
        System.out.println("Postfix: 7 6 5 2 ^ * 3 + + 4 2 / -\nResult: 158");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("7 + (6 * 5^2 + 3) - (4 / 2)");
        System.out.println("=========================================");

        System.out.println("================ Test 04 ================");

        System.out.println("This should print:");
        System.out.println("Postfix: 10 2 + 6 * 3 /\nResult: 24");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("(10 + 2) * 6 / 3");
        System.out.println("=========================================");

        System.out.println("================ Test 05 ================");

        System.out.println("This should print:");
        System.out.println("Invalid Expression");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("[2 + 3) * (4 - (5 * 6))]");
        System.out.println("=========================================");

    }
}
