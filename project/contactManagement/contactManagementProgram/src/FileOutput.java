import java.io.*;

public class FileOutput {
    FileInputStream ifile;
    FileOutputStream ofile;
    BufferedWriter writer;

    FileOutput(){
        try {
            ifile = new FileInputStream("Contact.java");
            ofile = new FileOutputStream("contact.txt");
            writer = new BufferedWriter(new FileWriter(ofile.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    void input() {
        byte[] bs = new byte[8];
    }
}