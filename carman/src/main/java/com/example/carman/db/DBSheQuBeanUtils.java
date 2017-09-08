package com.example.carman.db;

import android.content.Context;

import com.aidebar.greendaotest.gen.DBSheQuBeanDao;
import com.aidebar.greendaotest.gen.DaoManager;

import java.util.List;

/**
 * Created by Json on 2017/5/18.
 */

public class DBSheQuBeanUtils {

    private DBSheQuBeanDao dbUserInfoBeanDao ;
    private static DBSheQuBeanUtils dbUserInvestmentUtils=null;

    public DBSheQuBeanUtils  (Context context){
        dbUserInfoBeanDao= DaoManager.getInstance(context).getNewSession().getDBSheQuBeanDao();
    }

    public static DBSheQuBeanUtils getInstance(){
        return dbUserInvestmentUtils;
    }
    public static void Init(Context context){
        if(dbUserInvestmentUtils == null){
            dbUserInvestmentUtils = new DBSheQuBeanUtils(context);
        }
    }

    /**
     * 完成对数据库中插入一条数据操作
     * @param
     * @return
     */
    public void insertOneData(DBSheQuBean dbUserInvestment){
        dbUserInfoBeanDao.insertOrReplace(dbUserInvestment);
    }

    /**
     * 完成对数据库中插入多条数据操作
     * @param dbUserInvestmentList
     * @return
     */
    public boolean insertManyData(List<DBSheQuBean> dbUserInvestmentList){
        boolean flag = false;
        try{
            dbUserInfoBeanDao.insertOrReplaceInTx(dbUserInvestmentList);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据操作
     * @param dbUserInvestment
     * @return
     */
    public boolean deleteOneData(DBSheQuBean dbUserInvestment){
        boolean flag = false;
        try{
            dbUserInfoBeanDao.delete(dbUserInvestment);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据 ByKey操作
     * @return
     */
    public boolean deleteOneDataByKey(long id){
        boolean flag = false;
        try{
            dbUserInfoBeanDao.deleteByKey(id);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除数据操作
     * @return
     */
    public boolean deleteManData(List<DBSheQuBean> dbUserInvestmentList){
        boolean flag = false;
        try{
            dbUserInfoBeanDao.deleteInTx(dbUserInvestmentList);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库更新数据操作
     * @return
     */
    public boolean updateData(DBSheQuBean dbUserInvestment){
        boolean flag = false;
        try{
            dbUserInfoBeanDao.update(dbUserInvestment);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库批量更新数据操作
     * @return
     */
    public boolean updateManData(List<DBSheQuBean> dbUserInvestmentList){
        boolean flag = false;
        try{
            dbUserInfoBeanDao.updateInTx(dbUserInvestmentList);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库查询数据操作
     * @return
     */
    public DBSheQuBean queryOneData(long id) {
        return dbUserInfoBeanDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     * @return
     */
    public List<DBSheQuBean> queryAllData() {
        return dbUserInfoBeanDao.loadAll();
    }

    /**
     * 完成对数据库条件查询数据操作 DependUserName
     * @return
     */
    public List<DBSheQuBean> queryDataDependUserName(String userName) {
        return dbUserInfoBeanDao.queryBuilder().where(DBSheQuBeanDao.Properties.UserName.eq(userName)).build().list();
    }

    /**
     * 完成对数据库条件查询数据操作 DependInfoURl
     * @return
     */
    public List<DBSheQuBean> queryDataDependInfoURl(String InfoURl) {
        return dbUserInfoBeanDao.queryBuilder().where(DBSheQuBeanDao.Properties.Url.eq(InfoURl)).build().list();
    }
}
