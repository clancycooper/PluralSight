package com.pluralsight.dao;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcLeaseContractDAO {
    private static BasicDataSource dataSource;

    public JdbcLeaseContractDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void saveLease(String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {

    }
}
