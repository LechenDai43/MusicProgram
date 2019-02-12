/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeLe
 */
public class SS_StaticPair {
    protected double average, deviation;
    
    public SS_StaticPair(double a, double b){
        average = a;
        deviation = b;
    }
    
    public SS_StaticPair(ArrayList<Integer> a){
        double sum = 0;
        for(Integer x : a){
            sum += x;
        }
        average = sum / a.size();
        sum = 0;
        for(Integer x : a){
            sum += Math.pow(x - average, 2);
        }
        sum /= a.size();
        deviation = Math.sqrt(sum);
    }
    
    public SS_StaticPair(List<Double> a){
        double sum = 0;
        for(double x : a){
            sum += x;
        }
        average = sum / a.size();
        sum = 0;
        for(double x : a){
            sum += Math.pow(x - average, 2);
        }
        sum /= a.size();
        deviation = Math.sqrt(sum);
    }
}
