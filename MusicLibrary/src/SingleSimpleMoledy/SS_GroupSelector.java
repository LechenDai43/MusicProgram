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
public class SS_GroupSelector {
    
    public SS_GroupSelector(){
        
    }
    
    public ArrayList<SS_Group> select(ArrayList<SS_Plate> a, int b){
        ArrayList<SS_Group> result = new ArrayList<SS_Group>();
        for(SS_Plate x : a){
            for(SS_Group y : x.array){
                if(y.number == b){
                    boolean non_exist = true;
                    for(SS_Group z : result){
                        if(z == y){
                            non_exist = false;
                        }
                    }
                    if(non_exist){
                        result.add(y);
                    }
                }
            }
            for(SS_Group y : x.alternative){
                if(y.number == b){
                    boolean non_exist = true;
                    for(SS_Group z : result){
                        if(z == y){
                            non_exist = false;
                        }
                    }
                    if(non_exist){
                        result.add(y);
                    }
                }
            }
        }
        return result;
    }
    
}
