package com.kane.origination.repo;

import com.kane.origination.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, UUID> {}
