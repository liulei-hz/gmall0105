package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liulei
 * @date 2020-06-19-21:10
 */
public interface AttrInfoService {
    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();

    List<PmsBaseAttrInfo> getAtrrValueListByValueId(String valueIdStr);
}
