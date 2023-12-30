package com.pluralsight.dao;

import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.Vehicle;
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
public class JdbcLeaseContractDAO implements LeaseDAO {
    private static DataSource dataSource;

    @Autowired
    public JdbcLeaseContractDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<LeaseContract> getAllLeases() {
        List<LeaseContract> allLeases = new ArrayList<>();
        String query = "SELECT * FROM lease_contracts;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {

            while (result.next()) {
                int leaseID = result.getInt("lease_id");
                int VIN = result.getInt("VIN");
                int dealershipID = result.getInt("dealership_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String address = result.getString("address");
                double amountPaid = result.getDouble("amount_paid");
                double amountDue = result.getDouble("amount_due");
                String startDate = result.getString("start_date");
                String endDate = result.getString("end_date");
                LeaseContract leaseContract = new LeaseContract(leaseID, VIN, dealershipID, firstName, lastName, address, startDate, endDate, amountPaid, amountDue);
                allLeases.add(leaseContract);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return allLeases;
    }

    @Override
    public LeaseContract insertLease(LeaseContract lease) {
        return null;
    }
}
