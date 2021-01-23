/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class SelectedWriter {
    private String directory;
    
    public SelectedWriter(String directory, ArrayList<Point> list) throws FileNotFoundException, Exception{
        this.directory = directory;
        PrintWriter writer = new PrintWriter(directory, "UTF-8");
        for(int i = 0; i < list.size(); i ++){
            writer.print(list.get(i).getName());
            writer.print(" ");
            writer.print(list.get(i).getVIndex());
            writer.print(" ");
            writer.println(list.get(i).getFIndex());
        }
        writer.close();
    }
}