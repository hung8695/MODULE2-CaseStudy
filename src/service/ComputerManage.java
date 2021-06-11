package service;

import file.IOFile;
import model.Computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerManage implements Manage<Computer> {
    List<Computer> computers;
    public ComputerManage(){
        computers=new ArrayList<>();
    }


    @Override
    public void creat(Computer computer) {
        computers.add(computer);
    }

    @Override
    public void display() {
        for (Computer computer: computers){
            System.out.println(computer);
        }
    }


    public Computer findByCode(String code) {
        for (Computer computer:computers){
            if(computer.getCode().equals(code)){
                return computer;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String code) {
        if(findByCode(code)!=null){
            computers.remove(findByCode(code));
            return true;
        }
        return false;
    }

    @Override
    public Computer update(String code) {
        if(findByCode(code)!=null){
            Computer computer=findByCode(code);
        }
        return null;
    }

    @Override
    public void sort() {

    }
}
