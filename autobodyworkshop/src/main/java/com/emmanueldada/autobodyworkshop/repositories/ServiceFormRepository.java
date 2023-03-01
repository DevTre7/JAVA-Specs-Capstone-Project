package com.emmanueldada.autobodyworkshop.repositories;


import com.emmanueldada.autobodyworkshop.entites.ServiceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface ServiceFormRepository extends JpaRepository<ServiceForm, Long> {
//    List<ServiceForm> findAllByUserEquals(User user);
//}
@Repository
public interface ServiceFormRepository extends JpaRepository<ServiceForm, Long>{

}
