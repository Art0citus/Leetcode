class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Check if the current token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // The first popped element is the second operand (right side)
                int num2 = stack.pop();
                // The second popped element is the first operand (left side)
                int num1 = stack.pop();

                // Apply the respective operator and push the result back
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2); // Integer division truncates toward zero
                        break;
                }
            } else {
                // If it's a number, convert the string to integer and push it
                stack.push(Integer.parseInt(token));
            }
        }

        // The final remaining element in the stack is the total evaluation result
        return stack.pop();
    }
}