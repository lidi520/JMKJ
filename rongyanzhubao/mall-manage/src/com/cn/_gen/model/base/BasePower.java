
package com.cn._gen.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 小跑科技robot.
 */
@SuppressWarnings("serial")
public abstract class BasePower<M extends BasePower<M>> extends Model<M> implements IBean {

		public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setSort(java.lang.Integer sort) {
		set("sort", sort);
	}

	public java.lang.Integer getSort() {
		return get("sort");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setMenuId(java.lang.Integer menuId) {
		set("menuId", menuId);
	}

	public java.lang.Integer getMenuId() {
		return get("menuId");
	}

	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	public java.lang.String getUrl() {
		return get("url");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("createTime");
	}



}