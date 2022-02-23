package com.team5.toc.api.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.team5.toc.api.beans.TOC;

@Repository
public interface TOCRepository extends MongoRepository<TOC, Integer>{

}
