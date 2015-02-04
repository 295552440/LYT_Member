package com.lyt.member.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * LytHuiyuan entity. @author MyEclipse Persistence Tools
 */

public class LytHuiyuan implements java.io.Serializable {

	// Fields

	private String id;
	private String hyname;
	private String hyLevel;
	private String hycardId;
	private String phoneNumber;
	private String identifyId;
	private String bankcardNumber;
	private Double hyFee;
	private Double inforFee;
	private Double totalMoney;
	private String tjrId;
	private String skrName;
	private String shouhuoAddress;
	private Integer hyState;
	private Timestamp applyTime;
	private String beizhu;
	private Set lytFanlisForTjrId = new HashSet(0);
	private Set lytFanlisForBtjrId = new HashSet(0);

	// Constructors

	/** default constructor */
	public LytHuiyuan() {
	}

	/** full constructor */
	public LytHuiyuan(String hyname, String hyLevel, String hycardId,
			String phoneNumber, String identifyId, String bankcardNumber,
			Double hyFee, Double inforFee, Double totalMoney, String tjrId,
			String skrName, String shouhuoAddress, Integer hyState,
			Timestamp applyTime, Set lytFanlisForTjrId, Set lytFanlisForBtjrId) {
		this.hyname = hyname;
		this.hyLevel = hyLevel;
		this.hycardId = hycardId;
		this.phoneNumber = phoneNumber;
		this.identifyId = identifyId;
		this.bankcardNumber = bankcardNumber;
		this.hyFee = hyFee;
		this.inforFee = inforFee;
		this.totalMoney = totalMoney;
		this.tjrId = tjrId;
		this.skrName = skrName;
		this.shouhuoAddress = shouhuoAddress;
		this.hyState = hyState;
		this.applyTime = applyTime;
		this.lytFanlisForTjrId = lytFanlisForTjrId;
		this.lytFanlisForBtjrId = lytFanlisForBtjrId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHyname() {
		return this.hyname;
	}

	public void setHyname(String hyname) {
		this.hyname = hyname;
	}

	public String getHyLevel() {
		return this.hyLevel;
	}

	public void setHyLevel(String hyLevel) {
		this.hyLevel = hyLevel;
	}

	public String getHycardId() {
		return this.hycardId;
	}

	public void setHycardId(String hycardId) {
		this.hycardId = hycardId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdentifyId() {
		return this.identifyId;
	}

	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}

	public String getBankcardNumber() {
		return this.bankcardNumber;
	}

	public void setBankcardNumber(String bankcardNumber) {
		this.bankcardNumber = bankcardNumber;
	}

	public Double getHyFee() {
		return this.hyFee;
	}

	public void setHyFee(Double hyFee) {
		this.hyFee = hyFee;
	}

	public Double getInforFee() {
		return this.inforFee;
	}

	public void setInforFee(Double inforFee) {
		this.inforFee = inforFee;
	}

	public Double getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getTjrId() {
		return this.tjrId;
	}

	public void setTjrId(String tjrId) {
		this.tjrId = tjrId;
	}

	public String getSkrName() {
		return this.skrName;
	}

	public void setSkrName(String skrName) {
		this.skrName = skrName;
	}

	public String getShouhuoAddress() {
		return this.shouhuoAddress;
	}

	public void setShouhuoAddress(String shouhuoAddress) {
		this.shouhuoAddress = shouhuoAddress;
	}

	public Integer getHyState() {
		return this.hyState;
	}

	public void setHyState(Integer hyState) {
		this.hyState = hyState;
	}

	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Set getLytFanlisForTjrId() {
		return this.lytFanlisForTjrId;
	}

	public void setLytFanlisForTjrId(Set lytFanlisForTjrId) {
		this.lytFanlisForTjrId = lytFanlisForTjrId;
	}

	public Set getLytFanlisForBtjrId() {
		return this.lytFanlisForBtjrId;
	}

	public void setLytFanlisForBtjrId(Set lytFanlisForBtjrId) {
		this.lytFanlisForBtjrId = lytFanlisForBtjrId;
	}

}