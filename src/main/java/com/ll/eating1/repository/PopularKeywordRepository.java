package com.ll.eating1.repository;

import com.ll.eating1.entity.PopularKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularKeywordRepository extends JpaRepository<PopularKeyword, Long> {

    @Query("SELECT p.keyword FROM PopularKeyword p ORDER BY p.keywordCount DESC")
    List<String> findTop10Keywords();
}
