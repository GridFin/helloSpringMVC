package kr.ac.hansung.cse.dao;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CreditSummaryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getCreditSummaryRaw() {
        return entityManager.createNativeQuery("SELECT year, semester, total_score FROM credit_summary")
                .getResultList();
    }
}
