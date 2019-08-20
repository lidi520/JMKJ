
package com.cn.jm.controller.base.system;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import com.cn._gen.model.Content;
import com.cn.jm._dao.content.JMContentDao;
import com.cn.jm.core.JMConsts;
import com.cn.jm.web.core.router.JMRouterMapping;
import com.cn.jm.core.tool.JMToolString;
import com.cn.jm.core.utils.util.JMResult;
import com.cn.jm.core.utils.util.JMUploadKit;
import com.cn.jm.core.web.controller.JMBaseSystemController;
import com.cn.jm.core.web.dao.JMBaseDao;
import com.cn.jm.interceptor.SystemLoginInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by 广州小跑robot.
 */
@JMRouterMapping(url = SystemContentController.url)
public class SystemContentController extends JMBaseSystemController {
	
	public static final String path = JMConsts.base_view_url+"/system/base/content";
	public static final String url ="/system/content";
	
	@Inject
	public JMContentDao contentDao;

	@Before(value={SystemLoginInterceptor.class})
	public void index(){
		page();
	}
	
	@Before(value={SystemLoginInterceptor.class})
	public void page2(){
		String keyword = getPara("keyword","");
		Integer id = getParaToInt("id");
		Integer type = getParaToInt("type",1);
		
		String startTime = getPara("startTime","");
		String endTime = getPara("endTime","");
		
		Integer pageNumber = getParaToInt(0, 1);
		Integer pageSize = JMConsts.pageSize;
		
		HashMap<String, Object> andpm = new HashMap<String, Object>();
		HashMap<String, Object> likepm = new HashMap<String, Object>();
		HashMap<String, Object> orpm = new HashMap<String, Object>();
		
		if (JMToolString.isNotEmpty(keyword)) {
			likepm.put("name", keyword);
		}
		if (id != null) {
			andpm.put("id", id);
		}
		andpm.put("type", type);
		Page<Content> page = null;
		
		if (JMToolString.isNotEmpty(startTime) && JMToolString.isNotEmpty(endTime)) {
			page = contentDao.page(pageNumber, pageSize, "", andpm, orpm, likepm, startTime,endTime,"id", JMBaseDao.DESC, true);
		}else {
			page = contentDao.page(pageNumber, pageSize, "", andpm, orpm, likepm, "id", JMBaseDao.DESC, true);
		}
		
		setAttr("id", id);
		setAttr("keyword", keyword);
		setAttr("startTime", startTime);
		setAttr("endTime", endTime);
		setAttr("type",type);
		setAttr("page", page);
		
		jump();
		render(path+"/page.html");
	}
	
	@Before(value={SystemLoginInterceptor.class})
	public void page(){
		String keyword = getPara("keyword","");
		Integer id = getParaToInt("id");
		
		String startTime = getPara("startTime","");
		String endTime = getPara("endTime","");
		
		Integer pageNumber = getParaToInt(0, 1);
		Integer pageSize = JMConsts.pageSize;
		
		HashMap<String, Object> andpm = new HashMap<String, Object>();
		HashMap<String, Object> likepm = new HashMap<String, Object>();
		HashMap<String, Object> orpm = new HashMap<String, Object>();
		
		if (JMToolString.isNotEmpty(keyword)) {
			likepm.put("name", keyword);
		}
		if (id != null) {
			andpm.put("id", id);
		}
		Page<Content> page = null;
		
		if (JMToolString.isNotEmpty(startTime) && JMToolString.isNotEmpty(endTime)) {
			page = contentDao.page(pageNumber, pageSize, "", andpm, orpm, likepm, startTime,endTime,"id", JMBaseDao.DESC, true);
		}else {
			page = contentDao.page(pageNumber, pageSize, "", andpm, orpm, likepm, "id", JMBaseDao.DESC, true);
		}
		
		setAttr("id", id);
		setAttr("keyword", keyword);
		setAttr("startTime", startTime);
		setAttr("endTime", endTime);
		setAttr("page", page);
		
		jump();
		render(path+"/page.html");
	}
	
	@Before(value={SystemLoginInterceptor.class})
	public void add(){
		setToken();
		
		setAttr("action", JMConsts.ACTION_ADD);
		setAttr("content", new Content());
		render(path+"/add.html");
	}

	
	public void save(){
		if(isRepeatSubmit()){
			JMResult.fail(this, "不允许重复提交");
			return;
		}
		
		Content content = getModel(Content.class);
		content.setCreateTime(new Date());
		if (contentDao.save(content)) {
			JMResult.success(this, "创建成功");
		}else {
			JMResult.fail(this, "创建失败");
		}
	}
	
	@Before(value={SystemLoginInterceptor.class})
	public void edit(){
		setToken();
		int id = getParaToInt("id");
		Content content = contentDao.getById(id,false);
		setAttr("content",content);
		render(path+"/edit.html");
	}

	
	public void update(){
		if(isRepeatSubmit()){
			JMResult.fail(this, "不允许重复提交");
			return;
		}
		
		Content content = getModel(Content.class);
		if (contentDao.update(content)) {
			JMResult.success(this, "修改成功");
		}else {
			JMResult.fail(this, "修改失败");
		}
	}
	
	
	public void upload() {
		File file = JMUploadKit.uploadAvatar(this, "file");
		HashMap<String, Object> data = new HashMap<>();
		data.put("name", file.getName());
		data.put("file",JMUploadKit.uploadPath+ JMUploadKit.uploadImg+file.getName());
		data.put("localFile", file.getAbsolutePath());
		JMResult.success(this, data,"上传成功");
	}

	
	public void delete(){
		int id = getParaToInt("id");
		
		if (contentDao.deleteById(id)) {
			JMResult.success(this, "删除成功");
		}else {
			JMResult.fail(this, "删除失败");
		}
	}
	
	
	public void dels(){
		Integer[] ids = getParaValuesToInt("ids");
		if(ids != null){
			boolean result = contentDao.deleteByIds(ids);
			if (result) {
				JMResult.success(this, "删除成功");
			}else {
				JMResult.fail(this, "删除失败");
			}
		}else {
			JMResult.fail(this, "请选择需要删除的数据");
		}
	}

}