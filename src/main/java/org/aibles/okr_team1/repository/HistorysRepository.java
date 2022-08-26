package org.aibles.okr_team1.repository;

import org.aibles.okr_team1.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorysRepository extends JpaRepository<History, Long>,
    JpaSpecificationExecutor<History> {

}
