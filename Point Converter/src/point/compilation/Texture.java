/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

/**
 *
 * @author Jerry
 */
public class Texture {
    private int index;
    private final double x;
    private final double y;
    
    public Texture(int index, double x, double y){
        this.index = index;
        this.x = x;
        this.y = y;
    }
    
    public Texture(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public int getindex(){
        return index;
    }
}