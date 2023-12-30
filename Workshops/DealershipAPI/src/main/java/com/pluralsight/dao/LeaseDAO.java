package com.pluralsight.dao;

import com.pluralsight.models.LeaseContract;

import java.util.List;

public interface LeaseDAO {
    List<LeaseContract> getAllLeases();
    LeaseContract insertLease(LeaseContract lease);

}
