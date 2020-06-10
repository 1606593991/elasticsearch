package com.wyb.Controller;

import com.wyb.model.Commodity;
import com.wyb.service.CommodityService;
import io.swagger.annotations.Api;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"test"}, hidden = false)
public class Test {

  @Autowired
  private CommodityService commodityService;




  @GetMapping("/save")
  public void testInsert() {
    Commodity commodity = new Commodity();
    commodity.setSkuId("1501009001");
    commodity.setName("原味切片面包（10片装）");
    commodity.setCategory("101");
    commodity.setPrice(880);
    commodity.setBrand("良品铺子");
    commodityService.save(commodity);

    commodity = new Commodity();
    commodity.setSkuId("1501009002");
    commodity.setName("原味切片面包（6片装）");
    commodity.setCategory("101");
    commodity.setPrice(680);
    commodity.setBrand("良品铺子");
    commodityService.save(commodity);

    commodity = new Commodity();
    commodity.setSkuId("1501009004");
    commodity.setName("元气吐司850g");
    commodity.setCategory("101");
    commodity.setPrice(120);
    commodity.setBrand("百草味");
    commodityService.save(commodity);

  }

  @GetMapping("/del")
  @ResponseBody
  public void testDelete() {
    Commodity commodity = new Commodity();
    commodity.setSkuId("1501009002");
    commodityService.delete(commodity);
  }

  @GetMapping("/testGetAll")
  @ResponseBody
  public Iterable<Commodity> testGetAll() {
    Iterable<Commodity> iterable = commodityService.getAll();
    iterable.forEach(e -> System.out.println(e.toString()));
    return iterable;
  }

  @GetMapping("/testGetByName")
  public List<Commodity> testGetByName() {
    List<Commodity> list = commodityService.getByName("面包");
    System.out.println(list);
    return list;
  }

  @GetMapping("/testPage")
  @ResponseBody
  public Page<Commodity> testPage() {
    Page<Commodity> page = commodityService.pageQuery(0, 10, "切片");
    System.out.println(page.getTotalPages());
    System.out.println(page.getNumber());
    System.out.println(page.getContent());
    return page;
  }


}
