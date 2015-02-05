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
	private Set<LytFanli> lytFanlisForTjrId = new HashSet<LytFanli>();
	private Set<LytFanli> lytFanlisForBtjrId = new HashSet<LytFanli>();
	
	public LytHuiyuan() {
		// TODO Auto-generated constructor stub
	}
	public LytHuiyuan(String id, String hyname, String hyLevel,
			String hycardId, String phoneNumber, String identifyId,
			String bankcardNumber, Double hyFee, Double inforFee,
			Double totalMoney, String tjrId, String skrName,
			String shouhuoAddress, Integer hyState, Timestamp applyTime,
			String beizhu, Set<LytFanli> lytFanlisForTjrId,
			Set<LytFanli> lytFanlisForBtjrId) {
		this.id = id;
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
		this.beizhu = beizhu;
		this.lytFanlisForTjrId = lytFanlisForTjrId;
		this.lytFanlisForBtjrId = lytFanlisForBtjrId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHyname() {
		return hyname;
	}
	public void setHyname(String hyname) {
		this.hyname = hyname;
	}
	public String getHyLevel() {
		return hyLevel;
	}
	public void setHyLevel(String hyLevel) {
		this.hyLevel = hyLevel;
	}
	public String getHycardId() {
		return hycardId;
	}
	public void setHycardId(String hycardId) {
		this.hycardId = hycardId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIdentifyId() {
		return identifyId;
	}
	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}
	public String getBankcardNumber() {
		return bankcardNumber;
	}
	public void setBankcardNumber(String bankcardNumber) {
		this.bankcardNumber = bankcardNumber;
	}
	public Double getHyFee() {
		return hyFee;
	}
	public void setHyFee(Double hyFee) {
		this.hyFee = hyFee;
	}
	public Double getInforFee() {
		return inforFee;
	}
	public void setInforFee(Double inforFee) {
		this.inforFee = inforFee;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getTjrId() {
		return tjrId;
	}
	public void setTjrId(String tjrId) {
		this.tjrId = tjrId;
	}
	public String getSkrName() {
		return skrName;
	}
	public void setSkrName(String skrName) {
		this.skrName = skrName;
	}
	public String getShouhuoAddress() {
		return shouhuoAddress;
	}
	public void setShouhuoAddress(String shouhuoAddress) {
		this.shouhuoAddress = shouhuoAddress;
	}
	public Integer getHyState() {
		return hyState;
	}
	public void setHyState(Integer hyState) {
		this.hyState = hyState;
	}
	public Timestamp getApplyTime() {
		return applyTime;
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
	public Set<LytFanli> getLytFanlisForTjrId() {
		return lytFanlisForTjrId;
	}
	public void setLytFanlisForTjrId(Set<LytFanli> lytFanlisForTjrId) {
		this.lytFanlisForTjrId = lytFanlisForTjrId;
	}
	public Set<LytFanli> getLytFanlisForBtjrId() {
		return lytFanlisForBtjrId;
	}
	public void setLytFanlisForBtjrId(Set<LytFanli> lytFanlisForBtjrId) {
		this.lytFanlisForBtjrId = lytFanlisForBtjrId;
	}
	
	

	// Constructors



}