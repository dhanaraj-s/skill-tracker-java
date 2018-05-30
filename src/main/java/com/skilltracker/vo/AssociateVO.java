/**
 * 
 */
package com.skilltracker.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 *
 */
public class AssociateVO {
	
	private Integer associateId;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String gender;
	
	private String statusGreen;
	
	private String statusBlue;
	
	private String statusRed;
	
	private String level1;
	
	private String level2;
	
	private String level3;
	
	private String remark;
	
	private String strength;
	
	private String weakness;
	
	private List<SkillVO> skills;
	
	private Integer spoken;
	
	private Integer communication;
	
	private Integer logic;
	
	private Integer aptitude;
	
	private Integer confidence;
	
	private String other;
		
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<SkillVO> getSkills() {
		if (skills == null) {
			skills = new ArrayList<SkillVO>();
		}
		return skills;
	}

	public void setSkills(List<SkillVO> skills) {
		this.skills = skills;
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
	
	@Override
	public String toString() {
		return "AssociateVO [associateId=" + associateId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", statusGreen=" + statusGreen + ", statusBlue=" + statusBlue + ", statusRed=" + statusRed
				+ ", level1=" + level1 + ", level2=" + level2 + ", level3=" + level3 + ", remark=" + remark
				+ ", strength=" + strength + ", weakness=" + weakness + ", skills=" + skills + ", spoken=" + spoken
				+ ", communication=" + communication + ", logic=" + logic + ", aptitude=" + aptitude + ", confidence="
				+ confidence + ", other=" + other + "]";
	}

}
