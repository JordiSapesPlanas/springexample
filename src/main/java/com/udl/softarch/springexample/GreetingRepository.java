package com.udl.softarch.springexample;

import com.udl.softarch.springexample.models.Greeting;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by debian-jordi on 2/03/15.
 */
public interface GreetingRepository extends PagingAndSortingRepository<Greeting, Long>{
    @Override
    Iterable<Greeting> findAll(Sort sort);

    List<Greeting> findByContentContaining( @Param("content") String content);

}

