package com.codeup.adlister.dao;

import com.codeup.adlister.Config;

public class DaoFactory {
    private static Cars adsDao;
    private static Config config = new Config();

    public static Cars getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLCarsDao(config);
        }
        return adsDao;
    }
}
