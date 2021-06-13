package io;

import model.Computer;

import java.util.Scanner;

public class Input {
    Scanner scanner=new Scanner(System.in);
    public Computer creatComputer(){
       Computer computer=new Computer();
        System.out.println("Nhập hãng sản xuất: ");
        computer.setProduct(scanner.nextLine());
        System.out.println("Nhập tên: ");
        computer.setName(scanner.nextLine());
        System.out.println("Chip: ");
        computer.setChip(scanner.nextLine());
        System.out.println("Ram: ");
        computer.setRam(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ổ cứng: ");
        computer.setHardDisk(scanner.nextLine());
        System.out.println("Màu: ");
        computer.setColor(scanner.nextLine());
        return computer;
    }
}
