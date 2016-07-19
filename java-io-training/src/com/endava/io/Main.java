package com.endava.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * Created by bsoimu on 7/19/2016.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = "D:/workspace/TrainingGrads/java-io-training/files/CharCounter.txt";
        String fileNameReverse = "D:/workspace/TrainingGrads/java-io-training/files/Reverse.txt";

        characterCounter(fileName);

        String reverse;
        reverseWriter(fileNameReverse);

        File files = new File("D:\\IO Tree Files\\FolderParent");
        showFiles(files);
    }

    public static void characterCounter(String fileName) {
        RandomAccessFile randomAccessFile = null;
        int counter = 0;
        try {
            randomAccessFile = new RandomAccessFile(fileName, "r");
            randomAccessFile.seek(10L);
            int data;
            while ((data = randomAccessFile.read()) != -1) {
                char dataChar = (char) data;
                if (dataChar == 'a')
                    counter++;
            }
            System.out.println("The character appears " + counter + " times.");
        } catch (FileNotFoundException ex) {
            System.out.println("File missing '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("I/O Exception:" + ex.getMessage());
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException ex) {
                System.out.println("I/O Exception:" + ex.getMessage());
            }
        }
    }


    public static void reverseWriter(String fileName) {
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            Reader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String data;

            List<String> lines = new ArrayList<String>();

            while ((data = bufferedReader.readLine()) != null) {
                lines.add(data);
            }

            for (int i = lines.size() - 1; i >= 0; i--) {
                line = lines.get(i);

                String[] splitter = line.split(" ");

                try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                    for (int j = splitter.length - 1; j >= 0; j--) {
                        fileWriter.write(splitter[j]);
                        fileWriter.write(" ");
                    }

                    fileWriter.append(lineSeparator());
                } catch (FileNotFoundException e) {
                    System.out.println("The first file is missing: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("I/O exception at the first file: " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("The second file is missing: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O exception at the second file: " + e.getMessage());
        } finally {
            System.out.println("Everything is closed!");
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.out.println("I/O exception at the second file: " + ex.getMessage());
            }
        }
    }


    public static void showFiles(File file) {
        String fileName = "D:/workspace/TrainingGrads/java-io-training/files/Tree.txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {

            if (file.isDirectory()) {
                fileWriter.write(file.getName());
                fileWriter.append(lineSeparator());
                if(file.listFiles() != null)
                for (File fileObj : file.listFiles()) {
                    System.out.println(fileObj);
                    showFiles(fileObj);
                }
            } else {
                fileWriter.write(file.getName());
                fileWriter.append(lineSeparator());
            }
            fileWriter.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File missing '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("I/O Exception:" + ex.getMessage());
        }



    }

}