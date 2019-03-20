drop database if exists game;
CREATE DATABASE game;
USE game;

CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player1` varchar(255) DEFAULT NULL,
  `player2` varchar(255) DEFAULT NULL,
  `winner` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map` json DEFAULT NULL,
  `move_no` int(11) DEFAULT NULL,
  `next_player` varchar(255) DEFAULT NULL,
  `game` int(11) DEFAULT NULL references game,
  PRIMARY KEY (`id`)
);

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;