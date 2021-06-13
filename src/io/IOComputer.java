package io;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOComputer implements IO<Computer>{
        public static final String COMPUTER_FILE="File/computer.csv";

    @Override
    public void write(String path, List<Computer> list) throws IOException {
            FileWriter fw=new FileWriter(path);
            BufferedWriter bw=new BufferedWriter(fw);
            String str="Id,Hãng sản xuất,Tên,Chip,Ram,Ổ cứng,Màu\n";
            for (Computer computer: c)
    }

    @Override
    public List<Computer> read(String path) throws IOException {
        return null;
    }
}
