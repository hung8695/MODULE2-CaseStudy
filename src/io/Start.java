package io;

import model.Account;
import model.Computer;
import service.AccountService;

import java.util.Scanner;

public class Start {
    AccountService accountService=AccountService.getInstance();

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

    public void start1(){
        System.out.println("1. Đăng nhập");
        System.out.println("2. Tạo tài khoản");
        System.out.println("Nhập lựa chọn!");
    }

    public void creatAccount(){
        Account newAccount=new Account();
        String id;
        do {
            System.out.println("Nhập id");
            id=scanner.nextLine();
        } while (!accountService.findById(id));
        newAccount.setId(id);
        System.out.println("Nhập password");
        newAccount.setPassword(scanner.nextLine());
        accountService.add(newAccount);

    }

    public boolean logIn(){
        String id;
        String password;
        System.out.println("Nhập Id: ");
        id=scanner.nextLine();
        System.out.println("Nhập password: ");
        password=scanner.nextLine();
        for (Account account:accountService.accounts){
            if(account.getId().equals(id)&&account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void menu(){
        System.out.println();
    }

}
