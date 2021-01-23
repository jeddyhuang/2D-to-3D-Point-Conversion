/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;

/**
 *
 * @author Jerry
 */
public class JpgLoader {
    private String directory;
    private int width;
    private int height;
    
    public JpgLoader(String directory) throws FileNotFoundException, Exception{
        this.directory = directory;
        BufferedImage image = ImageIO.read(new File(directory));
        width = image.getWidth();
        height = image.getHeight();
    }
    
    public int getImgHeight(){
        return height;
    }
    
    public int getImgWidth(){
        return width;
    }
}
