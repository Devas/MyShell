package app.commands;

import app.Utils;

public class Help implements Command {

    @Override
    public String execute() {
        Utils.println("Help");
        return Utils.EMPTY;
    }
}
