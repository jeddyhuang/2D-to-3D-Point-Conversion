/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Jerry
 */
public class Facet {
    private int index;
    private int[] v1;
    private int[] v2;
    private int[] v3;
    
    public Facet(int index, String vc1, String vc2, String vc3){
        this.index = index;
        StringTokenizer vertex1 = new StringTokenizer(vc1, "/");
        switch(vertex1.countTokens()){
            case 1:{
                v1 = new int[]{Integer.parseInt(vertex1.nextToken())};
                break;
            }
            case 2:{
                v1 = new int[]{Integer.parseInt(vertex1.nextToken()), Integer.parseInt(vertex1.nextToken())};
                break;
            }
            case 3:{
                v1 = new int[]{Integer.parseInt(vertex1.nextToken()), Integer.parseInt(vertex1.nextToken()), Integer.parseInt(vertex1.nextToken())};
                break;
            }
        }
        StringTokenizer vertex2 = new StringTokenizer(vc2, "/");
        switch(vertex2.countTokens()){
            case 1:{
                v2 = new int[]{Integer.parseInt(vertex2.nextToken())};
                break;
            }
            case 2:{
                v2 = new int[]{Integer.parseInt(vertex2.nextToken()), Integer.parseInt(vertex2.nextToken())};
                break;
            }
            case 3:{
                v2 = new int[]{Integer.parseInt(vertex2.nextToken()), Integer.parseInt(vertex2.nextToken()), Integer.parseInt(vertex2.nextToken())};
                break;
            }
        }
        StringTokenizer vertex3 = new StringTokenizer(vc3, "/");
        switch(vertex3.countTokens()){
            case 1:{
                v3 = new int[]{Integer.parseInt(vertex3.nextToken())};
                break;
            }
            case 2:{
                v3 = new int[]{Integer.parseInt(vertex3.nextToken()), Integer.parseInt(vertex3.nextToken())};
                break;
            }
            case 3:{
                v3 = new int[]{Integer.parseInt(vertex3.nextToken()), Integer.parseInt(vertex3.nextToken()), Integer.parseInt(vertex3.nextToken())};
                break;
            }
        }
    }
    
    public double closest(Texture given, ArrayList<Texture> tlist){
        if(v1.length != 3 || v2.length != 3 || v3.length != 3) return -1;
        double v1num = Math.sqrt(Math.pow(tlist.get(v1[1]-1).getX() - given.getX(), 2) + Math.pow(tlist.get(v1[1]-1).getY() - given.getY(), 2));
        double v2num = Math.sqrt(Math.pow(tlist.get(v2[1]-1).getX() - given.getX(), 2) + Math.pow(tlist.get(v2[1]-1).getY() - given.getY(), 2));
        double v3num = Math.sqrt(Math.pow(tlist.get(v3[1]-1).getX() - given.getX(), 2) + Math.pow(tlist.get(v3[1]-1).getY() - given.getY(), 2));
        double total = v1num + v2num + v3num;
        return total;
    }
    
    public int closestV(Texture given, ArrayList<Texture> tlist){
        if(v1.length != 3 || v2.length != 3 || v3.length != 3) return -1;
        double v1num = Math.sqrt(Math.pow(tlist.get(v1[1]-1).getX() - given.getX(), 2) + Math.pow(tlist.get(v1[1]-1).getY() - given.getY(), 2));
        double v2num = Math.sqrt(Math.pow(tlist.get(v2[1]-1).getX() - given.getX(), 2) + Math.pow(tlist.get(v2[1]-1).getY() - given.getY(), 2));
        double v3num = Math.sqrt(Math.pow(tlist.get(v3[1]-1).getX() - given.getX(), 2) + Math.pow(tlist.get(v3[1]-1).getY() - given.getY(), 2));
        if(v1num <= v2num && v1num <= v3num){
            return v1[0];
        } else if(v2num <= v3num && v2num <= v1num){
            return v2[0];
        } else{
            return v3[0];
        }
    }
}