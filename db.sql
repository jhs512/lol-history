DROP DATABASE IF EXISTS lolHistory;
CREATE DATABASE lolHistory;
USE lolHistory;

CREATE TABLE lolApiSummoner (
    uid INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    accountId CHAR(60),
    profileIconId INT(10) UNSIGNED,
    revisionDate BIGINT(10) UNSIGNED,
    `name` VARCHAR(200),
    id CHAR(70),
    puuid CHAR(80),
    summonerLevel INT(2)
);

CREATE TABLE urlResponse (
    uid INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    url VARCHAR(200) UNIQUE NOT NULL,
    `body` LONGTEXT NOT NULL
);
