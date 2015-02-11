package com.lyt.member.entity;

import java.sql.Timestamp;

/**
 * LytMonth entity. @author MyEclipse Persistence Tools
 */

public class LytMonth implements java.io.Serializable {

	// Fields

	private String id;
	private String tjrCardId;
	private Timestamp tjTime;
	private Integer tjRenshu;
	private Integer fanliState;
	private Double fanLimoney;
	private Timestamp fanliTime;
	private String tjrName;
	
	
	// Constructors

	/** default constructor */
	public LytMonth() {
	}

	/** full constructor */
	public LytMonth(String tjrCardId, Timestamp tjTime, Integer tjRenshu,
			Integer fanliState, Double fanLimoney, Timestamp fanliTime,String tjrName) {
		this.tjrCardId = tjrCardId;
		this.tjTime = tjTime;
		this.tjRenshu = tjRenshu;
		this.fanliState = fanliState;
		this.fanLimoney = fanLimoney;
		this.fanliTime = fanliTime;
		this.tjrName=tjrName;
	}
	/** full constructor */
	public LytMonth(String tjrCardId, Timestamp tjTime, Integer tjRenshu,
			Integer fanliState, Double fanLimoney, Timestamp fanliTime) {
		this.tjrCardId = tjrCardId;
		this.tjTime = tjTime;
		this.tjRenshu = tjRenshu;
		this.fanliState = fanliState;
		this.fanLimoney = fanLimoney;
		this.fanliTime = fanliTime;
	}
	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getTjrName() {
		return tjrName;
	}

	public void setTjrName(String tjrName) {
		this.tjrName = tjrName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTjrCardId() {
		return this.tjrCardId;
	}

	public void setTjrCardId(String tjrCardId) {
		this.tjrCardId = tjrCardId;
	}

	public Timestamp getTjTime() {
		return this.tjTime;
	}

	public void setTjTime(Timestamp tjTime) {
		this.tjTime = tjTime;
	}

	public Integer getTjRenshu() {
		return this.tjRenshu;
	}

	public void setTjRenshu(Integer tjRenshu) {
		this.tjRenshu = tjRenshu;
	}

	public Integer getFanliState() {
		return this.fanliState;
	}

	public void setFanliState(Integer fanliState) {
		this.fanliState = fanliState;
	}

	public Double getFanLimoney() {
		return this.fanLimoney;
	}

	public void setFanLimoney(Double fanLimoney) {
		this.fanLimoney = fanLimoney;
	}

	public Timestamp getFanliTime() {
		return this.fanliTime;
	}

	public void setFanliTime(Timestamp fanliTime) {
		this.fanliTime = fanliTime;
	}

}