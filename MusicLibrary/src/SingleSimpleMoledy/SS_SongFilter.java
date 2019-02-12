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
public class SS_SongFilter {
    protected ArrayList<SS_Song> array;
    
    public SS_SongFilter(ArrayList<SS_Song> a){
        array = a;
    }
    
    public void filterBySinger(String key){
        for(int i = array.size() - 1; i >= 0; i --){
            if(! array.get(i).singer.equals(key)){
                array.remove(i);
            }
            
        }
    }
    
    public void filterByComposer(String key){
        for(int i = array.size() - 1; i >= 0; i --){
            if(! array.get(i).producer.equals(key)){
                array.remove(i);
            }
            
        }
    }
    
    public void filterByProducer(String key){
        for(int i = array.size() - 1; i >= 0; i --){
            if(! array.get(i).composer.equals(key)){
                array.remove(i);
            }
            
        }
    }
    
    public void filterByStyleOne(String key){
        for(int i = array.size() - 1; i >= 0; i --){
            if(! array.get(i).style_1.equals(key)){
                array.remove(i);
            }
            
        }
    }
    
    public void filterByStyleTwo(String key){
        for(int i = array.size() - 1; i >= 0; i --){
            if(! array.get(i).style_2.equals(key)){
                array.remove(i);
            }
            
        }
    }
    
    public void filterByTags(ArrayList<String> key){
        for(int i = array.size() - 1; i >= 0; i --){
            if(! array.get(i).tags.containsAll(key)){
                array.remove(i);
            }
            
        }
    }
    
    public ArrayList<SS_Song> export(){
        return array;
    }
    
}
