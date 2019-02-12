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
public class SS_GroupCreator {
    protected SS_Group x = new SS_Group();
    protected int length, longi = 0;
    
    public SS_GroupCreator(int a){
        x.number = a;
    }
    
    public void setLength(SS_StaticPair a){
        double b = Math.random() * a.deviation + (a.average - (a.deviation / 2));
        length = (int)(b);
    }
    
    public void setFirstNote(SS_TopThree beat, SS_TopThree leng){
        double key_beat = (Math.random() * 8 - 2) / 2 - 0.5;
        double key_leng = (Math.random() * 8 - 2) / 2 - 0.5;
        SS_Transform tf = new SS_Transform();
        SS_Scale sc = new SS_Scale();
        String _beat;
        String _leng;
        _beat = tf.getLongness((int)beat.first);
        _leng = sc.getName((int)leng.first);
        if(key_beat > 2 && beat.third > -1){
            _beat = tf.getLongness((int)beat.third);
        }else if(key_beat > 1 && beat.second > -1){
            _beat = tf.getLongness((int)beat.second);
        }
        if(key_leng > 2 && leng.third > -1){
            _leng = sc.getName((int)beat.third);
        }else if(key_beat > 1 && beat.second > -1){
            _leng = sc.getName((int)beat.second);
        }
        SS_Note a = new SS_Note(_beat,_leng);
        longi += a.length;
        x.array.add(a);
    }
    
    public void setSecondNote(SS_TopThree beat, SS_TopThree leng){
        double key_beat = (Math.random() * 8 - 2) / 2 - 0.5;
        double key_leng = (Math.random() * 8 - 2) / 2 - 0.5;
        SS_Transform tf = new SS_Transform();
        SS_Scale sc = new SS_Scale();
        String _beat;
        String _leng;
        _beat = tf.getLongness((int)beat.first);
        _leng = sc.getName((int)leng.first);
        if(key_beat > 2 && beat.third > -1){
            _beat = tf.getLongness((int)beat.third);
        }else if(key_beat > 1 && beat.second > -1){
            _beat = tf.getLongness((int)beat.second);
        }
        if(key_leng > 2 && leng.third > -1){
            _leng = sc.getName((int)beat.third);
        }else if(key_beat > 1 && beat.second > -1){
            _leng = sc.getName((int)beat.second);
        }
        SS_Note a = new SS_Note(_beat,_leng);
        longi += a.length;
        x.array.add(a);
    }
    
    public void setLastNote(SS_TopThree beat, SS_TopThree leng){
        double key_beat = (Math.random() * 8 - 2) / 2 - 0.5;
        double key_leng = (Math.random() * 8 - 2) / 2 - 0.5;
        SS_Transform tf = new SS_Transform();
        SS_Scale sc = new SS_Scale();
        String _beat;
        String _leng;
        _beat = tf.getLongness((int)beat.first);
        _leng = sc.getName((int)leng.first);
        if(key_beat > 2 && beat.third > -1){
            _beat = tf.getLongness((int)beat.third);
        }else if(key_beat > 1 && beat.second > -1){
            _beat = tf.getLongness((int)beat.second);
        }
        if(key_leng > 2 && leng.third > -1){
            _leng = sc.getName((int)beat.third);
        }else if(key_beat > 1 && beat.second > -1){
            _leng = sc.getName((int)beat.second);
        }
        SS_Note a = new SS_Note(_beat,_leng);
        longi += a.length;
        x.array.add(a);
    }
    
    public boolean addNote(ArrayList<SS_SecondaryData> a /*音高*/, ArrayList<SS_SecondaryData> b /*音长*/){
        int beat = 0, _beat = 0, b_count = 0;        
        int leng = 0, _leng = 0, l_count = 0;
        if(x.array.size() > 0){
            beat = x.array.get(x.array.size() - 1).beat;
            leng = x.array.get(x.array.size() - 1).length;
        }
        ArrayList<Integer> aa = new ArrayList<Integer>();
        ArrayList<Integer> bb = new ArrayList<Integer>();
        int i = 0,j = 0;
        
        //建立后向音高数据的标尺
        for(i = 0; i < a.size(); i ++){
            if((Integer)a.get(i).core == beat){
                for(SS_PrimaryData y : a.get(i).arrayback){
                    l_count += y.count;
                    aa.add(l_count);
                }
                break;
            }
        }
        //System.out.print("向后音高数据");
        //建立后向音长数据的标尺
        for(j = 0; j < b.size(); j ++){            
            if((Integer)b.get(j).core == leng){
                for(SS_PrimaryData y : b.get(j).arrayback){
                    b_count += y.count;
                    bb.add(l_count);
                }
                break;
            }
        }
        if(i < a.size() && j < b.size()){
            //通过随机数来获得下一个音符的音高
            boolean beat_a = true;
            while(beat_a){
                double beat_number = Math.random() * b_count;
                for(int k = 0; k < aa.size(); k ++){
                    if(beat_number < aa.get(k)){
                        _beat = (int)a.get(i).arrayback.get(k).x;
                        break;
                    }
                }
                for(SS_SecondaryData xx : a){
                    if((Integer)xx.core == _beat){
                        if(xx.arrayfront.contains(x.array.get(x.array.size() - 1).beat)){
                           beat_a = false; 
                        }
                    }
                }
            }
            
            //通过随机数来获得下一个音符音长
            boolean leng_a = true;
            while(leng_a){
                double leng_number = Math.random() * l_count;
                for(int k = 0; k < bb.size(); k ++){
                    if(leng_number < bb.get(k)){
                        _leng = (int)b.get(i).arrayback.get(k).x;
                        break;
                    }
                }
                for(SS_SecondaryData xx : b){
                    if((Integer)xx.core == _leng){
                        if(xx.arrayfront.contains(x.array.get(x.array.size() - 1).length)){
                           leng_a = false; 
                        }
                    }
                }
            }
            SS_Scale sc = new SS_Scale();
            String this_beat = sc.getName(_beat);
            SS_Transform tf = new SS_Transform();
            String this_leng = tf.getLongness(_leng);
            SS_Note a_note = new SS_Note(this_beat,this_leng);
            longi += a_note.length;
            x.array.add(a_note);
        }else{
            int number_beat = (int)(Math.random() * a.size() / 4);
            int number_length = (int)(Math.random() * b.size() / 2);
            SS_Scale sc = new SS_Scale();
            String this_beat = sc.getName((int)a.get(number_beat).core);
            SS_Transform tf = new SS_Transform();
            String this_leng = tf.getLongness((int)b.get(number_length).core);
            SS_Note a_note = new SS_Note(this_beat,this_leng);
            longi += a_note.length;
            x.array.add(a_note);
            
        }
        return longi < length;
    }
    
    public void deleteOne(){
        x.array.remove(x.array.size() - 1);
    }
    
    public SS_Group creat(){
        return x;
    }
    
    
}
