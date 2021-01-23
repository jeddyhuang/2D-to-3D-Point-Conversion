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
public class Mtl {
    private final String name;
    private String kd;
    
    public Mtl(String name){
        this.name = name;
    }
    
    public void setkd(String kdfilename){
        kd = kdfilename;
    }
    
    public String getName(){
        return name;
    }
    
    public String getKdFileName(){
        return kd;
    }
}