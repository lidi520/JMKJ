
package com.cn.jm._dao.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cn._gen.dao.ReportDao;
import com.cn._gen.model.Report;
import com.cn.jm.util.SqlUtil;
import com.cn.jm.util.sqltool.JMCommonDao;
import com.cn.jm.util.sqltool.Query;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;


/**
 * Generated by 广州小跑robot.
 */
public class JMReportDao extends ReportDao{
	private JMCommonDao commonDao = JMCommonDao.jmd;
	public static HashMap<Integer,String> typeMap = new HashMap<>();
	static {
		typeMap.put(0, "投诉主播");
		typeMap.put(1, "投诉客服");
		typeMap.put(2, "物流状况");
		typeMap.put(3, "优惠活动");
		typeMap.put(4, "功能异常");
		typeMap.put(5, "表扬");
		typeMap.put(6, "建议");
		typeMap.put(7, "其他");
	}
	
	public Page<Report> page(Integer pageNumber, Integer pageSize,Integer id,String keyword,String startTime,String endTime,boolean isCache){
		StringBuilder selectSql = new StringBuilder("SELECT id ");
		StringBuilder fromSql = new StringBuilder(" FROM ");
		fromSql.append(tableName);
		fromSql.append(" :WHERE ");
		SqlUtil.addWhere(fromSql," AND id = ",id);
		SqlUtil.addLike(fromSql," AND name","%",keyword,"%");
		SqlUtil.addBetweenTime(fromSql, startTime, endTime, " AND createTime");
		String strFromSql = fromSql.toString();
		String strSelectSql = selectSql.toString();
		return isCache?dao.paginateByCache(cacheName,HashKit.md5(selectSql.append(strFromSql).toString()), pageNumber, pageSize,false,strSelectSql, strFromSql)
			:dao.paginate(pageNumber, pageSize, false, strSelectSql,strFromSql);
	}
	
	
	
	public Page<Report> selectSystemPage(Integer pageNumber, Integer pageSize,String keyword, Integer type){
		String select = "select * ";
		String sqlExceptSelect = "from webcast_report where 1=1 ";
		List<Object> params = new ArrayList<>();
		if(type!=null) {
			sqlExceptSelect+= "and type = ? ";
			params.add(type);
		}
		if(StrKit.notBlank(keyword)) {
			sqlExceptSelect+="and (account like ? or targetAccount like ? or description like ?)";
			params.add("%"+keyword+"%");
			params.add("%"+keyword+"%");
			params.add("%"+keyword+"%");
		}
		sqlExceptSelect+="order by createTime desc";
		return Report.dao.paginate(pageNumber, pageSize, select, sqlExceptSelect,params.toArray());
		
	}
}
