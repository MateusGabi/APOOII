
import util.*;

public class PostfixTest {

    /**
     * Recebe uma string pós fixa e retorna um float resultante da equação
     *
     * @param e
     * @return
     */
    public static float eval(String e) {
        util.Stack<Float> s = new ArrayStack<>();

        for (int n = e.length(), i = 0; i < n; i++) {
            char c = e.charAt(i);
            float a1, a2;

            switch (c) {
                case '+':
                    a2 = s.pop();
                    a1 = s.pop();
                    s.push(a1 + a2);
                    break;
                case '-':
                    a2 = s.pop();
                    a1 = s.pop();
                    s.push(a1 - a2);
                    break;
                case '*':
                    a2 = s.pop();
                    a1 = s.pop();
                    s.push(a1 * a2);
                    break;
                case '/':
                    a2 = s.pop();
                    a1 = s.pop();
                    s.push(a1 / a2);
                    break;
                default:
                    s.push((float) (c - '0'));
            }
        }
        return s.pop();
    }

    public static String translator(String e) {

        util.Stack<String> stack = new ArrayStack<>();

        String retorno = "";

        for (int i = 0; i < e.length(); i++) {

            String c = "" + e.charAt(i) + "";

            switch (c) {
                case "(":
                    stack.push(c);
                    break;
                case "+":
                case "-":
                    if (!stack.empty()) {
                        if (stack.peek().equals("*") || stack.peek().equals("/")) {
                            while (!stack.empty()) {
                                if (stack.peek().equals("(")) {
                                    break;
                                }
                                retorno += stack.pop();
                            }
                        }
                    }
                    stack.push(c);
                    break;
                case "*":
                case "/":
                    stack.push(c);
                    break;
                case ")":
                    while (!stack.peek().equals("(")) {
                        retorno += stack.pop();
                    }
                    stack.pop();
                    break;
                default:
                    retorno += c;
            }
        }

        while (!stack.empty()) {
            if (stack.peek().equals("(")) {
                break;
            }
            retorno += stack.pop();
        }

        return retorno;
    }

    public static void main(String[] args) {
        String a = "1+3*5-4/2";
        String b = "5+7*3";
        String c = "(5+7)*3";
        
        System.err.println(translator(a) +" = "+eval(translator(a))); 
        System.err.println(translator(b) +" = "+eval(translator(b))); 
        System.err.println(translator(c) +" = "+eval(translator(c)));

        System.out.println(translator("(a*b+(c+d))*(e+f)"));
        System.out.println(translator("(a*b)+(c*d)"));
        System.out.println(eval("12+34-+56+78--*"));
        System.out.println(eval("53+6*21+/"));
    }

} // PostfixText
