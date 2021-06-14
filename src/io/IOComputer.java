package io;

import model.Computer;
import service.ComputerService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOComputer implements IO<Computer>{
        ComputerService computerService;

    @Override
    public void write(String path, List<Computer> computers) throws IOException {
            FileWriter fw=new FileWriter(path);
            BufferedWriter bw=new BufferedWriter(fw);
            String str="Id,Hãng sản xuất,Tên,Chip,Ram,Ổ cứng,Màu,Số lượng\n";
            for (Computer computer: computers){
                str+=computer.getId()+","+computer.getProduct()+","+computer.getName()+","+computer.getChip()
                        +","+computer.getRam()+","+ computer.getHardDisk()+","+computer.getColor()+","+computer.getAmount()+"\n";
            }
            bw.write(str);
            bw.flush();
            bw.close();
    }

    @Override
    public List<Computer> read(String path) throws IOException {
        Computer.mId=0;
        computerService=ComputerService.getInstance();
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        String line = br.readLine();
        while ((line= br.readLine())!=null){
            String[] values=line.split(",");
            computerService.add(new Computer(values[1],values[2],values[3],Integer.parseInt(values[4]),values[5],values[6],
                    Integer.parseInt(values[7])));
        }
        br.close();
        fr.close();
        return computerService.computers;
    }
}
