/**
 * 
 */
package com.skilltracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */

@Entity
@Table(name = "associate_skills")
public class AssociateSkills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6256989261850070128L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer associateSkillId;
	
	@Column(name = "associate_id", insertable = false, updatable = false)
	private Integer associateId;
	
	@Column(name = "skill_id", insertable = false, updatable = false)
	private Integer skillId;
	
	@OneToOne
	@JoinColumn(name="associate_id") 
	private Associate associate;
	
	@OneToOne
	@JoinColumn(name="skill_id") 
	private Skills skills;
	
	@Column(name = "skill_rate")
	private Integer skillRate;

	public Integer getSkillRate() {
		return skillRate;
	}

	public void setSkillRate(Integer skillRate) {
		this.skillRate = skillRate;
	}

	public Integer getAssociateSkillId() {
		return associateSkillId;
	}

	public void setAssociateSkillId(Integer associateSkillId) {
		this.associateSkillId = associateSkillId;
	}

	public Integer getAssociateId() {
		return associateId;
	}

	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Associate getAssociate() {
		return associate;
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

}
