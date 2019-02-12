/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author LeLe
 */
public class SS_SongContentReader {
    protected ArrayList<SS_Song> array = new ArrayList<SS_Song>();
    protected File root;
    
    public SS_SongContentReader(String address){
        root = new File(address); //获取根目录文件
    }
    
    public void readFile() throws Exception{
        //建立阅读器
        FileInputStream fis = new FileInputStream(root);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader rReader = new BufferedReader(isr);
        
        //读取根目录下每一个歌曲文件地址
        while(rReader.ready()){
            SS_SongReader sr = new SS_SongReader(rReader.readLine()); //创建歌曲阅读器，并阅读对应歌曲文件
            array.add(sr.export()); //返回歌曲文件
        }
    }
    
    public ArrayList<SS_Song> export() throws Exception{
        readFile();
        return array; //输出全部歌曲
    }
    
    
}
