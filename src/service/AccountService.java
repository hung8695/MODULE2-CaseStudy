package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    public List<Account> accounts;
    private static final AccountService accountService=new AccountService();
    private AccountService(){
        this.accounts=new ArrayList<>();
        accounts.add(new Account("hihi","hihihi","Hihi"));
        accounts.add(new Account("huhu","hihihi","Huhu"));
    }
    public static AccountService getInstance(){
        return accountService;
    }

    public boolean  findById(String id){
        for (Account account:accounts){
            if (account.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void add(Account account) {
        accounts.add(account);

    }
//
//    public void delete(String id) {
//
//    }
}
