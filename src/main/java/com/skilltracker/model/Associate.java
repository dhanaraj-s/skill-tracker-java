/**
 * 
 */
package com.skilltracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author Admin
 *
 *
 */
@Entity
@Table(name = "associate")
public class Associate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3605404322214436368L;
	
	@Id
	@Column(name = "associate_id")
	private Integer associateId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Lob
	@Column(name = "pic")
	private byte[] pic;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "status_green")
	private String statusGreen;
	
	@Column(name = "status_blue")
	private String statusBlue;
	
	@Column(name = "status_red")
	private String statusRed;
	
	@Column(name = "level_1")
	private String level1;
	
	@Column(name = "level_2")
	private String level2;
	
	@Column(name = "level_3")
	private String level3;
	
	@Column(name = "remark")
	private String remark;

	@Column(name = "spoken")
	private Integer spoken;
	
	@Column(name = "communication")
	private Integer communication;
	
	@Column(name = "logic")
	private Integer logic;
	
	@Column(name = "aptitude")
	private Integer aptitude;
	
	@Column(name = "confidence")
	private Integer confidence;
	
	@Column(name = "other")
	private String other;
	
	@Column(name = "strength")
	private String strength;
	
	@Column(name = "weakness")
	private String weakness;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getSpoken() {
		return spoken;
	}

	public void setSpoken(Integer spoken) {
		this.spoken = spoken;
	}

	public Integer getCommunication() {
		return communication;
	}

	public void setCommunication(Integer communication) {
		this.communication = communication;
	}

	public Integer getLogic() {
		return logic;
	}

	public void setLogic(Integer logic) {
		this.logic = logic;
	}

	public Integer getAptitude() {
		return aptitude;
	}

	public void setAptitude(Integer aptitude) {
		this.aptitude = aptitude;
	}

	public Integer getConfidence() {
		return confidence;
	}

	public void setConfidence(Integer confidence) {
		this.confidence = confidence;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Integer getAssociateId() {
		return associateId;
	}

	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatusGreen() {
		return statusGreen;
	}

	public void setStatusGreen(String statusGreen) {
		this.statusGreen = statusGreen;
	}

	public String getStatusBlue() {
		return statusBlue;
	}

	public void setStatusBlue(String statusBlue) {
		this.statusBlue = statusBlue;
	}

	public String getStatusRed() {
		return statusRed;
	}

	public void setStatusRed(String statusRed) {
		this.statusRed = statusRed;
	}

	public String getLevel1() {
		return level1;
	}

	public void setLevel1(String level1) {
		this.level1 = level1;
	}

	public String getLevel2() {
		return level2;
	}

	public void setLevel2(String level2) {
		this.level2 = level2;
	}

	public String getLevel3() {
		return level3;
	}

	public void setLevel3(String level3) {
		this.level3 = level3;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

}
