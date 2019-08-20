
package com.cn._gen.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 小跑科技robot.
 */
@SuppressWarnings("serial")
public abstract class BaseBankAccount<M extends BaseBankAccount<M>> extends Model<M> implements IBean {

		public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setAccountId(java.lang.Integer accountId) {
		set("accountId", accountId);
	}

	public java.lang.Integer getAccountId() {
		return get("accountId");
	}

	public void setBankNick(java.lang.String bankNick) {
		set("bankNick", bankNick);
	}

	public java.lang.String getBankNick() {
		return get("bankNick");
	}

	public void setBankName(java.lang.String bankName) {
		set("bankName", bankName);
	}

	public java.lang.String getBankName() {
		return get("bankName");
	}

	public void setBankAddress(java.lang.String bankAddress) {
		set("bankAddress", bankAddress);
	}

	public java.lang.String getBankAddress() {
		return get("bankAddress");
	}

	public void setBankAccount(java.lang.String bankAccount) {
		set("bankAccount", bankAccount);
	}

	public java.lang.String getBankAccount() {
		return get("bankAccount");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	public void setState(java.lang.Integer state) {
		set("state", state);
	}

	public java.lang.Integer getState() {
		return get("state");
	}



}