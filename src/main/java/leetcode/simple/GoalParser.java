package leetcode.simple;

public class GoalParser {

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
    }

    public static String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
