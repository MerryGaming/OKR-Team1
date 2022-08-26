package org.aibles.okr_team1.repository;

import org.aibles.okr_team1.entity.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long>,
    JpaSpecificationExecutor<Objective> {

}
