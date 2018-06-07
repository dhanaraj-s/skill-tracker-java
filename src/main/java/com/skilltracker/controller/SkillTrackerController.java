/**
 * 
 */
package com.skilltracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilltracker.service.SkillTrackerService;
import com.skilltracker.vo.AssociateVO;
import com.skilltracker.vo.SkillVO;

/**
 * @author Admin
 *
 */
@RestController
@CrossOrigin
/**
 * Use the below mapping when you are running this spring boot application as
 * jar.
 */
/** @RequestMapping(value = "/skilltracker") */
public class SkillTrackerController {

	@Autowired
	private SkillTrackerService skillTrackerService;

	@RequestMapping(value = "/viewallskills", method = RequestMethod.GET)
	public List<SkillVO> viewAllSkills() {
		return skillTrackerService.viewAllSkills();
	}

	@RequestMapping(value = "/addskill", method = RequestMethod.POST)
	public List<SkillVO> addSkill(@RequestBody SkillVO skillVO) {
		return skillTrackerService.addSkill(skillVO);
	}

	@RequestMapping(value = "/editskill", method = RequestMethod.POST)
	public List<SkillVO> editSkill(@RequestBody SkillVO skillVO) {
		return skillTrackerService.editSkill(skillVO);
	}

	@RequestMapping(value = "/deleteskill/{skillId}", method = RequestMethod.DELETE)
	public List<SkillVO> deleteSkill(@PathVariable String skillId) {
		return skillTrackerService.deleteSkill(skillId);
	}

	@RequestMapping(value = "/viewallassociates", method = RequestMethod.GET)
	public List<AssociateVO> viewAllAssociates() {
		return skillTrackerService.viewAllAssociates();
	}

	@PostMapping("/addassociate")
	public ResponseEntity<String> addAssociate(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("data") String associateData) {
		try {
			AssociateVO associateVO = new ObjectMapper().readValue(associateData, AssociateVO.class);
			String status = skillTrackerService.addAssociate(associateVO, file);
			return ResponseEntity.status(HttpStatus.OK).body(status);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failure");
		}
	}

	@GetMapping(value = "/getimage/{associateId}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	public byte[] getFile(@PathVariable String associateId) {
		byte[] bFile = null;
		try {
			bFile = skillTrackerService.getPic(Integer.parseInt(associateId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}

	@RequestMapping(value = "/deleteassociate/{associateId}", method = RequestMethod.DELETE)
	public List<AssociateVO> deleteAssociate(@PathVariable String associateId) {
		return skillTrackerService.deleteAssociate(Integer.parseInt(associateId));
	}

}
