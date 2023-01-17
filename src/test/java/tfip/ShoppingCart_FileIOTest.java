package tfip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class ShoppingCart_FileIOTest {
    String dirPath = "C:/Users/yehji/Documents/TFIP-NUS/day05/src/main/java/tfip/shoppingcart";
    String stringLogin = "test.txt";
    String filePathName = dirPath + File.separator + stringLogin;
    File file = new File(filePathName);
    public void createDir(File file){
        if (file.exists()){
            System.out.println("Directory already exists");
        } else {
            file.mkdir();
        }
    }

    @Test
    public void appendDataUsingBufferedWriter() throws IOException{
        String str = "The quick brown fox jump over the wall.";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePathName,true));
        bw.write("\n");
        bw.write(str);
        bw.flush();
        bw.close(); 
    }
    @Test
    public void deleteWriteTextFile() {
        File file = new File(filePathName);
        if (file.exists()){
            Boolean isDeleted = file.delete();
        }
    }
}

