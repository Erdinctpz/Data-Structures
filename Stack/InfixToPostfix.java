import java.util.Stack;

public class InfixToPostfix {

    public static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String s){
        Stack<Character> myStack = new Stack<>();
        String postfix = "";

        for(int i = 0; i < s.length(); i++){
            if(priority(s.charAt(i)) > 0){  // character -> +,-,*,/,^
                while(!myStack.isEmpty() && priority(s.charAt(i)) <= priority(myStack.peek())){
                postfix = postfix + myStack.pop();
                }
                myStack.push(s.charAt(i));
            }
            else{
                // add to postfix if character is number
                postfix += s.charAt(i);
            }

        }
        if(myStack.size() > 0){
            for(int k = 0; k < myStack.size(); k++){
                postfix = postfix + myStack.pop();
            }
        }
        return postfix;
    } 

    public static void main(String[] args) {
        String infix="12 + 5 * 3  - 20";

        System.out.println(infixToPostfix(infix));

    }
}
