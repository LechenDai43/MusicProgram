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
public class SS_Scale {
    private class SS_Key{
        int hz;
        String name;
        
        protected SS_Key(int a, String b){
            hz = a;
            name = b;
        }
    }
    
    protected ArrayList<SS_Key> array = new ArrayList<SS_Key>();
    
    //建立标尺中键数组
    public SS_Scale(){
        array.add(new SS_Key(10000,"1..."));
        array.add(new SS_Key(10100,"2..."));
        array.add(new SS_Key(10200,"3..."));
        array.add(new SS_Key(10250,"4..."));
        array.add(new SS_Key(10350,"5..."));
        array.add(new SS_Key(10450,"6..."));
        array.add(new SS_Key(10550,"6..."));
        
        array.add(new SS_Key(10600,"1.."));
        array.add(new SS_Key(10700,"2.."));
        array.add(new SS_Key(10800,"3.."));
        array.add(new SS_Key(10850,"4.."));
        array.add(new SS_Key(10950,"5.."));
        array.add(new SS_Key(11050,"6.."));
        array.add(new SS_Key(11150,"6.."));
        
        array.add(new SS_Key(11200,"1."));
        array.add(new SS_Key(11300,"2."));
        array.add(new SS_Key(11400,"3."));
        array.add(new SS_Key(11450,"4."));
        array.add(new SS_Key(11550,"5."));
        array.add(new SS_Key(11650,"6."));
        array.add(new SS_Key(11750,"6."));
        
        array.add(new SS_Key(11800,"1"));
        array.add(new SS_Key(11900,"2"));
        array.add(new SS_Key(12000,"3"));
        array.add(new SS_Key(12050,"4"));
        array.add(new SS_Key(12150,"5"));
        array.add(new SS_Key(12250,"6"));
        array.add(new SS_Key(12350,"6"));
        
        array.add(new SS_Key(12400,".1"));
        array.add(new SS_Key(12500,".2"));
        array.add(new SS_Key(12600,".3"));
        array.add(new SS_Key(12650,".4"));
        array.add(new SS_Key(12750,".5"));
        array.add(new SS_Key(12850,".6"));
        array.add(new SS_Key(12950,".6"));
        
        array.add(new SS_Key(13000,"..1"));
        array.add(new SS_Key(13100,"..2"));
        array.add(new SS_Key(13200,"..3"));
        array.add(new SS_Key(13250,"..4"));
        array.add(new SS_Key(13350,"..5"));
        array.add(new SS_Key(13450,"..6"));
        array.add(new SS_Key(13550,"..6"));
        
        array.add(new SS_Key(13600,"...1"));
        array.add(new SS_Key(13700,"...2"));
        array.add(new SS_Key(13800,"...3"));
        array.add(new SS_Key(13850,"...4"));
        array.add(new SS_Key(13950,"...5"));
        array.add(new SS_Key(14050,"...6"));
        array.add(new SS_Key(14150,"...6"));
        
        array.add(new SS_Key(0,"0"));
    }
    
    //通过数字获得对应字符串
    public String getName(int a){
        
        if(a < 10000){
            return "0";
        }
       a -= 10000;
       int b = a % 600;
       a /= 600;
       int c = b % 50;
       b /= 50;
       if(c > 25){
           b ++;
       }
       if(b == 12){
           a ++;
           b = 0;
       }else{
           if(b < 4){
               b /= 2;
           }else{
               b ++;
               b /= 2;
           }
       }
       while(a+c >= array.size()) {
    	   a--;
       }
       return array.get(a + c).name;
    }
    
    //通过字符串获得数字
    public int getHz(String a){
        int result = 0;
        for(SS_Key x : array){
            if(x.name.equals(a)){
                result = x.hz;
                break;
            }
        }
        return result;
    }
    
    
    
}
