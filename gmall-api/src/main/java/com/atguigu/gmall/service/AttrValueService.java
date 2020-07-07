package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @author liulei
 * @date 2020-06-19-23:12
 */
public interface AttrValueService {
    List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId);

    String deleteAtrrValueByname(String valueName);

}
