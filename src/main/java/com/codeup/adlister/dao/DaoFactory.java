package com.codeup.adlister.dao;

import com.codeup.adlister.Config;

public class DaoFactory {
    private static Cars carsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Cars getCarsDao() {
        if (carsDao == null) {
            carsDao = new MySQLCarsDao(config);
        }
        return carsDao;
    }

    public static Users getUsersDao(){
        if(usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

}
