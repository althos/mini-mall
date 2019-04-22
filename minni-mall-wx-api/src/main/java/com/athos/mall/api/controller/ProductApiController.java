package com.athos.mall.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.shop.domain.Banner;
import com.athos.mall.shop.domain.Category;
import com.athos.mall.shop.domain.Product;
import com.athos.mall.shop.service.IBannerService;
import com.athos.mall.shop.service.ICategoryService;
import com.athos.mall.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pro/*")
public class ProductApiController {    
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IBannerService bannerService;

	@Autowired
	private ICategoryService categoryService;

    @RequestMapping("list")
    public AjaxResult list() {
    	List<JSONObject> data=new ArrayList<JSONObject>();
    	Product p =new Product();
    	p.setStatus(1);
    	p.setRecommend(1);
    	List<Product> list = productService.selectProductList(p);
    	list.forEach(i->{
    		JSONObject obj=new JSONObject();
    		obj.put("id", i.getId());
    		obj.put("title", i.getTitle());
    		obj.put("newprice", i.getNewprice());
    		obj.put("oldprice", i.getOldprice());
    		obj.put("logo", i.getImg());
    		data.add(obj);
    	});
        return AjaxResult.success().put("data", data);
    }
    


    @RequestMapping("details")
    public AjaxResult details(int id) {
    	if(id==0){
    		 return AjaxResult.error("参数为空");
    	}
    	Product i = productService.selectProductById(id);
    	JSONObject obj=new JSONObject();
    	if(i!=null){
        	obj.put("title", i.getTitle());
    		obj.put("newprice", i.getNewprice());
    		obj.put("oldprice", i.getOldprice());
    		obj.put("details", i.getDetails().replaceAll("\"","\'"));
    		obj.put("logo", i.getImg());
    	}
    

        return AjaxResult.success().put("product", obj);
    }
    
    

    @RequestMapping("banner")
    public AjaxResult banner() {
    	List<JSONObject> data=new ArrayList<JSONObject>();
		Banner banner=new Banner();
		banner.setType(1);
    	List<Banner> list = bannerService.selectBannerList(banner);
    	list.forEach(i->{
    		JSONObject obj=new JSONObject();
    		obj.put("name", i.getName());
    		obj.put("img", i.getImg());
    		obj.put("pid", i.getPid());
    		data.add(obj);
    	});
        return AjaxResult.success().put("data", data);
    }


	@RequestMapping("bannerType")
	public AjaxResult bannerType(int type) {
		List<JSONObject> data=new ArrayList<JSONObject>();
		Banner banner=new Banner();
		banner.setType(type);
		List<Banner> list = bannerService.selectBannerList(banner);
		list.forEach(i->{
			JSONObject obj=new JSONObject();
			obj.put("name", i.getName());
			obj.put("img", i.getImg());
			obj.put("pid", i.getPid());
			data.add(obj);
		});
		return AjaxResult.success().put("data", data);
	}

	/**
	 * 分类页商品展示
	 * @return
	 */
	@RequestMapping("categoryList")
	public AjaxResult categoryList() {
		List<JSONObject> data=new ArrayList<JSONObject>();
		List<Category> list = categoryService.selectCategoryList(null);
		list.forEach(i->{
			JSONObject cate=new JSONObject();
			cate.put("name",i.getName());
			cate.put("id",i.getId());
			cate.put("proList",getcategorProList(i.getId()));
			data.add(cate);
		});
		return AjaxResult.success().put("data", data);
	}

	public  List<JSONObject> getcategorProList(int cid){
		List<JSONObject> proList=new ArrayList<JSONObject>();
		Product p =new Product();
		p.setStatus(1);
		p.setCid(cid);
		List<Product> list = productService.selectProductList(p);
		list.forEach(i->{
			JSONObject obj=new JSONObject();
			obj.put("id", i.getId());
			obj.put("title", i.getTitle());
			obj.put("newprice", i.getNewprice());
			obj.put("oldprice", i.getOldprice());
			obj.put("logo", i.getImg());
			proList.add(obj);
		});
		return  proList;
	}

}
