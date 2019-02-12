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
public class SS_NewPlate {
    protected char type;
    protected int number;
    protected ArrayList<ArrayList<SS_Group>> array = new ArrayList<ArrayList<SS_Group>>();//竖着排版，竖着排版
                                                                                          //每一行都是统一group的alternative
    
    public SS_NewPlate(char a, int b){
        type = a;
        number = b;
    }
    
    public String toString(){
        return type + " " + number;
    }
}
