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
public class SS_Note {
    protected String name, longness;
    protected int beat, length;
    
    public SS_Note(String a, String b  /*获取符合格式的音高、音符的字符串*/){
        name = a;
        longness = b;
        SS_Scale scale = new SS_Scale();
        beat = scale.getHz(a); //通过标尺获得符合各式的音高字符串对应的数字
        SS_Transform transform = new SS_Transform();
        try {
            length = transform.getLength(b);  //通过转换器获得符合各式的音长字符串对应的数字
        }catch (Exception e){

        }
    }
    
    public String toString(){
        return name + "," + longness; //按照歌曲文件内部的音符格式，返回音符字符串
    }
}
