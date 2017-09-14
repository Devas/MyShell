package app;

public class Utils {

    public static final String MYSHELL = "[MyShell]";
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String DOLLAR = "$";
    public static final String GREATER = ">";
    public static final String DASH = "-";

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static String getCurrentWorkingDirectory() {
        return System.getProperty("user.dir");
    }
}
