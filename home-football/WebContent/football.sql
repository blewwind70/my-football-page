
/* Drop Tables */

DROP TABLE FB_SCORE CASCADE CONSTRAINTS;
DROP TABLE FB_MATCH CASCADE CONSTRAINTS;
DROP TABLE FB_MATCH_INFO CASCADE CONSTRAINTS;
DROP TABLE FB_PLAYER CASCADE CONSTRAINTS;
DROP TABLE FB_TEAM CASCADE CONSTRAINTS;
DROP TABLE FB_LEAGUE CASCADE CONSTRAINTS;
DROP TABLE FB_NATION CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE FB_LEAGUE
(
	FB_LEAGUE_NO number(4,0) NOT NULL,
	FB_LEAGUE_NAME varchar2(50) NOT NULL,
	FB_LEAGUE_TYPE char NOT NULL,
	FB_NATION_NO number(3,0) NOT NULL,
	PRIMARY KEY (FB_LEAGUE_NO),
	CONSTRAINT FB_LEAGUETYPE_CK CHECK (FB_LEAGUE_TYPE = 'L' OR FB_LEAGUE_TYPE = 'T')
);


CREATE TABLE FB_MATCH
(
	FB_MATCH_NO number(6) NOT NULL,
	FB_MATCH_RESULT varchar2(10) DEFAULT 'NT' NOT NULL,
	FB_HOMETEAM_SCORE number(2,0),
	FB_AWAYTEAM_SCORE number(2,0),
	FB_MATCH_INFO_NO number(6) NOT NULL,
	FB_HOMETEAM_NO number(4,0) NOT NULL,
	FB_AWAYTEAM_NO number(4,0) NOT NULL,
	PRIMARY KEY (FB_MATCH_NO),
	CONSTRAINT FB_MATCHRESULT_CK CHECK (FB_MATCH_RESULT IN ('NT', 'HT', 'FT', 'CN'))
);


CREATE TABLE FB_MATCH_INFO
(
	FB_MATCH_INFO_NO number(6) NOT NULL,
	FB_MATCH_INFO_ROUND number(2,0) NOT NULL,
	FB_MATCH_INFO_MATCHDATE date,
	FB_LEAGUE_NO number(4,0) NOT NULL,
	PRIMARY KEY (FB_MATCH_INFO_NO)
);


CREATE TABLE FB_NATION
(
	FB_NATION_NO number(3,0) NOT NULL,
	FB_NATION_NAME varchar2(50) NOT NULL UNIQUE,
	PRIMARY KEY (FB_NATION_NO)
);


CREATE TABLE FB_PLAYER
(
	FB_PLAYER_NO number(6) NOT NULL,
	FB_PLAYER_NAME varchar2(50) NOT NULL,
	FB_PLAYER_AGE number(2,0) NOT NULL,
	FB_PLAYER_POSITION varchar2(20),
	FB_TEAM_NO number(4,0) NOT NULL,
	FB_NATION_NO number(3,0) NOT NULL,
	PRIMARY KEY (FB_PLAYER_NO)
);


CREATE TABLE FB_SCORE
(
	FB_PLAYER_NO number(6) NOT NULL,
	FB_MATCH_NO number(6) NOT NULL
);


CREATE TABLE FB_TEAM
(
	FB_TEAM_NO number(4,0) NOT NULL,
	FB_TEAM_NAME varchar2(50) NOT NULL,
	FB_NATION_NO number(3,0) NOT NULL,
	FB_LEAGUE_NO number(4,0) NOT NULL,
	PRIMARY KEY (FB_TEAM_NO)
);



/* Create Foreign Keys */

ALTER TABLE FB_MATCH_INFO
	ADD FOREIGN KEY (FB_LEAGUE_NO)
	REFERENCES FB_LEAGUE (FB_LEAGUE_NO)
;


ALTER TABLE FB_TEAM
	ADD FOREIGN KEY (FB_LEAGUE_NO)
	REFERENCES FB_LEAGUE (FB_LEAGUE_NO)
;


ALTER TABLE FB_SCORE
	ADD FOREIGN KEY (FB_MATCH_NO)
	REFERENCES FB_MATCH (FB_MATCH_NO)
;


ALTER TABLE FB_MATCH
	ADD FOREIGN KEY (FB_MATCH_INFO_NO)
	REFERENCES FB_MATCH_INFO (FB_MATCH_INFO_NO)
;


ALTER TABLE FB_LEAGUE
	ADD FOREIGN KEY (FB_NATION_NO)
	REFERENCES FB_NATION (FB_NATION_NO)
;


ALTER TABLE FB_PLAYER
	ADD FOREIGN KEY (FB_NATION_NO)
	REFERENCES FB_NATION (FB_NATION_NO)
;


ALTER TABLE FB_TEAM
	ADD FOREIGN KEY (FB_NATION_NO)
	REFERENCES FB_NATION (FB_NATION_NO)
;


ALTER TABLE FB_SCORE
	ADD FOREIGN KEY (FB_PLAYER_NO)
	REFERENCES FB_PLAYER (FB_PLAYER_NO)
;


ALTER TABLE FB_MATCH
	ADD FOREIGN KEY (FB_AWAYTEAM_NO)
	REFERENCES FB_TEAM (FB_TEAM_NO)
;


ALTER TABLE FB_MATCH
	ADD FOREIGN KEY (FB_HOMETEAM_NO)
	REFERENCES FB_TEAM (FB_TEAM_NO)
;


ALTER TABLE FB_PLAYER
	ADD FOREIGN KEY (FB_TEAM_NO)
	REFERENCES FB_TEAM (FB_TEAM_NO)
;



