package com.pluralsight.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import com.pluralsight.models.SalesContract;
import javax.sql.DataSource;

public class SalesContractDAO {
    private DataSource dataSource;

    public SalesContractDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void saveSale(String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {

    }
}
