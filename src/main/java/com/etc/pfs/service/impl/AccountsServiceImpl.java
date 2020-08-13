package com.etc.pfs.service.impl;

import com.etc.pfs.dao.AccountsDao;
import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.PageInfo;
import com.etc.pfs.entity.Remark;
import com.etc.pfs.service.AccountsService;

import java.util.List;
import java.util.Map;

public class AccountsServiceImpl implements AccountsService {
    private AccountsDao accountsDao = new AccountsDao();

    @Override
    public Integer insertAccounts(Accounts accounts) {
        return accountsDao.insertAccounts(accounts);
    }

    @Override
    public Integer updateAccounts(Accounts accounts) {
        return accountsDao.updateAccounts(accounts);
    }

    @Override
    public Integer deleteAccounts(String id) {
        return accountsDao.deleteAccounts(id);
    }

    @Override
    public Accounts selectAccountsById(String id) {
        return accountsDao.selectAccountsById(id);
    }

    @Override
    public List<Accounts> selectAllIcategory(String icategory, String username) {
        return accountsDao.selectAllAccounts(icategory,username);
    }

    @Override
    public PageInfo<Accounts> selectAllIcategory(String icategory, String username, String start, String rows) {
        Integer pageNumber = Integer.valueOf(start);
        Integer rowNumber = Integer.valueOf(rows);
        Integer totalNum = accountsDao.selectCountAccountsByIcateGory(icategory,username);
        Integer totalPage = totalNum%rowNumber == 0?(totalNum/rowNumber):(totalNum/rowNumber)+1;
        List<Accounts> list = accountsDao.selectAllByIcateGory(icategory,username,(pageNumber-1)*rowNumber,rowNumber);
        PageInfo<Accounts> pageInfo = new PageInfo<>(pageNumber,rowNumber,totalNum,totalPage,list);
        return pageInfo;
    }

    @Override
    public PageInfo<Accounts> selectAllIcategory(String icategory, String username, String start, String rows, Map<String, String[]> condition) {
        if(start == null && rows == null){
            start = "1";
            rows = "5";
        }
        Integer pageNumber = Integer.valueOf(start);
        Integer rowNumber = Integer.valueOf(rows);
        Integer totalNum = accountsDao.selectCountAccountsByIcateGory(icategory,username,condition);
        Integer totalPage = totalNum%rowNumber == 0?(totalNum/rowNumber):(totalNum/rowNumber)+1;
        List<Accounts> list = accountsDao.selectAllByIcateGory(icategory,username,(pageNumber-1)*rowNumber,rowNumber,condition);
        PageInfo<Accounts> pageInfo = new PageInfo<>(pageNumber,rowNumber,totalNum,totalPage,list);
        return pageInfo;
    }


    @Override
    public Float selectSumByIcategory(String icategory, String username, String time, String nowTime) {
        return accountsDao.selectSumByIcategory(icategory,username,time,nowTime);
    }

    @Override
    public Integer selectCountByClassif(String classif, String username, String time, String nowTime) {
        return accountsDao.selectCountByClassif(classif,username,time,nowTime);
    }

    @Override
    public Integer selectCountByIcateGory(String icategory, String username, String time, String nowTime) {
        return accountsDao.selectCountByIcateGory(icategory,username,time,nowTime);
    }

    @Override
    public Integer selectCountAccountsByIcategory(String icategory, String username) {
        return accountsDao.selectCountAccountsByIcateGory(icategory,username);
    }

    @Override
    public Integer selectCountRemarkByClassif(String classif,String username) {
        return accountsDao.selectCountRemarkByClassif(classif,username);
    }

    @Override
    public List<Remark> selectClassif(String classif,String username, Integer start, Integer rows) {
        return accountsDao.selectClassif(classif,username,start,rows);
    }

    @Override
    public PageInfo<Remark> findAccountsByPage(String start, String rows, String classif,String username) {
        Integer pageNumber = Integer.valueOf(start);
        Integer rowNumber = Integer.valueOf(rows);
        Integer totalNum = accountsDao.selectCountRemarkByClassif(classif,username);
        Integer totalPage = totalNum%rowNumber == 0?(totalNum/rowNumber):(totalNum/rowNumber)+1;
        List<Remark> list = accountsDao.selectClassif(classif,username,(pageNumber-1)*rowNumber,rowNumber);
        PageInfo<Remark> pageInfo = new PageInfo<>(pageNumber,rowNumber,totalNum,totalPage,list);
        return pageInfo;
    }
}
