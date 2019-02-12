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
public class SS_Plate {
    protected char type;
    protected int number, count = 1;
    protected ArrayList<SS_Group> array = new ArrayList<SS_Group>(), alternative = new ArrayList<SS_Group>();
    
    public SS_Plate(char a){
        type = a;
        number = 0;
    }
    
    public SS_Plate(char a, int b){
        type = a;
        number = b;
    }
    
    public void setUp(ArrayList<ArrayList<SS_Group>> a){
        if(type > 108){
            array = a.get(0);
            return;
        }
        ArrayList<SS_Group> template = new ArrayList<SS_Group>();
        for(SS_Group x : a.get(0)){
            boolean non_exist = true;
            for(SS_Group y : template){
                if(x == y){
                    non_exist = false;
                    break;
                }
            }
            if(non_exist){
                template.add(x);
            }
        }
        array = a.get(0);
        count = template.size();
        for(int i = 0; i < array.size(); i ++){
            for(int j = 0; j < template.size(); j ++){
                if(array.get(i) == template.get(j)){
                    array.get(i).number = j + 1;
                    break;
                }
            }
        }
        for(int i = 1; i < a.size(); i ++){
            SS_Group tem = a.get(i).get(a.get(i).size() - 1);
            tem.number = array.get(array.size() - 1).number;
            alternative.add(tem);
        }
        alternative.add(array.remove(array.size() - 1));
    }
    
    
    
}
