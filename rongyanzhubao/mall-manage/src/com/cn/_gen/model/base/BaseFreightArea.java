
package com.cn._gen.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 小跑科技robot.
 */
@SuppressWarnings("serial")
public abstract class BaseFreightArea<M extends BaseFreightArea<M>> extends Model<M> implements IBean {

		public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setFreightId(java.lang.Integer freightId) {
		set("freightId", freightId);
	}

	public java.lang.Integer getFreightId() {
		return get("freightId");
	}

	public void setAreaId(java.lang.Integer areaId) {
		set("areaId", areaId);
	}

	public java.lang.Integer getAreaId() {
		return get("areaId");
	}



}