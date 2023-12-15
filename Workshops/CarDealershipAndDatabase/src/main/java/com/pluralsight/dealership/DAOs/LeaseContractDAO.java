package com.pluralsight.dealership.DAOs;

import org.apache.commons.dbcp2.BasicDataSource;
import com.pluralsight.dealership.LeaseContract;
import javax.sql.DataSource;

public class LeaseContractDAO {
    private static BasicDataSource dataSource;

    public LeaseContractDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void saveLease(String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {

    }
}
