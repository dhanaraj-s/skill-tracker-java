package com.skilltracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.skilltracker.model.Skills;

public interface SkillsRepository extends CrudRepository<Skills, Integer> {

}
