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
public class SS_AlternativeCreator {
    
    public SS_AlternativeCreator(){
        
    }
    
    public ArrayList<SS_Group> creat(SS_Group a, ArrayList<SS_StaticPair> b){
        ArrayList<SS_Group> result = new ArrayList<SS_Group>();
        result.add(a);
        SS_Scale sc = new SS_Scale();
        for(int i = 0; i < 8; i ++){
            SS_Group tem = new SS_Group();
            tem.number = a.number;
            int j = 0;
            for(; j < b.size(); j ++){
                if(j < a.array.size()){
                    int x = a.array.get(a.array.size() - j - 1).beat;
                    int y = (int)(Math.random() * b.get(j).deviation / 3 + b.get(j).average - (b.get(j).deviation / 1.5));
                    x -= y;
                    SS_Note anote = new SS_Note(sc.getName(x),a.array.get(a.array.size() - j - 1).longness);
                    tem.array.add(anote);
                }
            }
            for(; j < a.array.size(); j ++){
                SS_Note anote = new SS_Note(a.array.get(a.array.size() - j - 1).name,a.array.get(a.array.size() - j - 1).longness);
                tem.array.add(anote);
            }
            result.add(tem);
        }
        return result;
    }
    
    
}
