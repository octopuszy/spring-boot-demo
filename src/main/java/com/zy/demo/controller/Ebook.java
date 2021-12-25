package com.zy.demo.controller;

import com.zy.demo.req.EbookQueryReq;
import com.zy.demo.resp.CommonResp;
import com.zy.demo.resp.EbookQueryResp;
import com.zy.demo.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class Ebook {
    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp<List<EbookQueryResp>> list(EbookQueryReq req){
        CommonResp<List<EbookQueryResp>> resp = new CommonResp<>();
        List<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
