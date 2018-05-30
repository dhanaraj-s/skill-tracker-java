/**
 * 
 */
package com.skilltracker.vo;

/**
 * @author Admin
 *
 */
public class SkillVO {
	
	private Integer skillId;
	
	private String skillName;
	
	private Integer skillRate;

	public Integer getSkillRate() {
		return skillRate;
	}

	public void setSkillRate(Integer skillRate) {
		this.skillRate = skillRate;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
