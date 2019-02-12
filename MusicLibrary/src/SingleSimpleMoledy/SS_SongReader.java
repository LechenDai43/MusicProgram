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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author LeLe
 */
/*
  Song在文件中的格式：
   metre
   structure
   title singer composer producer
   style_1 style_2
   tag1 tag2 tag3 tag4,...
   板块种类 板块编码
   音符 音符 音符 | 音符 音符 音符 音符 | 音符 音符 音符 |
   ……
  音符在文件中的格式：音高，音长
*/
public class SS_SongReader {
    protected SS_Song core = new SS_Song();
    protected BufferedReader rReader;
    
    public SS_SongReader(String address /*获取歌曲目录*/ ) throws Exception{        
        //通过歌曲目录得到歌曲文件，并建立该文件的阅读器
        File root = new File(address);
        FileInputStream fis = new FileInputStream(root);
        InputStreamReader isr = new InputStreamReader(fis);
        rReader = new BufferedReader(isr);
    }
    
    public void readSong() throws Exception{
        core.metre = rReader.readLine(); //直接文件第一行建立为歌曲节奏
        core.structure = rReader.readLine(); //直接将文件第二行建立为歌曲结构
        
        String tit_sin_com_pro = rReader.readLine(); //阅读文件第三行
        StringTokenizer tscp_tokenizer = new StringTokenizer(tit_sin_com_pro);  //将第三行分解为几个字符串
        if(tscp_tokenizer.hasMoreTokens()){
            //若有第一个koten，则其为歌曲名称
            core.title = tscp_tokenizer.nextToken();
        }
        if(tscp_tokenizer.hasMoreTokens()){ 
            //若有第二个token，则其为歌手
            core.singer = tscp_tokenizer.nextToken();
        }
        if(tscp_tokenizer.hasMoreTokens()){
            //若有第三个token，则其为作曲者
            core.composer = tscp_tokenizer.nextToken();
        }
        if(tscp_tokenizer.hasMoreTokens()){
            //若有第四个token，则其为出品
            core.producer = tscp_tokenizer.nextToken();
        }      
        
        String style = rReader.readLine();      //  阅读文件第四行
        StringTokenizer style_tokenizer = new StringTokenizer(style);
        if(style_tokenizer.hasMoreTokens()){
            //若有第一个token，则为风格一
            core.style_1 = style_tokenizer.nextToken();
        }
        if(style_tokenizer.hasMoreTokens()){
            //若有第二个token，则为风格二
            core.style_2 = style_tokenizer.nextToken();
        }
        
        String tags = rReader.readLine(); //读取文件第五行
        StringTokenizer tag_tokenizer = new StringTokenizer(tags);
        while(tag_tokenizer.hasMoreTokens()){
            //将第五行的每一个token添加早歌曲的标签数组
            core.tags.add(tag_tokenizer.nextToken());
        }
        
        String aline = rReader.readLine();  //此行应包含第一个版块的种类和编号
        
        while(! aline.startsWith("End") /*阅读文件本体，直到读到以End开头的结尾*/){
        //每一次循环都建立一个版块
        
            SS_Plate s_plate;  //建立一个空版块
            
            //确立新版块的种类和编号
            StringTokenizer tokenizer = new StringTokenizer(aline);  //来自while循环之前，或内while循环最后一次读取的内容
            char type = 'a';
            int number = 0;
            if(tokenizer.hasMoreTokens()){
                type = tokenizer.nextToken().charAt(0);
            }
            if(tokenizer.hasMoreTokens()){
                number = Integer.parseInt(tokenizer.nextToken());
            }
            s_plate = new SS_Plate(type,number);
            
            //阅读新版块中的乐谱信息
            aline = rReader.readLine(); //每一行都包括多个组
            ArrayList<ArrayList<SS_Group>> outer_arr = new ArrayList<ArrayList<SS_Group>>();
            while(aline.length() > 10 /*若某一行小于10个字符，则停止循环，因为其为下一个模板信息*/){
            //每一次循环都读取行，也就是一组音符组
            
                tokenizer = new StringTokenizer(aline);  //将该行进行拆解
                ArrayList<SS_Group> inner_arr = new ArrayList<SS_Group>(); 
                
                while(tokenizer.hasMoreTokens() /*解读直至该行结束*/){
                
                    String a_token = tokenizer.nextToken(); //抽取下一个token
                    SS_Group a_group = new SS_Group();
                    
                    while(! a_token.equals("|") && tokenizer.hasMoreTokens()/*直到出现“|”，也就是一组的结尾*/){
                    //每一次循环都是一个组
                    
                        int index = a_token.indexOf(",");   //确定“，”的位置，也就是音符音高和音长的分节
                        
                        if(index > 0 && index < a_token.length()){  //确保的确有“，”
                            String _beat = a_token.substring(0, index);  //读取“，”前面的部分，作为音符的音高
                            String _length = a_token.substring(index + 1);  //读取“，”后面的部分，作为音符音长
                            SS_Note a_note = new SS_Note(_beat,_length); //建立新的音符
                            a_group.array.add(a_note); //将音符加在组里
                        }
                        
                        a_token = tokenizer.nextToken();  //获取下一个token
                    }
                    inner_arr.add(a_group);
                }
                aline = rReader.readLine();
                outer_arr.add(inner_arr);
            }
            s_plate.setUp(outer_arr);
            core.array.add(s_plate);
        }
    }

    public SS_Song export() throws Exception{
        readSong();
        return core;
    }
    
    
    
    
    
}
