package Package2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // Filereader = read the contents of a file as a stream of characters, onr by onr
        //              read() returns an int value witch contains the byte value
        //              When read() returns -1, there is no more data to be read.

        try {       // its important to place the txt file into the right directory/folder.
            FileReader reader = new FileReader("tekst.txt");  // declare the filereader and into the
            // parentheses put the name of the file where
            //  youre gonna write
            int data = reader.read();
            while(data != -1) {
                System.out.print((char)data);
                data = reader.read();


            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}