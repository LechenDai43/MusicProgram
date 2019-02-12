/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

/**
 *
 * @author LeLe
 */
public class SS_PrimaryData implements Comparable{
    protected Object x;
    protected int count = 1;
    
    public SS_PrimaryData(Object a){
        x = a;
    }

    @Override
    public int compareTo(Object o) {
        SS_PrimaryData a = (SS_PrimaryData)o;
        return count - a.count;
    }
}
