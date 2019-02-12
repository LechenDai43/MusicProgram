/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author LeLe
 */
public class SS_SecondaryData {
    protected Object core;
    protected ArrayList<SS_PrimaryData> arrayfront = new ArrayList<SS_PrimaryData>(), arrayback = new ArrayList<SS_PrimaryData>();
    
    public SS_SecondaryData(Object x){
        core = x;
    }
    
    public void sort(){
        Collections.sort(arrayfront);
        Collections.sort(arrayback);
    }
}
