package com.fxb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxb.bean.S_HuiFuLzl;
import com.fxb.mapper.TieziMapper;

@Service
public class LzlService {
     @Autowired
     TieziMapper mapper;
     
     //查询所有楼中楼回复
     public List<S_HuiFuLzl> LzlCx(Integer s_tid,Integer s_lid){
    	 List<S_HuiFuLzl> list = mapper.CxLzl(s_tid,s_lid);
    	 return list;
     }
     
     //用户楼中楼回复
     public Integer LzlHf(String s_ltext,Integer s_id,Integer s_tid,Integer s_lid,String s_date) {
    	 int result = mapper.LzlHuiF(s_ltext, s_id, s_tid, s_lid, s_date);
    	 return result;
     }
     
}
