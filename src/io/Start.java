package io;

import controller.Valid;
import model.Account;
import model.Computer;
import service.AccountService;
import service.ComputerService;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static final String FILE_COMPUTER="File\\computer.csv";
    public static final String FILE_ACCOUNT="File\\account.csv";
    AccountService accountService=AccountService.getInstance();
    ComputerService computerService=ComputerService.getInstance();
    IOComputer ioComputer=new IOComputer();
    IOAccount ioAccount=new IOAccount();
    Valid valid=new Valid();

    Scanner scanner=new Scanner(System.in);
    public void display(){
        int chose;
        try {
            computerService.computers=ioComputer.read(FILE_COMPUTER);
            accountService.accounts=ioAccount.read(FILE_ACCOUNT);
        } catch (IOException e) {
            e.printStackTrace();
        }
       do{
           start1();
           int chose1=scanner.nextInt();
           scanner.nextLine();
           switch (chose1){
               case 1:
                   logIn();
                   break;
               case 2:
                   creatAccount();
                   break;
           }
       } while (logIn());

       do{
           menu();
           chose=scanner.nextInt();
           scanner.nextLine();
           switch (chose){
               case 1:
                   for (Computer computer : computerService.computers){
                       System.out.println(computer.toString());
                   }
                   break;
               case 2:
                   System.out.println("Nhập thông tin tìm kiếm: " );
                   String infor=scanner.nextLine();
                   if(computerService.find(infor)!=null){
                       for (Computer computer: computerService.find(infor)){
                           System.out.println(computer.toString());
                       }
                   }
                   break;
               case 3:
                   System.out.println("Nhập id cần sửa: ");
                   String id=scanner.nextLine();
                   computerService.edit(id);
                   break;
               case 4:
                   System.out.println("Tìm ID: ");
                   String id1=scanner.nextLine();
                   System.out.println("Số lượng: ");
                   int number1=scanner.nextInt();
                   scanner.nextLine();
                   if (!computerService.importComputer(id1,number1)){
                       System.out.println("Sản phẩm này chưa có trong danh sách! Bạn có muốn thêm mới không?");
                       int select=scanner.nextInt();
                       scanner.nextLine();
                       switch (select){
                           case 1:
                               computerService.add(creatComputer());
                               break;
                           default:
                               break;
                       }
                   }
                   else computerService.importComputer(id1,number1);
                   break;
               case 5:
                   System.out.println("Tìm ID:");
                   String id2=scanner.nextLine();
                   System.out.println("Số lượng: ");
                   int number2=scanner.nextInt();
                   scanner.nextLine();
                   if (!computerService.exportComputer(id2,number2)){
                       System.out.println("Không tìm thấy thông tin");
                   } else computerService.exportComputer(id2, number2);
                   break;
               case 6:

                   break;
           }
       }while (chose<=0&&chose>6);
    }
    public void menu(){
        System.out.println("1. Hiển thị danh sách laptop");
        System.out.println("2. Tìm kiếm ");
        System.out.println("3. Sửa thông tin ");
        System.out.println("4. Nhập kho ");
        System.out.println("5. Xuất kho ");
        System.out.println("6.  ");
        System.out.println("Nhập lựa chọn");
    }


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
        System.out.println("Nhập số lượng");
        computer.setAmount(scanner.nextInt());
        scanner.nextLine();
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
        System.out.println("Nhập tên: ");
        newAccount.setName(scanner.nextLine());
        accountService.add(newAccount);
        try {
            ioAccount.write(FILE_ACCOUNT,accountService.accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }

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




}
