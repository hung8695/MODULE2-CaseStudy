package file;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static List<Computer> readFile(String filePath){
        List<Computer> computers=new ArrayList<>();
        try {
            FileReader fr=new FileReader(filePath);
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
            while ((line= br.readLine())!=null){
                String[] hihi=line.split(",");
                computers.add(new Computer(hihi[0],hihi[1],hihi[2],hihi[3],Integer.parseInt(hihi[4])));
            }
            br.close(); fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            return computers;
    }

    public static void writeFile(String filePath,List<Computer> computers) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("Production"+","+"Name"+","+"Code"+","+"Date"+"Price"+"\n");
            for (Computer computer:computers){
                bw.write(computer.getProduction()+","+computer.getName()+","+computer.getCode()+","+computer.getDate()
                +","+computer.getPrice()+"\n");
            }
            bw.close(); fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
