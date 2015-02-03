package com.lyt.member.entity;

import java.sql.Timestamp;

/**
 * LytFanli entity. @author MyEclipse Persistence Tools
 */

public class LytFanli implements java.io.Serializable {

	// Fields

	private String id;
	private LytHuiyuan lytHuiyuanByBtjrId;
	private LytHuiyuan lytHuiyuanByTjrId;
	private Timestamp tjTime;
	private Integer fanliState;
	private Timestamp fanliTime;

	// Constructors

	/** default constructor */
	public LytFanli() {
	}

	/** full constructor */
	public LytFanli(LytHuiyuan lytHuiyuanByBtjrId,
			LytHuiyuan lytHuiyuanByTjrId, Timestamp tjTime, Integer fanliState,
			Timestamp fanliTime) {
		this.lytHuiyuanByBtjrId = lytHuiyuanByBtjrId;
		this.lytHuiyuanByTjrId = lytHuiyuanByTjrId;
		this.tjTime = tjTime;
		this.fanliState = fanliState;
		this.fanliTime = fanliTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LytHuiyuan getLytHuiyuanByBtjrId() {
		return this.lytHuiyuanByBtjrId;
	}

	public void setLytHuiyuanByBtjrId(LytHuiyuan lytHuiyuanByBtjrId) {
		this.lytHuiyuanByBtjrId = lytHuiyuanByBtjrId;
	}

	public LytHuiyuan getLytHuiyuanByTjrId() {
		return this.lytHuiyuanByTjrId;
	}

	public void setLytHuiyuanByTjrId(LytHuiyuan lytHuiyuanByTjrId) {
		this.lytHuiyuanByTjrId = lytHuiyuanByTjrId;
	}

	public Timestamp getTjTime() {
		return this.tjTime;
	}

	public void setTjTime(Timestamp tjTime) {
		this.tjTime = tjTime;
	}

	public Integer getFanliState() {
		return this.fanliState;
	}

	public void setFanliState(Integer fanliState) {
		this.fanliState = fanliState;
	}

	public Timestamp getFanliTime() {
		return this.fanliTime;
	}

	public void setFanliTime(Timestamp fanliTime) {
		this.fanliTime = fanliTime;
	}

}