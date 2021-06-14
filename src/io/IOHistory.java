package io;

import model.History;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        return null;
    }
}
