package io;

import model.History;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IOHistory implements IO<History> {

    @Override
    public void write(String path, List<History> list) {
        FileWriter fw= null;
        try {
            fw = new FileWriter(path);
            BufferedWriter bw=new BufferedWriter(fw);
            String string="Date,Name,Status,Information\n";
            for (History history:list) {
                string+=history.getDate()+","+history.getName()+","+history.getStatus()+","+history.getInfomation()+"\n";
            }
            bw.write(string);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }


    @Override
    public List<History> read(String path) {
       List<History> histories=new ArrayList<>();
       try{
           FileReader fr=new FileReader(path);
           BufferedReader br=new BufferedReader(fr);
           String line = br.readLine();
           while ((line=br.readLine())!=null){
               String[] values=line.split(",");
               History history=new History();
               history.setDate(values[0]);
               history.setName(values[1]);
               history.setStatus(values[2]);
               String str="";
               for (int i = 3; i < values.length; i++) {
                   str+=values[i];
               }
               history.setInfomation(str);
           }
       }catch (IOException e){
           e.printStackTrace();
       }
       return histories;
    }

}
