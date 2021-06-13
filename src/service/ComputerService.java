package service;

import io.Input;
import model.Computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerService implements GeneralService<Computer> {
    List<Computer> computers;
    private static final ComputerService computerService =new ComputerService();
    private ComputerService(){
        this.computers=new ArrayList<>();
        computers.add(new Computer("HP","340sG7","i3",4,"SSD 512GB","black"));
        computers.add(new Computer("Lenovo","Ideapad3","i3",8,"SSD 512GB","pink"));
    }

    public static ComputerService getInstance(){
        return computerService;
    }


    @Override
    public List<Computer> findAll() {
        return computers;
    }

    public Computer findByName(String name){
        for(Computer computer:computers){
            if (computer.getName().equals(name)){
                return computer;
            }
        }
        return null;
    }

    @Override
    public Computer findById(String id) {
        for (Computer computer: computers){
            if (computer.getId().equals(id)){
                return computer;
            }
        }
        return null;
    }

    @Override
    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public void edit(String id) {

        if (findById(id)!=null){
            Input input=new Input();
            Computer newComputer=input.creatComputer();
            findById(id).setProduct(newComputer.getProduct());
            findById(id).setName(newComputer.getName());
            findById(id).setRam(newComputer.getRam());
            findById(id).setHardDisk(newComputer.getHardDisk());
            findById(id).setColor(newComputer.getColor());
            findById(id).setChip(newComputer.getChip());
            Computer.mId--;
        }
    }

    @Override
    public void delete(String id) {
        computers.remove(findById(id));

    }
}
