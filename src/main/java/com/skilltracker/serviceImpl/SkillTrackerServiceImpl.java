/**
 * 
 */
package com.skilltracker.serviceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.skilltracker.model.Associate;
import com.skilltracker.model.AssociateSkills;
import com.skilltracker.model.Skills;
import com.skilltracker.repository.AssociateRepository;
import com.skilltracker.repository.AssociateSkillsRepository;
import com.skilltracker.repository.SkillsRepository;
import com.skilltracker.service.SkillTrackerService;
import com.skilltracker.vo.AssociateVO;
import com.skilltracker.vo.SkillVO;

/**
 * @author Admin
 *
 */
@Service("skillTrackerService")
public class SkillTrackerServiceImpl implements SkillTrackerService {
	
	@Autowired
	private AssociateRepository associateRepository;
	
	@Autowired
	private AssociateSkillsRepository associateSkillsRepository;
	
	@Autowired
	private SkillsRepository skillsRepository;

	@Override
	public List<SkillVO> viewAllSkills() {
		List<SkillVO> skillsList = new ArrayList<SkillVO>();
		List<Skills> skills = (List<Skills>) skillsRepository.findAll();
		if(skills != null && !skills.isEmpty()) {
			SkillVO skillVO;
			for (Skills skill: skills) {
				skillVO = new SkillVO();
				skillVO.setSkillId(skill.getSkillId());
				skillVO.setSkillName(skill.getSkillName());
				skillsList.add(skillVO);
			}
		}
		return skillsList;
	}

	@Override
	public List<SkillVO> addSkill(SkillVO skillVO) {
		Skills skill = new Skills();
		if (skillVO != null && !StringUtils.isEmpty(skillVO.getSkillName())) {
			skill.setSkillName(skillVO.getSkillName());
		}
		try {
			skillsRepository.save(skill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAllSkills();
	}

	@Override
	public List<SkillVO> editSkill(SkillVO skillVO) {
		Optional<Skills> skill = skillsRepository.findById(skillVO.getSkillId());
		if (skill.isPresent()) {
			skill.get().setSkillName(skillVO.getSkillName());
			skillsRepository.save(skill.get());
		}
		return viewAllSkills();
	}

	@Override
	public List<SkillVO> deleteSkill(String skillId) {
		try {
			skillsRepository.deleteById(Integer.parseInt(skillId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAllSkills();
	}

	@Override
	public List<AssociateVO> viewAllAssociates() {
		List<AssociateVO> associateVOList = new ArrayList<AssociateVO>();
		List<Associate> associateList = (List<Associate>) associateRepository.findAll();
		if(associateList != null && !associateList.isEmpty()) {
			for (Associate associate: associateList) {
				List<AssociateSkills> associateSkillList = (List<AssociateSkills>) 
						associateSkillsRepository.findByAssociateId(associate.getAssociateId());
				associateVOList.add(mapSkillsToAssociate(associate, associateSkillList));
			}
		}
		return associateVOList;
	}

	private AssociateVO mapSkillsToAssociate(Associate associate, List<AssociateSkills> associateSkillList) {
		AssociateVO associateVO = new AssociateVO();
		associateVO.setAssociateId(associate.getAssociateId());
		associateVO.setEmail(associate.getEmail());
		associateVO.setLevel1(associate.getLevel1());
		associateVO.setLevel2(associate.getLevel2());
		associateVO.setLevel3(associate.getLevel3());
		associateVO.setMobile(associate.getMobile());
		associateVO.setName(associate.getName());
		associateVO.setRemark(associate.getRemark());
		associateVO.setStatusBlue(associate.getStatusBlue());
		associateVO.setStatusGreen(associate.getStatusGreen());
		associateVO.setStatusRed(associate.getStatusRed());
		associateVO.setSpoken(associate.getSpoken());
		associateVO.setLogic(associate.getLogic());
		associateVO.setAptitude(associate.getAptitude());
		associateVO.setCommunication(associate.getCommunication());;
		associateVO.setConfidence(associate.getConfidence());
		associateVO.setOther(associate.getOther());
		associateVO.setStrength(associate.getStrength());
		associateVO.setWeakness(associate.getWeakness());
		associateVO.setGender(associate.getGender());
		if (associateSkillList != null && !associateSkillList.isEmpty()) {
			SkillVO skill;
			for (AssociateSkills associateSkills: associateSkillList) {
				skill = new SkillVO();
				skill.setSkillId(associateSkills.getSkills().getSkillId());
				skill.setSkillName(associateSkills.getSkills().getSkillName());
				skill.setSkillRate(associateSkills.getSkillRate());
				associateVO.getSkills().add(skill);
			}
		}
		return associateVO;
	}

	@Override
	public String addAssociate(AssociateVO associateVO, MultipartFile file) {
		Associate associate = new Associate();
		Optional<Associate> associateEntity = associateRepository.findById(associateVO.getAssociateId());
		if(associateEntity.isPresent()) {
			associate = associateEntity.get();
		}
		try {
			mapAssociate(associate, associateVO, file);
			mapAssociateSkills(associate, associateVO);			
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "success";
	}

	private void mapAssociateSkills(Associate associate, AssociateVO associateVO) {
		List<AssociateSkills> associateSkillsList = new ArrayList<AssociateSkills>();
		AssociateSkills associateSkills;
		List<AssociateSkills> associateSkillEntityList = (List<AssociateSkills>) associateSkillsRepository
				.findByAssociateId(associate.getAssociateId());
		if (associateSkillEntityList != null && !associateSkillEntityList.isEmpty()) {
			associateSkillsRepository.deleteAll(associateSkillEntityList);
		}
		for (SkillVO skill : associateVO.getSkills()) {
			associateSkills = new AssociateSkills();
			if (associateSkillEntityList != null && !associateSkillEntityList.isEmpty()) {
				for (AssociateSkills associates: associateSkillEntityList) {
					if (associates.getSkills().getSkillId() == skill.getSkillId()) {
						associateSkills = associates;
						break;
					}
				}
			}
			associateSkills.setAssociate(associate);
			if (skill.getSkillRate() > 0) {
				Optional<Skills> skills = skillsRepository.findById(skill.getSkillId());
				if (skills.isPresent()) {
					associateSkills.setSkills(skills.get());
					associateSkills.setSkillRate(skill.getSkillRate());
					associateSkillsList.add(associateSkills);
				}
			}
		}
		associateSkillsRepository.saveAll(associateSkillsList);
	}

	@SuppressWarnings("null")
	private void mapAssociate(Associate associate, AssociateVO associateVO, MultipartFile file) 
			throws SerialException, SQLException, IOException {
		associate.setAssociateId(associateVO.getAssociateId());
		associate.setEmail(associateVO.getEmail());
		associate.setLevel1(associateVO.getLevel1());
		associate.setLevel2(associateVO.getLevel2());
		associate.setLevel3(associateVO.getLevel3());
		associate.setMobile(associateVO.getMobile());
		associate.setName(associateVO.getName());
		if (file != null && !file.isEmpty()) {
			associate.setPic(file.getBytes());
		}
		associate.setRemark(associateVO.getRemark());
		associate.setStatusBlue(associateVO.getStatusBlue());
		associate.setStatusGreen(associateVO.getStatusGreen());
		associate.setStatusRed(associateVO.getStatusRed());
		associate.setSpoken(associateVO.getSpoken());
		associate.setLogic(associateVO.getLogic());
		associate.setAptitude(associateVO.getAptitude());
		associate.setCommunication(associateVO.getCommunication());;
		associate.setConfidence(associateVO.getConfidence());
		associate.setOther(associateVO.getOther());
		associate.setStrength(associateVO.getStrength());
		associate.setWeakness(associateVO.getWeakness());
		associate.setGender(associateVO.getGender());
		associateRepository.save(associate);
	}

	@Override
	public byte[] getPic(int associateId) {
		byte[] bFile = null;
		Optional<Associate> associate = associateRepository.findById(associateId);
		if (associate.isPresent()) {
			bFile = associate.get().getPic();
		}
		return bFile;
	}

	@Override
	public List<AssociateVO> deleteAssociate(Integer associateId) {
		associateRepository.deleteById(associateId);
		return viewAllAssociates();
	}

}
