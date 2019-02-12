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
public class SS_Group {
    protected ArrayList<SS_Note> array = new ArrayList<SS_Note>();
    protected int number = 0;
    
    public SS_Group(){
        
    }
    
    //返回这个group所占的拍子
    //以其所占多少个1024分音符为基准
    //1024分音符记为8
    public int getLength(){
        int result = 0;
        for(SS_Note x : array){
            result += x.length;
        }
        return result;
    }
    
    //获得这个group的平均音高
    public double getAverage(){
        double result = 0.0;
        int count = 0;
        for(SS_Note x : array){
            if(x.beat == 0){
                continue;
            }
            count ++;
            result += x.beat;
        }
        return result / count;
    }
    
    //将该group转换成字符串
    public String toString(){
        String result = "";
        for(SS_Note x : array){
            result += x.toString() + " ";
        }
        result += "| ";
        return result;
    }
    
    
    
}
