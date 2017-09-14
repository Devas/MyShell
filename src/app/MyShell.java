package app;

import app.commands.Cd;
import app.commands.Dir;
import app.commands.Help;
import app.commands.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class MyShell {

    // TODO move to commands clssess
    private final String CD = "cd";
    private final String DIR = "dir";
    private final String PROMPT = "prompt";
    private final String TREE = "tree";
    private final String EXIT = "exit";
    private final String UNKNOWN_COMMAND = " : unknown command";

    private final Scanner scanner = new Scanner(System.in);
    private final Cd cd = new Cd();
    private final Dir dir = new Dir();
    private final Help help = new Help();
    private final Tree tree = new Tree();

    private String input = new String();
    private List<String> commands;
    private String promptParam = Utils.DOLLAR;
    private String returnValue;

    void run() {
        while (!input.equals(EXIT)) {
            Utils.print(Utils.MYSHELL + Utils.SPACE + promptParam + Utils.GREATER);
            input = scanner.nextLine();
            if (input.equals(Utils.EMPTY)) continue;
            commands = Arrays.asList(input.split(Utils.SPACE));
            int size = commands.size();
            // TODO make hashmap
            switch (commands.get(0)) {
                case CD:
                    returnValue = cd.execute();
                    break;
                case DIR:
                    returnValue = dir.execute();
                    break;
                case PROMPT:
                    returnValue = (size == 1) ? help.execute() : prompt();
                    break;
                case TREE:
                    returnValue = tree.execute();
                    break;
                default:
                    Utils.println(commands.get(0) + UNKNOWN_COMMAND);
            }
        }
    }

    // TODO extract to class
    private String prompt() {
        String param = commands.get(1);
        switch (param) {
            case "reset":
                promptParam = Utils.DOLLAR;
                break;
            case "$cwd":
                promptParam = Utils.getCurrentWorkingDirectory();
                break;
            default:
                promptParam = param;
        }
        return Utils.EMPTY;
    }
}
