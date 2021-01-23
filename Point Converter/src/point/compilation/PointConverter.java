/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

/**
 *
 * @author rxiao
 */
public class PointConverter {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ArrayList<String> person = new ArrayList<String>();
        JFileChooser selectedobj = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        selectedobj.setDialogTitle("Select a .obj File:");
        selectedobj.setAcceptAllFileFilterUsed(false);
        selectedobj.addChoosableFileFilter(new FileNameExtensionFilter(".obj Files", "obj"));
        if(selectedobj.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
        
        ObjReader object = new ObjReader(selectedobj.getSelectedFile().getAbsolutePath());
        MtlReader material = new MtlReader(selectedobj.getSelectedFile().getParent() + "\\" + object.compileLibraries().get(0));
        
        ArrayList<Point> results = new ArrayList<Point>();
        for(int i = 0; i < 3; i ++){
            String jpgname = material.compileMaterials().get(i).getKdFileName();
            String jpgdir = selectedobj.getSelectedFile().getParent() + "\\" + jpgname;
            JpgLoader image = new JpgLoader(jpgdir);
            
            Mtl currmtl = material.findMaterial(jpgname);
            int mtlindex = object.findMtlindex(currmtl.getName());
            ArrayList<Facet> mtlfacets = object.compileFacets().get(mtlindex);
            
            String posdir = jpgdir.substring(0, jpgdir.length() - 4) + ".pos";
            PosReader position = new PosReader(posdir);
            for(int j = 0; j < position.compilePositions().size(); j ++){
                String posname = position.compilePositions().get(j).getName();
                double newx = position.compilePositions().get(j).getX() / image.getImgWidth();
                double newy = 1.0 - position.compilePositions().get(j).getY() / image.getImgHeight();
                Texture currtex = new Texture(newx, newy);
                
                double closest = 0.1;
                int findex = 0;
                int vindex = 0;
                for(int m = 0; m < mtlfacets.size(); m ++){
                    double num = mtlfacets.get(m).closest(currtex, object.compileTextures());
                    if(closest > num){
                        closest = num;
                        findex = m + 1;
                        vindex = mtlfacets.get(m).closestV(currtex, object.compileTextures());
                    }
                }
                if(findex != 0 && vindex != 0) results.add(new Point(posname, vindex, findex));
            }
        }
        
        for(int i = 0; i < results.size(); i ++){
            for(int j = i+1; j < results.size(); j ++){
                if(results.get(i).getName().equals(results.get(j).getName())){
                    if(results.get(i).getWeight() > results.get(j).getWeight()){
                        results.remove(i);
                        i--;
                        j = results.size();
                    } else if(results.get(j).getWeight() >= results.get(i).getWeight()){
                        results.remove(j);
                        j--;
                    }
                }
            }
        }
        
        JFileChooser targetfolder = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        targetfolder.setDialogTitle("Where to Save your File:");
        targetfolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(targetfolder.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            String writerdir = targetfolder.getSelectedFile().getAbsolutePath() + "\\"  + selectedobj.getSelectedFile().getName().substring(0, selectedobj.getSelectedFile().getName().length()-4) + ".txt";
            SelectedWriter writer = new SelectedWriter(writerdir, results);
        }
        
    }
}
