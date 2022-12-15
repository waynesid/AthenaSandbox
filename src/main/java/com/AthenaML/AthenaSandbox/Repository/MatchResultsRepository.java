package com.AthenaML.AthenaSandbox.Repository;

import com.AthenaML.AthenaSandbox.Domain.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wayne Sidney
 * Created on {14/12/2022}
 */

@Repository
public interface MatchResultsRepository extends JpaRepository<MatchResult, Long> {
}
