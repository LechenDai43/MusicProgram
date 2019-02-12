/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

import java.util.ArrayList;

/**
 *
 * @author LeLe
 */
public class SS_PlateCreator {
    protected SS_NewPlate x;
    protected int length;
    protected ArrayList<SS_Plate> array;
    protected SS_PlateAnalyser analyze = new SS_PlateAnalyser();
    
    public SS_PlateCreator(ArrayList<SS_Plate> c){
        char b = c.get(0).type;
        int a = c.get(0).number;
        x = new SS_NewPlate(b,a);
        array = c;
        length = analyze.getMaxNumber(array);
    }
    
    public void createOneGroup(int a){
        SS_GroupSelector gs = new SS_GroupSelector();
        ArrayList<SS_Group> tem_groups = gs.select(array, a);
        if(tem_groups.size() == 0){
            return;
        }
        SS_GroupAnalyser ga = new SS_GroupAnalyser(tem_groups);
        SS_Group a_group = new SS_Group();
        SS_AlternativeCreator ac = new SS_AlternativeCreator();
        boolean non_good = true;
        while(non_good){            
            SS_GroupCreator gc = new SS_GroupCreator(a);
            gc.setLength(ga.getLengthOfGroup());
            gc.setFirstNote(ga.getFirstNoteBeat(), ga.getFirstNoteLength());
            gc.setSecondNote(ga.getSecondNoteBeat(), ga.getSecondNoteLength());
            boolean non_finish = true;
            System.out.print("running ");
            while(non_finish){
                non_finish = gc.addNote(ga.getNoteBeat(), ga.getNoteLength());                
            }
            gc.setLastNote(ga.getSecondNoteBeat(), ga.getSecondNoteLength());
            System.out.print("running5 ");
            a_group = gc.creat();
            if(x.array.size() == 0){          
                System.out.print("one");
                non_good = false;
                break;
            }
            System.out.print("two");
            ArrayList<SS_TitleStaticPair> xx = analyze.getInterGroupInfo(array);
            for(int i = 0; i < a && i < x.array.size(); i ++){
                double diff = Math.abs(x.array.get(i).get(0).getAverage() - a_group.getAverage());
                for(SS_TitleStaticPair xyz : xx){
                    if(xyz.a == i && xyz.b == a){
                        if(diff > xyz.core.average - xyz.core.deviation / 2 && diff < xyz.core.average + xyz.core.deviation / 2){
                            non_good = false;
                        }
                        break;
                    }
                }
            }
        }
        x.array.add(ac.creat(a_group, analyze.getAlternativaInfo(array)));
    } 
    
    public void createAllGroup(){
        for(int i = 1; i <= length; i ++){
            System.out.print(i + " ");
            createOneGroup(i);
            System.out.println(i);
        }
    }
    
    public SS_NewPlate create(){
        createAllGroup();
        return x;
    }
    
}
