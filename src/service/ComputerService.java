package service;

import io.Start;
import model.Computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerService implements GeneralService<Computer> {
    public List<Computer> computers;
    private static final ComputerService computerService =new ComputerService();
    private ComputerService(){
        this.computers=new ArrayList<>();
        computers.add(new Computer("HP","340sG7","i3",4,"SSD 512GB","black",14));
        computers.add(new Computer("Lenovo","Ideapad3","i3",8,"SSD 512GB","pink",20));
    }

    public static ComputerService getInstance(){
        return computerService;
    }


   @Override
    public List<Computer> findAll() {
        return computers;
    }

//    public Computer findByName(String name){
//        for(Computer computer:computers){
//            if (computer.getName().equals(name)){
//                return computer;
//            }
//        }
//        return null;
//    }

    @Override
    public Computer findById(String id) {
        for (Computer computer: computers){
            if (computer.getId().equals(id)){
                return computer;
            }
        }
        return null;
    }
    public List<Computer>find(String infor){
        List<Computer> computerList=new ArrayList<>();
        for (Computer computer: computers){
            if (computer.getColor().equals(infor)|| computer.getHardDisk().equals(infor)||
                    computer.getRam()==Integer.parseInt(infor)
            ||computer.getName().equals(infor)||computer.getChip().equals(infor)|| computer.getProduct().equals(infor)||
            computer.getId().equals(infor)){
                computerList.add(computer);
            }
        }
        return computerList;
    }

    @Override
    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public void edit(String id) {
        Start start=new Start();
        Computer newComputer= start.creatComputer();
        if (findById(id)!=null){
          findById(id).setAmount(newComputer.getAmount());
            findById(id).setColor(newComputer.getColor());
            findById(id).setChip(newComputer.getChip());
            findById(id).setProduct(newComputer.getProduct());
            findById(id).setRam(newComputer.getRam());
            findById(id).setHardDisk(newComputer.getHardDisk());
            findById(id).setName(newComputer.getName());
        }
        Computer.mId--;

    }
    public boolean exportComputer(String id,int number){
        if(findById(id)!=null){
            findById(id).setAmount(findById(id).getAmount()+number);
            return true;
        }
        return false;
    }
    public boolean importComputer(String id, int number){
        if (findById(id)!=null){
            findById(id).setAmount(findById(id).getAmount()-number);
            return true;
        }
        return false;
    }

    @Override
    public void delete(String id) {
        computers.remove(findById(id));

    }
}
