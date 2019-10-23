package com.wyb.dao;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.wyb.model.Commodity;

@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}