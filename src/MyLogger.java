import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyLogger {

    static File f;
    static int option = (int) (Math.random() * 2);
    static FileWriter fw;


    public MyLogger(File f) throws IOException {
        MyLogger.f = f;
    }

    public static void initFileWriter() throws IOException {
        fw = new FileWriter(f);
    }

    public static void closeFileWriter() throws IOException {
        fw.close();
    }

    public static File getF() {
        return f;
    }

    public static void setF(File f) {
        MyLogger.f = f;
    }

    public static int getOption() {
        return option;
    }

    public static void setOption(int option) {
        MyLogger.option = option;
    }

    public static void mylog(String s) throws IOException {
        if (option == 0)
            System.out.println(s);
        else {
            fw.write(s + '\n');
        }

    }
}


