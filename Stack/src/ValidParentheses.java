import java.util.Stack;


public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<String>leftOp = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i,i + 1);
            if (c == "(" || c == "{" || c == "[") {
                leftOp.push(c);
            } else {
                if (leftOp.empty()) {
                    return false;
                } else {
                    String lft = leftOp.peek();
                    if ((lft == "(" && c == ")"|| (lft == "{" && c ==  "}") || (lft == "[" && c == "]"))) {
                        leftOp.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (leftOp.empty()){
            return true;
        } else {
            return false;
        }    
    }
}
