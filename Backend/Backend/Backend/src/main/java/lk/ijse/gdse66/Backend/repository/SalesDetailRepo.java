package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.SalesDetailsEntity;

import java.util.List;

public interface SalesDetailRepo {
    Boolean existsBySalesOrderNo(String id);
    List<SalesDetailsEntity> findAllBySalesOrderNo(String id);
    void deleteAllBySalesOrderNo(String id);
}
