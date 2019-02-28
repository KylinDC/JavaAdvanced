package test.java.kylindc.model.filecopier;

import main.java.kylindc.model.filecopier.FileCopier;

import java.io.IOException;

public class FileCopierTest {
    public static void main(String[] args) {
        FileCopier fileCopier = new FileCopier();
        try {
            fileCopier.copyFiles(
                    "src/test/java/kylindc/model/filecopier/source",
                    "src/test/java/kylindc/model/filecopier/target");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
