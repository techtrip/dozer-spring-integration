package com.techtrip.example.dozer.controllers;

import com.techtrip.example.dozer.model.NewFangledWidget;
import com.techtrip.example.dozer.model.OriginalWidget;
import com.techtrip.example.dozer.util.WidgetHolder;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    public static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    AtomicInteger atomicId = new AtomicInteger();

    @Autowired
    private DozerBeanMapperFactoryBean dozerBean;

    @Autowired
    public TestController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Autowired
    Map<Integer, WidgetHolder> widgetStore;

    private final RequestMappingHandlerMapping handlerMapping;

    @RequestMapping("/")
    public String testSetup() {
        return "This is a test";
    }

    @RequestMapping(value = "/showendpoints")
    public Map<String,String> show(Model model) {


        Map<String,String> response = new HashMap<>();

        Map rmap = this.handlerMapping.getHandlerMethods();

        for (Object o: rmap.keySet()) {
            response.put(o.toString(), rmap.get(o).toString());
        }

        return response;
    }


    // @RequestMapping(value = "/createwidget", method = POST)
    @PostMapping(value = "/createwidget", consumes = "application/json", produces = "application/json")
    public WidgetResponse createWidget(@RequestBody WidgetRequest body) throws Exception {

        OriginalWidget original = OriginalWidget.newBuilder().withId(atomicId.getAndIncrement()).withName(body.getName()).withCreationDate(Calendar.getInstance().getTime()).build();

        org.dozer.Mapper mapper = dozerBean.getObject();

        NewFangledWidget target = NewFangledWidget.newBuilder().build();

        mapper.map(original, target, "widget");

        WidgetHolder wh = WidgetHolder.newBuilder().withOriginal(original).withNewfangled(target).build();

        widgetStore.put(original.getId(), wh);

        return WidgetResponse.newBuilder()
                .withSourceClass(original.getClass().getSimpleName())
                .withName(original.getName())
                .withId(original.getId() + "")
                .withDate(original.getCreationDate().toString()).build();
    }

     /*
    @RequestMapping(
  value = "/ex/foos",
  headers = { "key1=val1", "key2=val2" }, method = GET)

  Test with
  curl -i -H "key:val" http://localhost:8080/spring-rest/ex/foos

  curl -H "Accept:application/json"
  http://localhost:8080/spring-rest/ex/foos

     */

    @RequestMapping(value = "/getwidget/{id}")
    public List<Object> getWidgetForId(@PathVariable int id) {
        List response = new ArrayList();

        WidgetHolder wh = widgetStore.get(id);

        if (wh != null) {
            response.add(wh.getOriginal());
            response.add(wh.getNewfangled());
        }

        return response;
    }

}
