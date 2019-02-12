/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSimpleMoledy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LeLe
 */
public class SS_SongWriter {
    public SS_SongWriter(){
        
    }
    
    public void writeSong(String address, SS_NewSong song) throws Exception{
        File file = new File(address);
        file.createNewFile();        
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(song.metre + "\n");
        out.write(song.structure + "\n");
        out.write(song.title + " " + song.singer + " " + song.composer + " " + song.producer + "\n");
        out.write(song.style_1 + " " + song.style_2 + "\n");
        String tags = "";
        for(String x : song.tags){
            tags = tags + x + " ";
        }
        out.write(tags + "\n");
        for(SS_NewPlate x : song.array){
            out.write(x.toString() + "\n");
            for(int i = 0; i < 8; i ++){
                String one_group = "";
                for(ArrayList<SS_Group> y : x.array){
                    if(y.size() > i){
                        one_group = one_group + y.get(i).toString() + "| ";
                    }
                }
                out.write(one_group + "\n");
            }
        }
        out.write("EndFile \r\n");
        out.flush();
        out.close();
    }
    
}
