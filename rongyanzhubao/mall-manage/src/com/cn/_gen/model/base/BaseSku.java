
package com.cn._gen.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 小跑科技robot.
 */
@SuppressWarnings("serial")
public abstract class BaseSku<M extends BaseSku<M>> extends Model<M> implements IBean {

		public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setGoodsId(java.lang.Integer goodsId) {
		set("goodsId", goodsId);
	}

	public java.lang.Integer getGoodsId() {
		return get("goodsId");
	}

	public void setPrice(java.math.BigDecimal price) {
		set("price", price);
	}

	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	public void setOldPrice(java.math.BigDecimal oldPrice) {
		set("oldPrice", oldPrice);
	}

	public java.math.BigDecimal getOldPrice() {
		return get("oldPrice");
	}

	public void setStock(java.lang.Integer stock) {
		set("stock", stock);
	}

	public java.lang.Integer getStock() {
		return get("stock");
	}

	public void setSkuCode(java.lang.String skuCode) {
		set("skuCode", skuCode);
	}

	public java.lang.String getSkuCode() {
		return get("skuCode");
	}

	public void setImage(java.lang.String image) {
		set("image", image);
	}

	public java.lang.String getImage() {
		return get("image");
	}

	public void setState(java.lang.Integer state) {
		set("state", state);
	}

	public java.lang.Integer getState() {
		return get("state");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}



}