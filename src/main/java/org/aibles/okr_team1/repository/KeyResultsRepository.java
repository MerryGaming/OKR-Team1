package org.aibles.okr_team1.repository;

import org.aibles.okr_team1.entity.KeyResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyResultsRepository extends JpaRepository<KeyResults, Long>,
    JpaSpecificationExecutor<KeyResults> {

}
