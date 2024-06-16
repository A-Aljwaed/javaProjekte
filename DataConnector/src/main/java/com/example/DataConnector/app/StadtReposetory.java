package com.example.DataConnector.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadtReposetory extends CrudRepository <Citys, Long>
{




}
