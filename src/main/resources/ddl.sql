CREATE TABLE `uid_sequence` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `stub` char(200) NOT NULL default '',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=MyISAM;


REPLACE INTO uid_sequence (stub) VALUES ('a');
SELECT LAST_INSERT_ID();
