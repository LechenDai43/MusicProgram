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
public class SS_SongCreator {
    protected SS_NewSong x = new SS_NewSong();
    protected SS_PlateSelector selector = new SS_PlateSelector();
    
    public SS_SongCreator(){
        
    }
    
    public void makeUpSong(ArrayList<SS_Song> a, ArrayList<SS_PlateType> b){
        for(int i = 0; i < b.size(); i ++){            
            SS_PlateCreator pc = new SS_PlateCreator(selector.select(a, b.get(i).type, b.get(i).number));
            System.out.println(i);
            x.array.add(pc.create());
        }
    }
    
    public SS_NewSong export(){
        return x;
    }
    
    
    
}
