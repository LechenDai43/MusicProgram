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
public class SS_PlateAnalyser {
    
    public SS_PlateAnalyser(){
    }
    
    private class SS_Diff{
        protected int a,b;
        protected double c;
    }
    
    public ArrayList<SS_TitleStaticPair> getInterGroupInfo(ArrayList<SS_Plate> array){
        ArrayList<ArrayList<SS_Diff>> tem = new ArrayList<ArrayList<SS_Diff>>();
        ArrayList<SS_TitleStaticPair> result = new ArrayList<SS_TitleStaticPair>();
        for(SS_Plate x : array){
            ArrayList<SS_Group> temporare = new ArrayList<SS_Group>();
            int count = 1;
            for(SS_Group y : x.array){
                if(y.number == count){
                    temporare.add(y);
                    count ++;
                }
            }
            ArrayList<SS_Diff> the_tem = new ArrayList<SS_Diff>();
            for(int i = 0; i < temporare.size() -1; i ++){
                for(int j = i + 1; j < temporare.size(); j ++){
                    SS_Diff aa = new SS_Diff();
                    aa.a = i;
                    aa.b = j;
                    aa.c = Math.abs(temporare.get(i).getAverage() - temporare.get(j).getAverage());
                    the_tem.add(aa);
                }
            }
            for(int i = 0; i < the_tem.size(); i ++){
                boolean non_exist = true;
                for(int j = 0; j < tem.size(); j ++){
                    if(tem.get(j).size() > 0){
                        if(the_tem.get(i).a == tem.get(j).get(0).a &&
                               the_tem.get(i).b == tem.get(j).get(0).b ){
                            non_exist = false;
                            tem.get(j).add(the_tem.get(i));
                        }
                    }
                }
                if(non_exist){
                    ArrayList<SS_Diff> bb = new ArrayList<SS_Diff>();
                    bb.add(the_tem.get(i));
                    tem.add(bb);
                }
            }
        }
        for(int i = 0; i < tem.size(); i ++){
            ArrayList<Double> x = new ArrayList<Double>();
            for(int j = 0; j < tem.get(i).size(); j ++){
                x.add(tem.get(i).get(j).c);
            }
            SS_StaticPair y = new SS_StaticPair(x);
            SS_TitleStaticPair z = new SS_TitleStaticPair();
            z.a = tem.get(i).get(0).a;
            z.b = tem.get(i).get(0).b;
            z.core = y;
            result.add(z);
        }        
        return result;
    }
    
    public ArrayList<SS_StaticPair> getAlternativaInfo(ArrayList<SS_Plate> array){
        ArrayList<SS_StaticPair> result = new ArrayList<SS_StaticPair>();
        ArrayList<Double> arr_1 = new ArrayList<Double>();
        ArrayList<Double> arr_2 = new ArrayList<Double>();
        ArrayList<Double> arr_3 = new ArrayList<Double>();
        ArrayList<Double> arr_4 = new ArrayList<Double>();
        ArrayList<Double> arr_5 = new ArrayList<Double>();
        ArrayList<Double> arr_6 = new ArrayList<Double>();
        ArrayList<Double> arr_7 = new ArrayList<Double>();
        ArrayList<Double> arr_8 = new ArrayList<Double>();
        ArrayList<ArrayList<Double>> tem = new ArrayList<ArrayList<Double>>();
        tem.add(arr_1);
        tem.add(arr_2);
        tem.add(arr_3);
        tem.add(arr_4);
        tem.add(arr_5);
        tem.add(arr_6);
        tem.add(arr_7);
        tem.add(arr_8);
        for(SS_Plate x : array){
            int count = 0;
            SS_Group template = x.alternative.get(0);
            while(count < 8){
                
                for(int i = 1; i < x.alternative.size(); i ++){
                    if(x.alternative.get(i).array.size() - count >= 0 && 
                            template.array.size() - count >= 0 && 
                            x.alternative.get(i).array.size() - count < x.alternative.get(i).array.size() && 
                            template.array.size() - count < template.array.size()){
                        double fruit = x.alternative.get(i).array.get(x.alternative.get(i).array.size() - count).beat - 
                                template.array.get(template.array.size() - count).beat;
                        tem.get(count).add(fruit);
                    }
                }
                count ++;
            }
        }
        for(int i = 0; i < 8; i ++){
            if(i < tem.size()){
                SS_StaticPair item = new SS_StaticPair(tem.get(i));
                result.add(item);
            }
        }
        return result;
    }
    
    public int getMaxNumber(ArrayList<SS_Plate> array){
        int max = 0;
        for(SS_Plate x : array){
            if(x.count > max){
                max = x.count;
            }
        }
        return max;
    }
    
}
