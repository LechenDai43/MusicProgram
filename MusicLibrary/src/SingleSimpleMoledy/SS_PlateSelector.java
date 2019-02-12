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
public class SS_PlateSelector {
    
    public SS_PlateSelector(){
        
    }
    
    public ArrayList<SS_Plate> select(ArrayList<SS_Song> a, char b){
        ArrayList<SS_Plate> result = new ArrayList<SS_Plate>();
        for(SS_Song x : a){
            for(SS_Plate y : x.array){
                if(y.type == b){
                    result.add(y);
                }
            }
        }
        return result;
    }
    
    public ArrayList<SS_Plate> select(ArrayList<SS_Song> a, int b){
        ArrayList<SS_Plate> result = new ArrayList<SS_Plate>();
        for(SS_Song x : a){
            for(SS_Plate y : x.array){
                if(y.number == b){
                    result.add(y);
                }
            }
        }
        return result;
    }
    
    public ArrayList<SS_Plate> select(ArrayList<SS_Song> a, char b, int c){
        ArrayList<SS_Plate> result = new ArrayList<SS_Plate>();
        for(SS_Song x : a){
            for(SS_Plate y : x.array){
                if(y.type == b && y.number == c){
                    result.add(y);
                }
            }
        }
        return result;
    }
    
}
