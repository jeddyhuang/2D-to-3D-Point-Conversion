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
public class Pos {
    private final String name;
    private final double x;
    private final double y;
    
    public Pos(String name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public String getName(){
        return name;
    }
}