package com.wyb.test;


import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.wyb.model.Commodity;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTemplateTest {

	@Autowired
	public ElasticsearchTemplate elasticsearchTemplate;

	@Test
	public void testInsert() {
		Commodity commodity = new Commodity();
		commodity.setSkuId("1501009012");
		commodity.setName("葡萄吐司面包（101111111111片装）");
		commodity.setCategory("102");
		commodity.setPrice(160);
		commodity.setBrand("良品铺子");

		IndexQuery indexQuery = new IndexQueryBuilder().withObject(commodity)
				.build();
//		elasticsearchTemplate.
		elasticsearchTemplate.index(indexQuery);
		// elasticsearchTemplate.update(updates);
		// elasticsearchTemplate.delete(Commodity.class, "1501009005");
	}

	@Test
	public void testQuery() {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
				QueryBuilders.matchQuery("name", "吐司")).build();

		SearchQuery searchQuery2 = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.matchPhraseQuery("name", "吐司"))
				.withPageable(PageRequest.of(0, 20)).build();
		long nus = elasticsearchTemplate.count(searchQuery2);
		List<Commodity> list = elasticsearchTemplate.queryForList(searchQuery2,
				Commodity.class);

		System.out.println(list);
	}

	@Test
	public void ww() {
		// Criteria criteria = new Criteria("price").startsWith("1");
		CriteriaQuery criteria = new CriteriaQuery(new Criteria("price")
				.between(0, 16000).and(
						new Criteria("name").contains("面包").or(
								new Criteria("name").contains("吐司"))));

		List<Commodity> books = elasticsearchTemplate.queryForList(criteria,
				Commodity.class);
		//

		// 使用queryStringQuery完成单字符串查询
		// SearchQuery searchQuery = new
		// NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery(word)).withPageable(pageable).build();
		// return elasticsearchTemplate.queryForList(searchQuery, Post.class);

		System.out.println(books);
	}

	@Test
	public void fenye() {
		Pageable pageable = new PageRequest(0, 20,new Sort("skuId").by("asc"));
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.queryStringQuery("面包"))
				.withPageable(pageable).build();
		Page<Commodity> list = elasticsearchTemplate.queryForPage(searchQuery,
				Commodity.class);
		// elasticsearchTemplate.deleteIndex("");
		System.out.println("ssa:" + list);
	}

}