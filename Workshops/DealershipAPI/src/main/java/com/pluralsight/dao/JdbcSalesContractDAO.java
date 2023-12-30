package com.pluralsight.dao;

import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSalesContractDAO implements SalesDAO {
    private DataSource dataSource;

    @Autowired
    public JdbcSalesContractDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<SalesContract> getAllSales() {
        List<SalesContract> allSales = new ArrayList<>();
        String query = "SELECT * FROM sales_contracts;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {

            while (result.next()) {
                int saleID = result.getInt("sale_id");
                int VIN = result.getInt("VIN");
                int dealershipID = result.getInt("dealership_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String address = result.getString("address");
                String saleDate = result.getString("sale_date");
                SalesContract salesContract = new SalesContract(saleID, VIN, dealershipID, firstName, lastName, address, saleDate);
                allSales.add(salesContract);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return allSales;
    }

    @Override
    public SalesContract insertSale(SalesContract sale) {
        return null;
    }
}
