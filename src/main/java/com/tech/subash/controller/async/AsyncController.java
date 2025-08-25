package com.tech.subash.controller.async;

import com.tech.subash.async.WaitService;
import com.tech.subash.components.AppProperties;
import com.tech.subash.controller.BaseController;
import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.response.CommonResponse;
import com.tech.subash.service.CriteriaService;
import com.tech.subash.utils.CacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/async")
@Slf4j
public class AsyncController extends BaseController {

    @Autowired
    private WaitService waitService;

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private CriteriaService criteriaService;

    @Autowired
    private CacheUtil cacheUtil;

    @GetMapping("/get")
    public ResponseEntity<?> getAsync() {
        System.out.println(appProperties.getName());
        System.out.println(appProperties.getSecurity().getRole());
        System.out.println(appProperties.getSecurity().isEnabled());
        waitService.waitIn20Seconds();

        String returnObject = "subash.pernandas";
        CommonResponse commonResponse = successResponse("success", "basic-codes", "Async Controller", "S-001", returnObject);
        return ResponseEntity.ok().body(commonResponse);
    }

    @GetMapping("/get/{id}")
    public UrbanEntity fetchurban(@PathVariable("id") long id) {
        log.info("get call");
       return cacheUtil.getLanguageCodeUsingAppId(id);
    }
}
