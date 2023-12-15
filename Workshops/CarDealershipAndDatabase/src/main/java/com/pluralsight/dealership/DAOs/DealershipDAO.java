package com.pluralsight.dealership.DAOs;

import org.apache.commons.dbcp2.BasicDataSource;
import com.pluralsight.dealership.Dealership;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DealershipDAO {
    private static BasicDataSource dataSource;
    static String username = System.getenv("MY_SQL_USERNAME");
    static String password = System.getenv("MY_SQL_PASSWORD");

    static {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/cardealership");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public DealershipDAO(DataSource dataSource) throws SQLException {
        this.dataSource = (BasicDataSource) dataSource;
    }

    DealershipDAO dealershipManager = new DealershipDAO(dataSource);

    public static void getDealership() {
    }

    public static void saveDealership(String name, String phone, String address) {

    }
}


