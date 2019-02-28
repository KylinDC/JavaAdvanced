package main.java.kylindc.model.filecopier;

import java.io.*;

public class FileCopier {
    public void copyFiles(String srcFilePath, String targetFilePath) throws IOException {
        File srcFile = new File(srcFilePath);
        File targetFile = new File(targetFilePath);
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }

        String[] childFilePaths = srcFile.list();
        for (String childFilePath : childFilePaths) {
            File childFile = new File(srcFile, childFilePath);
            File targetChildFile = new File(targetFile, childFile.getName());

            if (childFile.isFile()) {
                InputStream inputStream = null;
                OutputStream outputStream = null;
                try {
                    inputStream = new FileInputStream(childFile);
                    outputStream = new FileOutputStream(targetChildFile);
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while ((length = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, length);
                    }
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            } else {
                copyFiles(
                        srcFilePath + File.separator + childFilePath,
                        targetFilePath + File.separator + childFilePath);
            }
        }
    }
}
