package com.web.Service;


import com.web.DAO.AccountDao;
import com.web.Model.Account;

public class AccountService {
    AccountDao accountDao = new AccountDao();

    public Account checkLogin(String username, String password){
        return accountDao.checklogin(username,password);
    }
}
