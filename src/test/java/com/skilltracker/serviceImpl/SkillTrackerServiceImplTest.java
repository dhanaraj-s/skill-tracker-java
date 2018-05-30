package com.skilltracker.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.skilltracker.model.Associate;
import com.skilltracker.model.AssociateSkills;
import com.skilltracker.model.Skills;
import com.skilltracker.repository.AssociateRepository;
import com.skilltracker.repository.AssociateSkillsRepository;
import com.skilltracker.repository.SkillsRepository;
import com.skilltracker.vo.AssociateVO;
import com.skilltracker.vo.SkillVO;

@RunWith(MockitoJUnitRunner.class)
public class SkillTrackerServiceImplTest {

	@InjectMocks
	private SkillTrackerServiceImpl skillTrackerService;

	@Mock
	private AssociateRepository associateRepository;

	@Mock
	private AssociateSkillsRepository associateSkillsRepository;

	@Mock
	private SkillsRepository skillsRepository;

	private List<Associate> associateList = new ArrayList<Associate>();

	private List<Skills> skillList = new ArrayList<Skills>();

	private List<AssociateSkills> associateSkillsList = new ArrayList<AssociateSkills>();

	private static final Integer ASSOCIATE_ID = 455355;

	private static final String DEFAULT_SKILL_NAME = "Java";

	private Associate associate = new Associate();

	private MultipartFile file;

	private static final String HTTP_STATUS_STRING = "success";

	private byte[] imageFile;

	private static final int ASSOCIATE_ARRAY_SIZE = 0;

	private Optional<Skills> skillsEntity;

	private Optional<Associate> associateEntity;

	private AssociateVO associateVO = new AssociateVO();

	@Before
	public void setUpMockData() {
		associateVO.setAssociateId(455355);
		associateVO.setName("Mathew");
		associateVO.setEmail("a@aol.com");
		List<SkillVO> skillsVOList = new ArrayList<SkillVO>();
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
		associateVO.setCommunication(10);
		associateVO.setConfidence(15);
		associateVO.setOther("Other");
		associateVO.setStrength("Strength");
		associateVO.setWeakness("Weakness");
		associateVO.setGender("M");

		associate.setAssociateId(455355);
		associate.setName("Mathew");
		associate.setEmail("a@aol.com");
		associate.setMobile("9995886316");
		associate.setLevel1("Y");
		associate.setLevel2("N");
		associate.setLevel3("N");
		associate.setRemark("Remark");
		associate.setStatusBlue("Y");
		associate.setStatusGreen("N");
		associate.setStatusRed("N");
		associate.setSpoken(12);
		associate.setLogic(15);
		associate.setAptitude(18);
		associate.setCommunication(10);
		;
		associate.setConfidence(15);
		associate.setOther("Other");
		associate.setStrength("Strength");
		associate.setWeakness("Weakness");
		associate.setGender("M");
		associateList.add(associate);

		SkillVO skillVO = new SkillVO();
		skillVO.setSkillId(1);
		skillVO.setSkillName(DEFAULT_SKILL_NAME);
		skillVO.setSkillRate(20);
		skillsVOList.add(skillVO);
		associateVO.setSkills(skillsVOList);

		Skills skills = new Skills();
		skills.setSkillId(1);
		skills.setSkillName("Java");
		skillList.add(skills);

		skillsEntity = Optional.of(skills);
		associateEntity = Optional.of(associate);

		AssociateSkills associateSkills = new AssociateSkills();
		associateSkills.setAssociate(associate);
		associateSkills.setSkills(skills);
		associateSkillsList.add(associateSkills);
	}

	@Test
	public void testViewAllSkills() {
		Mockito.when(skillsRepository.findAll()).thenReturn(skillList);
		List<SkillVO> skillVOList = skillTrackerService.viewAllSkills();
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testAddSkill() {
		Mockito.when(skillsRepository.findAll()).thenReturn(skillList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		List<SkillVO> skillVOList = skillTrackerService.addSkill(skillVO);
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testEditSkill() {
		Mockito.when(skillsRepository.findById(Mockito.anyInt())).thenReturn(skillsEntity);
		Mockito.when(skillsRepository.findAll()).thenReturn(skillList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillId(1);
		skillVO.setSkillName("Java");
		List<SkillVO> skillVOList = skillTrackerService.editSkill(skillVO);
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testDeleteSkill() {
		Mockito.when(skillsRepository.findAll()).thenReturn(skillList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		skillVO.setSkillId(2);
		;
		List<SkillVO> skillVOList = skillTrackerService.deleteSkill("2");
		assertEquals(DEFAULT_SKILL_NAME, skillVOList.get(0).getSkillName());
	}

	@Test
	public void testViewAllAssociates() {
		Mockito.when(associateRepository.findAll()).thenReturn(associateList);
		Mockito.when(associateSkillsRepository.findByAssociateId(Mockito.anyInt())).thenReturn(associateSkillsList);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		skillVO.setSkillId(2);
		;
		List<AssociateVO> associateVOList = skillTrackerService.viewAllAssociates();
		assertEquals(ASSOCIATE_ID, associateVOList.get(0).getAssociateId());
	}

	@Test
	public void testAddAssociate() {
		Mockito.when(associateRepository.findById(Mockito.anyInt())).thenReturn(associateEntity);
		Mockito.when(associateSkillsRepository.findByAssociateId(Mockito.anyInt())).thenReturn(associateSkillsList);
		Mockito.when(skillsRepository.findById(Mockito.anyInt())).thenReturn(skillsEntity);
		SkillVO skillVO = new SkillVO();
		skillVO.setSkillName("Java");
		skillVO.setSkillId(2);
		;
		String status = skillTrackerService.addAssociate(associateVO, file);
		assertEquals(HTTP_STATUS_STRING, status);
	}

	@Test
	public void testGetPic() {
		Mockito.when(associateRepository.findById(Mockito.anyInt())).thenReturn(associateEntity);
		byte[] image = skillTrackerService.getPic(ASSOCIATE_ID);
		assertEquals(imageFile, image);
	}

	@Test
	public void testDeleteAssociate() {
		Mockito.when(associateRepository.findAll()).thenReturn(new ArrayList<Associate>());
		List<AssociateVO> associateVOList = skillTrackerService.deleteAssociate(ASSOCIATE_ID);
		assertEquals(ASSOCIATE_ARRAY_SIZE, associateVOList.size());
	}

}
