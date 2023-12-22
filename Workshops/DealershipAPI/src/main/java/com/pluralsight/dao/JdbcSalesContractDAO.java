package com.pluralsight.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class JdbcSalesContractDAO {
    private DataSource dataSource;

    public JdbcSalesContractDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void saveSale(String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {

    }
}
