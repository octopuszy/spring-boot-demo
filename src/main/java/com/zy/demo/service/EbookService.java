package com.zy.demo.service;

import com.zy.demo.domain.Ebook;
import com.zy.demo.domain.EbookExample;
import com.zy.demo.mapper.EbookMapper;
import com.zy.demo.req.EbookQueryReq;
import com.zy.demo.resp.EbookQueryResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;

    public List<EbookQueryResp> list(EbookQueryReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookQueryResp> EbookQueryRespList = new ArrayList<>();

        for (Ebook ebook:ebookList) {
            EbookQueryResp ebookQueryResp = new EbookQueryResp();
            BeanUtils.copyProperties(ebook, ebookQueryResp);
            EbookQueryRespList.add(ebookQueryResp);
        }
        return EbookQueryRespList;
    }

}
