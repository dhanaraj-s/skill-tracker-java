package com.skilltracker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.skilltracker.model.AssociateSkills;

public interface AssociateSkillsRepository extends CrudRepository<AssociateSkills, Integer> {

	List<AssociateSkills> findByAssociateId(Integer associateId);

}
