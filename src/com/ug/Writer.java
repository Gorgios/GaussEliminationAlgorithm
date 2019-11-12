package com.ug;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public static void saveToFile(List<List<String>> rows, String fileName) throws IOException {
        FileWriter writer=new FileWriter(fileName);
        for(List<String> rowData: rows){
            writer.append(String.join(",",rowData));
            writer.append("\n");
        }
        writer.flush();
        writer.close();
    }
}
