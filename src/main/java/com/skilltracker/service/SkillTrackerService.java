/**
 * 
 */
package com.skilltracker.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.skilltracker.vo.AssociateVO;
import com.skilltracker.vo.SkillVO;

/**
 * @author Admin
 *
 */
public interface SkillTrackerService {

	List<SkillVO> viewAllSkills();

	List<SkillVO> addSkill(SkillVO skillVO);

	List<SkillVO> editSkill(SkillVO skillVO);

	List<SkillVO> deleteSkill(String skillId);

	List<AssociateVO> viewAllAssociates();

	String addAssociate(AssociateVO associateVO, MultipartFile file);

	byte[] getPic(int parseInt);

	List<AssociateVO> deleteAssociate(Integer associateId);

}
