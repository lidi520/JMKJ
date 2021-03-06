
package com.cn.jm.service;

import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

import com.cn._gen.model.Label;
import com.cn._gen.model.LabelRelation;
import com.cn.jm._dao.label.JMLabelDao;
import com.cn.jm._dao.label.JMLabelRelationDao;
import com.cn.jm._dao.label.LabelEnum;
/**
 * Generated by 小跑科技robot  .
 */
public class JMLabelService extends BasicsService<Label> {
	
	@Inject
	JMLabelDao labelDao;
	@Inject
	JMLabelRelationDao labelRelationDao;
	
	public Page<Label> page(Integer pageNumber, Integer pageSize,Integer id,String keyword,String startTime,String endTime){
		return labelDao.pageColumn(pageNumber,pageSize,id,keyword,startTime,endTime,false);
	}

	/**
	 * 获取所有栏目,包括下级
	 * @param type
	 * @return
	 */
	public List<Label> all(int type) {
		return labelDao.all(type);
	}
	/**
	 * 根据type搜索一级的所有信息
	 * @param type
	 * @return
	 */
	public List<Label> selectByType(int type) {
		return labelDao.one(type);
	}

	/**
	 * 更新商品栏目
	 * @param id
	 * @param columnId
	 * @return 
	 */
	public boolean updateShopColumn(Integer goodsId, Integer columnId) {
		LabelRelation labelRelation = labelRelationDao.getByIdsAndType(LabelEnum.SHOP_COLUMN_TYPE, goodsId);
		if(labelRelation == null) {
			labelRelation = new LabelRelation();
			labelRelation.setIds(goodsId);
			labelRelation.setLabelId(columnId);
			return labelRelation.save();
		}else {
			labelRelation.setLabelId(columnId);
			return labelRelation.update();
		}
	}
}