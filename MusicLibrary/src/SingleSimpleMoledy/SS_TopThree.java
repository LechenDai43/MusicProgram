/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LeLe
 */
public class SS_TopThree {
    protected double first = 0, second = -1, third = -1;
    
    public SS_TopThree(ArrayList<Integer> a){
        ArrayList<SS_PrimaryData> tem = new ArrayList<SS_PrimaryData>();
        for(Integer x : a){
            boolean non_exist = true;
            for(int i = 0; i < tem.size(); i ++){
                Integer inter = (Integer)tem.get(i).x;
                if(inter == x){
                    tem.get(i).count ++;
                    non_exist = false;
                }
            }
            if(non_exist){
                SS_PrimaryData inter = new SS_PrimaryData(x);
                tem.add(inter);
            }
            
        }      
        Collections.sort(tem); 
        if(tem.size() > 0){            
            first = (int)(tem.get(0).x);
        }
        if(tem.size() > 1){
            second = (int)(tem.get(1).x);
        }
        if(tem.size() > 2){
            third = (int)(tem.get(2).x);
        }   
    }
    
    public SS_TopThree(List<Double> a){
        ArrayList<SS_PrimaryData> tem = new ArrayList<SS_PrimaryData>();
        for(Double x : a){
            boolean non_exist = true;
            for(int i = 0; i < tem.size(); i ++){
                Double inter = (Double)tem.get(i).x;
                if(inter == x){
                    tem.get(i).count ++;
                    non_exist = false;
                }
            }
            if(non_exist){
                SS_PrimaryData inter = new SS_PrimaryData(x);
                tem.add(inter);
            }
            
        }
        Collections.sort(tem);
        first = (Double)(tem.get(0).x);
        if(tem.size() > 1){
            second = (Double)(tem.get(1).x);
        }
        if(tem.size() > 2){
            third = (Double)(tem.get(2).x);
        }
    }
}
