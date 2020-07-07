package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.service.AttrValueService;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.service.AttrInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liulei
 * @date 2020-06-19-20:59
 */
@Controller
@CrossOrigin
public class AttrController {
    @Reference
    AttrInfoService attrInfoService;
    @Reference
    AttrValueService attrValueService;

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseAttrInfos = attrInfoService.baseSaleAttrList();
        return pmsBaseAttrInfos;
    }

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrInfoService.getAttrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String bool = attrInfoService.saveAttrInfo(pmsBaseAttrInfo);
        return bool;
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        List<PmsBaseAttrValue> pmsBaseAttrValues = attrValueService.getAttrValueListByAttrId(attrId);
        return pmsBaseAttrValues;
    }

    @RequestMapping("deleteAttrValueByName")
    @ResponseBody
    public String deleteAttrValueByName(String valueName) {
        String bool = attrValueService.deleteAtrrValueByname(valueName);
        return bool;
    }
}
