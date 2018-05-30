/**
 * 
 */
package com.skilltracker.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilltracker.service.SkillTrackerService;
import com.skilltracker.vo.AssociateVO;
import com.skilltracker.vo.SkillVO;

/**
 * @author Admin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillTrackerControllerTest {

	@InjectMocks
	SkillTrackerController skillTrackerController;

	@Mock
	SkillTrackerService skillTrackerService;

	private List<AssociateVO> associateList = new ArrayList<AssociateVO>();

	private List<SkillVO> skillList = new ArrayList<SkillVO>();

	private static final Integer ASSOCIATE_ID = 455355;

	private static final String DEFAULT_SKILL_NAME = "Java";

	private AssociateVO associateVO = new AssociateVO();

	private MultipartFile file;

	private static final String HTTP_STATUS_STRING = "success";

	private byte[] imageFile;

	private static final int ASSOCIATE_ARRAY_SIZE = 0;

	@Before
	public void setUpMockData() {
		associateVO.setAssociateId(455355);
		associateVO.setName("Mathew");
		associateVO.setEmail("a@aol.com");
		associateVO.setSkills(new ArrayList<SkillVO>());
		associateVO.setMobile("9995886316");
		associateVO.setLevel1("Y");
		associateVO.setLevel2("N");
		associateVO.setLevel3("N");
		associateVO.setRemark("Remark");
		associateVO.setStatusBlue("Y");
		associateVO.setStatusGreen("N");
		associateVO.setStatusRed("N");
		associateVO.setSpoken(12);
		associateVO.setLogic(15);
		associateVO.setAptitude(18);
		associateVO.setCommunication(10);;
		associateVO.setConfidence(15);
		associateVO.setOther("Other");
		associateVO.setStrength("Strength");
		associateVO.setWeakness("Weakness");
		associateVO.setGender("M");
		associateList.add(associateVO);

		SkillVO skillVO = new SkillVO();
		skillVO.setSkillId(1);
		skillVO.setSkillName(DEFAULT_SKILL_NAME);
		skillVO.setSkillRate(0);
		skillList.add(skillVO);
	}

	@Test
	public void testViewAllSkills() {
		Mockito.when(skillTrackerService.viewAllSkills()).thenReturn(skillList);
		List<SkillVO> skillVOList = skillTrackerController.viewAllSkills();
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testAddSkill() {
		Mockito.when(skillTrackerService.addSkill(Mockito.any(SkillVO.class))).thenReturn(skillList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		List<SkillVO> skillVOList = skillTrackerController.addSkill(skillVO);
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testEditSkill() {
		Mockito.when(skillTrackerService.editSkill(Mockito.any(SkillVO.class))).thenReturn(skillList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		List<SkillVO> skillVOList = skillTrackerController.editSkill(skillVO);
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testDeleteSkill() {
		Mockito.when(skillTrackerService.deleteSkill(Mockito.anyString())).thenReturn(skillList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		String skillId = "2";
		List<SkillVO> skillVOList = skillTrackerController.deleteSkill(skillId);
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testViewAllAssociates() {
		Mockito.when(skillTrackerService.viewAllAssociates()).thenReturn(associateList);
		List<AssociateVO> associateVOList = skillTrackerController.viewAllAssociates();
		assertEquals(ASSOCIATE_ID, associateVOList.get(0).getAssociateId());
	}

	@Test
	public void testAddAssociate() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(associateVO);
		ResponseEntity<String> response = skillTrackerController.addAssociate(file, jsonString);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testGetFile() {
		Mockito.when(skillTrackerService.getPic(Mockito.anyInt())).thenReturn(imageFile);
		byte[] image = skillTrackerController.getFile(String.valueOf(ASSOCIATE_ID));
		assertEquals(imageFile, image);
	}

	@Test
	public void testDeleteAssociate() {
		Mockito.when(skillTrackerService.deleteAssociate(Mockito.anyInt())).thenReturn(new ArrayList<AssociateVO>());
		List<AssociateVO> associateArray = skillTrackerController.deleteAssociate(String.valueOf(ASSOCIATE_ID));
		assertEquals(ASSOCIATE_ARRAY_SIZE, associateArray.size());
	}
}
