package com.mehdilagdimi.macnss_spring_mvc.repository;

import com.mehdilagdimi.macnss_spring_mvc.entity.Consultation;
import com.mehdilagdimi.macnss_spring_mvc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}

