package io;

import controller.Valid;
import model.Account;
import model.Computer;
import model.History;
import service.AccountService;
import service.ComputerService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static final String REGEX_ACCOUNT_ID = "^[A-Za-z0-9]{6,}[0-9]*$";
    public static final String REGEX_ACCOUNT_PASSWORD = "^[A-Za-z0-9]{6,}$";
    public static final String FILE_HISTORY="File\\history.csv";
    public static final String FILE_COMPUTER = "File\\computer.csv";
    public static final String FILE_ACCOUNT = "File\\account.csv";
    AccountService accountService = AccountService.getInstance();
    ComputerService computerService = ComputerService.getInstance();
    IOComputer ioComputer = new IOComputer();
    IOAccount ioAccount = new IOAccount();
    Valid valid = new Valid();
    IOHistory ioHistory=new IOHistory();
    Scanner scanner = new Scanner(System.in);
    List<History> historyList=new ArrayList<>();
    String id;
        int chose;
        boolean check = false;

      public void menu1() {
          computerService.computers = ioComputer.read(FILE_COMPUTER);
          accountService.accounts = ioAccount.read(FILE_ACCOUNT);
          do {

              do {
                  start1();
                  int chose1 = scanner.nextInt();
                  scanner.nextLine();
                  switch (chose1) {
                      case 1:
                          boolean checkLogin = logIn();
                          while (!checkLogin) {
                              System.out.println("Nhập sai");
                              checkLogin = logIn();
                          }
                          System.out.println("Nhập đúng");
                          check = true;
                          break;
                      case 2:
                          creatAccount();
                          break;
                  }
              }
              while (!check);

              do {
                  menu();
                  chose = scanner.nextInt();
                  scanner.nextLine();
                  switch (chose) {
                      case 1:
                          for (Computer computer : computerService.computers) {
                              System.out.println(computer.toString());
                          }
                          ioComputer.write(Start.FILE_COMPUTER, computerService.computers);
                          break;
                      case 2:
                          System.out.println("Nhập thông tin tìm kiếm: ");
                          String infor = scanner.nextLine();
                          if (computerService.find(infor) != null) {
                              for (Computer computer : computerService.find(infor)) {
                                  System.out.println(computer.toString());
                              }
                          }
                          break;
                      case 3:
                          System.out.println("Nhập id cần sửa: ");
                          String idEdit = scanner.nextLine();
                          if(computerService.findById(idEdit)!=null){
                              computerService.edit(idEdit);

                              historyList.add(new History(LocalDateTime.now().toString(),getAccount(id).getName(),"Edit",computerService.findById(idEdit).toString()));
                              ioHistory.write(FILE_HISTORY,historyList);
                          } else
                              System.out.println("Id không tồn tại!");



                          break;
                      case 4:
                          System.out.println("Tìm ID: ");
                          String id1 = scanner.nextLine();
                          System.out.println("Số lượng: ");
                          int number1 = scanner.nextInt();
                          scanner.nextLine();
                          if (!computerService.importComputer(id1, number1)) {
                              System.out.println("Sản phẩm này chưa có trong danh sách! Bạn có muốn thêm mới không?");
                              System.out.println("1. Yes");
                              System.out.println("2. No");
                              int select = scanner.nextInt();
                              scanner.nextLine();
                              switch (select) {
                                  case 1:
                                      computerService.add(creatComputer());
                                      ioComputer.write(FILE_COMPUTER, computerService.computers);
                                      historyList.add(new History(LocalDateTime.now().toString(),getAccount(id).getName(),"ADD",computerService.findById(id1).toString()));
                                      break;
                                  default:
                                      break;
                              }
                          } else computerService.importComputer(id1, number1);
                          ioComputer.write(FILE_COMPUTER,computerService.computers);
                            historyList.add(new History(LocalDateTime.now().toString(),getAccount(id).getName(),"ADD",computerService.findById(id1).toString()));
                          break;
                      case 5:
                          System.out.println("Tìm ID:");
                          String id2 = scanner.nextLine();
                          System.out.println("Số lượng: ");
                          int number2 = scanner.nextInt();
                          scanner.nextLine();
                          if (!computerService.exportComputer(id2, number2)) {
                              System.out.println("Không tìm thấy thông tin");
                          } else computerService.exportComputer(id2, number2);
                          ioComputer.write(FILE_COMPUTER, computerService.computers);
                          historyList.add(new History(LocalDateTime.now().toString(),getAccount(id).getName(),"Export",computerService.findById(id2).toString()));
                          break;
                      case 6:

                          break;
                      case 7:
                          ioHistory.write(FILE_HISTORY,historyList);
                          for (History history: historyList){
                              System.out.println(history.toString());
                          }
                      default:
                          System.exit(0);
                  }
              } while (chose < 8 && chose > 0);

          } while (true);

      }


    public void menu() {
        System.out.println("1. Hiển thị danh sách laptop");
        System.out.println("2. Tìm kiếm ");
        System.out.println("3. Sửa thông tin ");
        System.out.println("4. Nhập kho ");
        System.out.println("5. Xuất kho ");
        System.out.println("6. Đăng xuất ");
        System.out.println("7. Lịch sử ");
        System.out.println("8. Kết thúc chương trình");
        System.out.println("Nhập lựa chọn");
    }


    public Computer creatComputer() {
        Computer computer = new Computer();
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

    public void start1() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Tạo tài khoản");
        System.out.println("Nhập lựa chọn!");
    }
    public Account getAccount(String id){
          for (Account account:accountService.accounts){
              if(accountService.findById(id)){
                  return account;
              }
          }
          return  null;
    }

    public void creatAccount() {
        Account newAccount = new Account();
        String password;
        String idCreat;
        do {
            System.out.println("Nhập id");
            idCreat = scanner.nextLine();
            if (!valid.validate(REGEX_ACCOUNT_ID,idCreat)){
                System.out.println("ID phải có ít nhất 6 ký tự ");
            }
        } while (accountService.findById(idCreat)&&valid.validate(REGEX_ACCOUNT_ID,idCreat));
        newAccount.setId(idCreat);
        do {
            System.out.println("Nhập password: ");
            password=scanner.nextLine();
            if(!valid.validate(REGEX_ACCOUNT_PASSWORD,password)){
                System.out.println("Password tối thiểu 6 ký tự, có chữ hoa, chữ thường và số!");
            }
            newAccount.setPassword(password);
        }while (!valid.validate(REGEX_ACCOUNT_PASSWORD,password));

        System.out.println("Nhập tên: ");
        newAccount.setName(scanner.nextLine());
        accountService.add(newAccount);
            ioAccount.write(FILE_ACCOUNT, accountService.accounts);
    }

    public boolean logIn() {
        String password;
        System.out.println("Nhập Id: ");
        id = scanner.nextLine();
        System.out.println("Nhập password: ");
        password = scanner.nextLine();
        for (Account account : accountService.accounts) {
            if (account.getId().equals(id) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }



}
