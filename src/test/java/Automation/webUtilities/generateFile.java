package Automation.webUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class generateFile {

    public  void writeToFile(String orderNumber){
        FileWriter writer;

        try{
            writer = new FileWriter("src/main/resources/orderNumberFile.txt", false);
            writer.write(orderNumber);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(){
        String orderNumFromFile = null;

        try{
            File myObj = new File("src/main/resources/orderNumberFile.txt");
            Scanner myReader = new Scanner(myObj);
            orderNumFromFile = myReader.nextLine();
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return orderNumFromFile;
    }
}
