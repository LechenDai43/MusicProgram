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
public class SS_Transform {
    public SS_Transform(){
        
    }
    
    //返回一个音符所占1024分音符的数量
    public int getLength(String a){
        System.out.println(a);
        //获取该音符的下划线数
        int multiple = Integer.parseInt(a.substring(0,1)); 
        //确认是否有后缀点或延长符号
        int half = 0, repeat = 0;
        a = a.substring(1);
        if(a.length() > 1){
            a = a.substring(1);
            half = Integer.parseInt(a.substring(0,1));
            a = a.substring(1);
            if(a.length() > 0){
                repeat = Integer.parseInt(a);
            }
        }
        //恢复音符长度
        //通过下划线数恢复音符长度标记的分母部分
        int denominator = 4;
        for(int i = 0; i < multiple; i ++){
            denominator *= 2;
        }
        //一般音符长度标记的分子部分默认为一
        int numerator = 1;
        //若有后缀点，分母乘二，分子变为三
        if(half == 1){
            denominator *= 2;
            numerator = 3;
        }
        //若有延长符号，每个延长符号加一个四分音符
        if(repeat != 0){
            multiple = denominator / 4;
            numerator += (multiple * repeat);
        }
        //将音符长度转译为1024分音符
        multiple = 1024 / denominator;
        numerator *= multiple;
        //返回该音符所占1024分音符的数量
        return numerator;
    }
    
    //通过一个音符所占1024分音符的数量，返回本程序所识别的音长标记
    public String getLongness(int a){
        int last = a / 256;
        int body = a % 256;
        int first = 8;
        while(body > 0 && body % 2 == 0){
            body /= 2;
            first --;
        }
        if(a % 4 == 1){
            if(last > 0){
                return first + ".0" + last;
            }else{
                return first + "";
            }
        }else{
            first --;
            if(last > 0){
                return first + ".1" + last;
            }else{
                return first + ".1";
            }
        }
        
    }
    
    //确认一个数是否符合要求
    public boolean checkCorrection(int a){
        a = a % 256;
        if(a == 0){
            return true;
        }
        if(a % 3 == 0){
            a /= 3;
            while(a > 0 && a % 2 == 0){
                a /= 2;
            }
            if(a != 1){
                return false;
            }else{
                return true;
            }
        }else{
            while(a > 0 && a % 2 == 0){
                a /= 2;
            }
            if(a != 1){
                return false;
            }else{
                return true;
            }
        }
    }
    
    
}
