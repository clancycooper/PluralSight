package com.pluralsight.dealership.DAOs;

import org.apache.commons.dbcp2.BasicDataSource;
import com.pluralsight.dealership.LeaseContract;
import javax.sql.DataSource;

public class LeaseContractDAO {
    private static BasicDataSource dataSource;
    static String username = System.getenv("MY_SQL_USERNAME");
    static String password  = System.getenv("MY_SQL_PASSWORD");

    static {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/cardealership");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public LeaseContractDAO(DataSource dataSource) {
        this.dataSource = (BasicDataSource) dataSource;
    }

    public static void saveLease(String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {

    }
}
