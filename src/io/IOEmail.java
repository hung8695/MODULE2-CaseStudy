package io;

import model.Account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class IOEmail implements IO<Account>{
    @Override
    public void write(String path, List<Account> list) throws IOException {
        FileWriter fw=new FileWriter(path);
        BufferedWriter bw=new BufferedWriter(fw);

    }

    @Override
    public List<Account> read(String path) throws IOException {
        return null;
    }
}
