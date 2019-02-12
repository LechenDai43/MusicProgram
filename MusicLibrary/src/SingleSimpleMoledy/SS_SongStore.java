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
public class SS_SongStore {
    protected ArrayList<SS_Song> array = new ArrayList<SS_Song>();
    
    public SS_SongStore(ArrayList<SS_Song> a){
        array = a;
    }
    
    public ArrayList<SS_PlateType> getAllType(){
        ArrayList<SS_PlateType> result = new ArrayList<SS_PlateType>();
        for(SS_Song x : array){
            for(SS_Plate y : x.array){
                SS_PlateType tem = new SS_PlateType(y.number, y.type);
                if(result.contains(tem)){
                    
                }else{
                    result.add(tem);
                }
            }
        }
        return result;
    }
    
    public ArrayList<SS_Song> export(){
        return array;
    }
    
    
    
}
