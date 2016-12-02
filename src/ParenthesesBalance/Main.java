package ParenthesesBalance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author jhunior
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            boolean f = true;
            Stack<Character> p = new Stack();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == '(' || ch == '[') {
                    p.push(ch);
                } else if (ch == ')' && !p.empty()) {
                    if (p.pop() != '(') {
                        f = false;
                        break;
                    }
                } else if (ch == ']' && !p.empty()) {
                    if (p.pop() != '[') {
                        f = false;
                        break;
                    }
                } else {
                    f = false;
                    break;
                }
            }
            if (f && p.empty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}