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
public class SS_GroupAnalyser {
    protected ArrayList<SS_Group> array = new ArrayList<SS_Group>();
    
    public SS_GroupAnalyser(ArrayList<SS_Group> a){
        array = a;
    }
    
    public SS_TopThree getFirstNoteBeat(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.array.get(0).beat);   
        }
        SS_TopThree result = new SS_TopThree(tem);        
        return result;
    }
    
    public SS_TopThree getFirstNoteLength(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.array.get(0).length);
        }
        SS_TopThree result = new SS_TopThree(tem);
        return result;
    }
    
    public SS_TopThree getSecondNoteBeat(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.array.get(1).beat);
        }
        SS_TopThree result = new SS_TopThree(tem);
        return result;
    }
    
    public SS_TopThree getSecondNoteLength(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.array.get(1).length);
        }
        SS_TopThree result = new SS_TopThree(tem);
        return result;
    }
    
    public SS_TopThree getLastNoteBeat(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.array.get(x.array.size() - 1).beat);
        }
        SS_TopThree result = new SS_TopThree(tem);
        return result;
    }
    
    public SS_TopThree getLastNoteLength(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.array.get(x.array.size() - 1).length);
        }
        SS_TopThree result = new SS_TopThree(tem);
        return result;
    }
    
    public ArrayList<SS_SecondaryData> getNoteBeat(){
        ArrayList<SS_SecondaryData> result = new ArrayList<SS_SecondaryData>();
        for(SS_Group x : array){
            for(int i = 0; i < x.array.size(); i ++){                
                if(x.array.get(i).beat == 0){
                    continue;
                }else{
                    if(i == 0){
                        addBack(result,x.array.get(i).beat,x.array.get(i + 1).beat);
                    }else if(i == x.array.size() - 1){
                        addFront(result,x.array.get(i).beat,x.array.get(i - 1).beat);
                    }else{
                        addBack(result,x.array.get(i).beat,x.array.get(i + 1).beat);
                        addFront(result,x.array.get(i).beat,x.array.get(i - 1).beat);
                    }
                }
            }
        }
        
        for(int i = 0; i < result.size(); i ++){
            result.get(i).sort();;
        }
        System.out.print(result.size());
        
        if(result.size() > 5){
            ArrayList<SS_SecondaryData> n_result = (ArrayList<SS_SecondaryData>)(result.subList(0,5));
            result = n_result;
        }        
        System.out.print("runningb ");
        return result;
    }
    
    public ArrayList<SS_SecondaryData> getNoteLength(){
        ArrayList<SS_SecondaryData> result = new ArrayList<SS_SecondaryData>();
        for(SS_Group x : array){
            for(int i = 0; i < x.array.size(); i ++){
                    boolean non_exist = true;
                    if(i == 0){
                        addBack(result,x.array.get(i).length,x.array.get(i + 1).length);
                    }else if(i == x.array.size() - 1){
                        addFront(result,x.array.get(i).length,x.array.get(i - 1).length);
                    }else{
                        addBack(result,x.array.get(i).length,x.array.get(i + 1).length);
                        addFront(result,x.array.get(i).length,x.array.get(i - 1).length);
                    }
            }
        }
        System.out.print("runningl ");
        for(int i = 0; i < result.size(); i ++){
            result.get(i).sort();
        }
        if(result.size() > 3){
            result = (ArrayList<SS_SecondaryData>)(result.subList(0,3));
        } 
        
        return result;
    }
    
    public SS_StaticPair getLengthOfGroup(){
        ArrayList<Integer> tem = new ArrayList<Integer>();
        for(SS_Group x : array){
            tem.add(x.getLength());
        }
        SS_StaticPair result = new SS_StaticPair(tem);
        return result;
    }

    private void addBack(ArrayList<SS_SecondaryData> result, int length, int length0) {
        boolean non_exist = true;
        for(int i = 0; i < result.size(); i ++){
            Integer x = (Integer)(result.get(i).core);
            if(x == length){
                non_exist = false;
                boolean dis_exist = true;
                for(int j = 0; j < result.get(i).arrayback.size(); j ++){
                    Integer y = (Integer)(result.get(i).arrayback.get(j).x);
                    if(y == length0){
                        dis_exist = false;
                        result.get(i).arrayback.get(j).count ++;
                        break;
                    }
                }
                if(dis_exist){
                    result.get(i).arrayback.add(new SS_PrimaryData(length0));
                }
                break;
            }
        }
        if(non_exist){
            SS_PrimaryData temA = new SS_PrimaryData(length0);
            SS_SecondaryData temB = new SS_SecondaryData(length);
            temB.arrayback.add(temA);
            result.add(temB);
        }
    }

    private void addFront(ArrayList<SS_SecondaryData> result, int length, int length0) {
        boolean non_exist = true;
        for(int i = 0; i < result.size(); i ++){
            Integer x = (Integer)(result.get(i).core);
            if(x == length){
                non_exist = false;
                boolean dis_exist = true;
                for(int j = 0; j < result.get(i).arrayfront.size(); j ++){
                    Integer y = (Integer)(result.get(i).arrayfront.get(j).x);
                    if(y == length0){
                        dis_exist = false;
                        result.get(i).arrayfront.get(j).count ++;
                        break;
                    }
                }
                if(dis_exist){
                    result.get(i).arrayfront.add(new SS_PrimaryData(length0));
                }
                break;
            }
        }
        if(non_exist){
            SS_PrimaryData temA = new SS_PrimaryData(length0);
            SS_SecondaryData temB = new SS_SecondaryData(length);
            temB.arrayfront.add(temA);
            result.add(temB);
        }
    }
    
    
    
}
