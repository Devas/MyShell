package app.commands;

import app.Utils;

import java.io.File;

public class Tree implements Command {

    @Override
    public String execute() {
        listDirs(Utils.getCurrentWorkingDirectory(), 0);
        return Utils.EMPTY;
    }

    private void listDirs(String directoryName, int n) {
        File directory = new File(directoryName);
        for (int i = 0; i < n; i++) Utils.print(Utils.DASH);
        Utils.println(directory.getName());
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                listDirs(file.getAbsolutePath(), n + 1);
            }
        }
    }
}
