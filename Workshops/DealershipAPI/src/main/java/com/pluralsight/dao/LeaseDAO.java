package com.pluralsight.dao;

import com.pluralsight.models.LeaseContract;

import java.util.List;

public interface LeaseDAO {
    List<LeaseContract> getAllLeases();
    List<LeaseContract> getByID(int leaseID);
    LeaseContract insertLease(LeaseContract lease);

}
