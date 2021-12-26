package com.zy.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.demo.domain.Ebook;
import com.zy.demo.domain.EbookExample;
import com.zy.demo.mapper.EbookMapper;
import com.zy.demo.req.EbookQueryReq;
import com.zy.demo.req.EbookSaveReq;
import com.zy.demo.resp.EbookQueryResp;
import com.zy.demo.resp.PageResp;
import com.zy.demo.util.CopyUtil;
import com.zy.demo.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;

    @Autowired
    private SnowFlake snowFlake;

    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");

        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> ebookPageInfo = new PageInfo<>(ebookList);

        List<EbookQueryResp> ebookQueryResps = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        PageResp<EbookQueryResp> resp = new PageResp<>();
        resp.setList(ebookQueryResps);
        resp.setTotal((int) ebookPageInfo.getTotal());

//        List<EbookQueryResp> EbookQueryRespList = new ArrayList<>();
//
//        for (Ebook ebook:ebookList) {
//            EbookQueryResp ebookQueryResp = new EbookQueryResp();
//            BeanUtils.copyProperties(ebook, ebookQueryResp);
//            EbookQueryRespList.add(ebookQueryResp);
//        }
        return resp;
    }

    public int save(EbookSaveReq req){
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        int res = 0;
        if (ObjectUtils.isEmpty(req.getId())){
            // save new data
            ebook.setId(snowFlake.nextId());
            res = ebookMapper.insert(ebook);
        }else {
            // update
            res = ebookMapper.updateByPrimaryKey(ebook);
        }
        return res;
    }

    public int delete(long id){
        return ebookMapper.deleteByPrimaryKey(id);

    }

}
