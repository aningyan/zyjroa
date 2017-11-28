package com.zyjr.zyjroa.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
public class CompanyLevel extends Model<CompanyLevel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 级别id
     */
	private String levelid;
    /**
     * 级别秒速
     */
	private String leveltext;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLevelid() {
		return levelid;
	}
	public void setLevelid(String levelid) {
		this.levelid = levelid;
	}
	public String getLeveltext() {
		return leveltext;
	}
	public void setLeveltext(String leveltext) {
		this.leveltext = leveltext;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Dict [id=" + id + ", levelid=" + levelid + ", leveltext=" + leveltext + "]";
	}
	@Override
	protected Serializable pkVal() {
		return null;
	}
	
	
}
