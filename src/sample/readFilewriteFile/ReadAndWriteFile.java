package sample.readFilewriteFile;

import sample.Spend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<Spend> readFile() {

        List<Spend> spendList = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream( "G:\\DemoJavaFX\\src\\TuyenFile.csv" );
            ObjectInputStream intput = new ObjectInputStream( fileInputStream );

            spendList = (List<Spend>) intput.readObject();

            intput.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( "Khong tim thay file__________________________" );
        }
        return spendList;
    }

    public static void writeFile(List<Spend> spendList) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream( "G:\\DemoJavaFX\\src\\TuyenFile.csv" );
            ObjectOutputStream output = new ObjectOutputStream( fileOutputStream );

            output.writeObject( spendList );
            output.close();

        } catch (IOException e) {
            System.out.println( "Lưu ra File không thành công" );
        }
    }


}
