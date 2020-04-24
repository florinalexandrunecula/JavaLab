package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {

    private static String BASE_PATH;
    private static Reader single_instance = null;

    private Reader(){
        BASE_PATH = "./src/";
    }

    public static Reader getInstance(){
        if (single_instance == null)
            single_instance = new Reader();
        return single_instance;
    }

    public String[][] readContent(String fileName) {
        String line = "";
        String splitBy = ",";
        int size = 0;
        String[][] values =  new String[size][];
        try {
            BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + fileName));
            while ((line = br.readLine()) != null)
            {
                String[] employee = line.split(splitBy);
                size = size + 1;
                String[][] newvalues = new String[size][];
                System.arraycopy(values, 0, newvalues, 0, values.length);
                newvalues[size - 1] = employee;
                values = newvalues;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return values;
    }

    public static void main(String[] args) {
        Reader reader = Reader.getInstance();
        String[][] values = reader.readContent("input.csv");
        System.out.println(values[0][0]);
        System.out.println(Arrays.deepToString(values));
    }
}