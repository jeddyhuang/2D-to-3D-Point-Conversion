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
public class Point {
    private final String name;
    private int vindex;
    private int findex;
    private double weight;
    
    public Point(String name, int vindex, int findex){
        this.name = name;
        this.vindex = vindex;
        this.findex = findex;
    }
    
    public Point(String name, int vindex, int findex, double weight){
        this.name = name;
        this.vindex = vindex;
        this.findex = findex;
        this.weight = weight;
    }
    
    public String getName(){
        return name;
    }
    
    public int getVIndex(){
        return vindex;
    }
    
    public int getFIndex(){
        return findex;
    }
    
    public double getWeight(){
        return weight;
    }
}