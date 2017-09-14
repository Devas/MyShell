package app.commands;

import app.Utils;

import java.io.File;

import static app.Utils.EMPTY;

public class Dir implements Command {

    @Override
    public String execute() {
        String currentWorkingDirectory = Utils.getCurrentWorkingDirectory();
        Utils.println("Content of " + currentWorkingDirectory);
        File directory = new File(currentWorkingDirectory);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                Utils.println("FILE    " + file.getName());
            } else if (file.isDirectory()) {
                Utils.println("DIR     " + file.getName());
            }
        }
        return EMPTY;
    }
}
