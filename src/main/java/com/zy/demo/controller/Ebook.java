package com.zy.demo.controller;

import com.zy.demo.req.EbookQueryReq;
import com.zy.demo.req.EbookSaveReq;
import com.zy.demo.resp.CommonResp;
import com.zy.demo.resp.EbookQueryResp;
import com.zy.demo.resp.PageResp;
import com.zy.demo.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ebook")
public class Ebook {
    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp<PageResp<EbookQueryResp>> list(@Validated EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        resp.setContent(ebookService.list(req));
        return resp;
    }

    @PostMapping("/save")
    public CommonResp<Object> save(EbookSaveReq req){
        CommonResp<Object> resp = new CommonResp<>();
        boolean save = ebookService.save(req) > 0;
        resp.setSuccess(save);
        return resp;
    }

    @PostMapping("/delete/{id}")
    public CommonResp<Object> list(@PathVariable long id){
        CommonResp<Object> resp = new CommonResp<>();
        boolean del = ebookService.delete(id) > 0;
        resp.setSuccess(del);
        return resp;
    }
}
