package com.zerobank.utilities.howMany;

import java.io.*;

public class HowManyRunner {
    static String projectPath = System.getProperty("user.dir");
    static public String path = projectPath + "\\howManyRun";

    public HowManyRunner() {
        try {
            int readFromFile = readFromFile(path);
            ++readFromFile;
            String i = "" + readFromFile;
            writeToFile(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    static {
//        HowManyRunner howMany = new HowManyRunner();
//        int readFromFile = 0;
//        try {
//            readFromFile = howMany.readFromFile(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ++readFromFile;
//        String i = "" + readFromFile;
//        try {
//            howMany.writeToFile(i);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private int readFromFile(String path) throws IOException {
        HowManyRunner.path = path;
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String read = br.readLine();
        br.close();
        return Integer.parseInt(read);
    }

    private void writeToFile(String howManyTimesIVisitHomePage) throws IOException {
        FileWriter writer = new FileWriter(path, false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);


        bufferedWriter.write(howManyTimesIVisitHomePage);


        bufferedWriter.close();
    }

//    public static void main(String[] args) throws IOException {
//        HowManyRuned howMany = new HowManyRuned();
//        int readFromFile = howMany.readFromFile(path);
//        ++readFromFile;
//        String i = ""+readFromFile;
//        howMany.writeToFile(i);
//    }
}
