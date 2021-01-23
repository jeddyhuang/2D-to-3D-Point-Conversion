/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author lenovo
 */
public class PosReader {
    private String directory;
    private ArrayList<Character> content;
    private ArrayList<Integer> linebreak;
    private ArrayList<Pos> positions;
    
    public PosReader(String directory) throws FileNotFoundException, Exception{
        this.directory = directory;
        FileReader File = new FileReader(directory);
        content = new ArrayList<Character>();
        int marker;
        while((marker = File.read())!= -1) content.add((char)marker);
        File.close();
        linebreak = new ArrayList<Integer>();
        linebreak.add(0);
        for(int i = 0; i < content.size(); i ++) if(content.get(i).equals('\n') && (i+1) < content.size()) linebreak.add(i+1);
        
        positions = new ArrayList<Pos>();
        
        for(int i = 0; i < linebreak.size(); i ++){
            String line = "";
            if(i != linebreak.size()-1) for(int j = linebreak.get(i); j < linebreak.get(i+1); j ++) line += content.get(j);
            else for(int j = linebreak.get(i); j < content.size(); j ++) line += content.get(j);
            StringTokenizer tokens = new StringTokenizer(line);
            
            positions.add(new Pos(tokens.nextToken(), Double.parseDouble(tokens.nextToken()), Double.parseDouble(tokens.nextToken())));
        }
    }
    
    public ArrayList<Character> compileContent(){
        return content;
    }
    
    public ArrayList<Pos> compilePositions(){
        return positions;
    }
}