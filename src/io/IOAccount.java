package io;

import model.Account;
import service.AccountService;

import java.io.*;
import java.util.List;

public class IOAccount implements IO<Account>{
    AccountService accountService;
    @Override
    public void write(String path, List<Account> list) throws IOException {
        FileWriter fw=new FileWriter(path);
        BufferedWriter bw=new BufferedWriter(fw);
        String string="ID,Password,Name+\n";
        for (Account account:list){
            string+=account.getId()+","+account.getPassword()+","+account.getName()+"\n";
        }
        bw.write(string);
        bw.flush();
        bw.close();
    }

    @Override
    public List<Account> read(String path) throws IOException {
        accountService=AccountService.getInstance();
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        String line= br.readLine();
        while ((line= br.readLine())!=null){
            String [] values=line.split(",");
            accountService.add(new Account(values[0],values[1],values[2]));
        }
      return accountService.accounts;
    }
}
