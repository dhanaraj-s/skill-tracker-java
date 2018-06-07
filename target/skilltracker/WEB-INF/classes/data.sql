DROP TABLE IF EXISTS associate;
CREATE TABLE associate (
  associate_id INT NOT NULL,
  name VARCHAR(256) NOT NULL,
  email VARCHAR(256) NOT NULL,
  mobile VARCHAR(10) NOT NULL,
  gender VARCHAR(1) NOT NULL,
  pic longblob NOT NULL,
  status_green VARCHAR(1),
  status_blue VARCHAR(1),
  status_red VARCHAR(1),
  level_1 VARCHAR(1),
  level_2 VARCHAR(1),
  level_3 VARCHAR(1),
  spoken INT,
  communication INT,
  logic INT,
  aptitude INT,
  confidence INT,
  other VARCHAR(256),
  remark VARCHAR(256),
  strength VARCHAR(256) NOT NULL,
  weakness VARCHAR(256) NOT NULL,
  PRIMARY KEY (associate_id));
  
  DROP TABLE IF EXISTS skills;
CREATE TABLE skills (
  skill_id INT NOT NULL AUTO_INCREMENT,
  skill_name VARCHAR(256) NOT NULL,
  PRIMARY KEY (skill_id));
  
DROP TABLE IF EXISTS associate_skills;
CREATE TABLE associate_skills (
  associate_skill_id INT NOT NULL AUTO_INCREMENT,
  associate_id INT NOT NULL,
  skill_id INT NOT NULL,
  skill_rate INT NOT NULL,
  FOREIGN KEY (associate_id) REFERENCES associate(associate_id) ON DELETE CASCADE,
  FOREIGN KEY (skill_id) REFERENCES skills(skill_id) ON DELETE CASCADE,
  PRIMARY KEY (associate_skill_id));
  

  
  
INSERT INTO skills ( skill_name)
VALUES ('HTML5');
INSERT INTO skills ( skill_name)
VALUES ('CSS3');
INSERT INTO skills ( skill_name)
VALUES ('Bootstrap');
INSERT INTO skills ( skill_name)
VALUES ('Javascript');
INSERT INTO skills ( skill_name)
VALUES ('Jquery');
INSERT INTO skills ( skill_name)
VALUES ('Angular 1');
INSERT INTO skills ( skill_name)
VALUES ('Angular 2');
INSERT INTO skills ( skill_name)
VALUES ('Angular 4');
INSERT INTO skills ( skill_name)
VALUES ('React');
INSERT INTO skills ( skill_name)
VALUES ('Spring');
INSERT INTO skills ( skill_name)
VALUES ('Spring MVC');
INSERT INTO skills ( skill_name)
VALUES ('Java');
INSERT INTO skills ( skill_name)
VALUES ('Spring Restful');
INSERT INTO skills ( skill_name)
VALUES ('JAX-RS');
INSERT INTO skills ( skill_name)
VALUES ('JSON');
INSERT INTO skills ( skill_name)
VALUES ('XML');
INSERT INTO skills ( skill_name)
VALUES ('Hidernate');
INSERT INTO skills ( skill_name)
VALUES ('Spring Cache');
INSERT INTO skills ( skill_name)
VALUES ('Devops');