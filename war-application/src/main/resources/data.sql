DELETE FROM `shammy`.`user_authorities` where user_id = 1;
DELETE FROM `shammy`.`user_authorities` where user_id = 2;
DELETE FROM `shammy`.`authorities` WHERE id = 1;
DELETE FROM `shammy`.`authorities` WHERE id = 2;
DELETE FROM `shammy`.`authorities` WHERE id = 3;
DELETE FROM `shammy`.`authorities` WHERE id = 4;
DELETE FROM `shammy`.`users` WHERE id = 1;
DELETE FROM `shammy`.`users` WHERE id = 2;
INSERT INTO `shammy`.`authorities` (`id`, `authority`, `description`) VALUES
('1', 'ADMIN', 'The most powerful authority, can control the application behaviour');
INSERT INTO `shammy`.`authorities` (`id`, `authority`, `description`) VALUES
('2', 'USER', 'The user of the system, can do basic stuff');
INSERT INTO `shammy`.`authorities` (`id`, `authority`, `description`) VALUES
('3', 'AUTHOR', 'This user can create articles');
INSERT INTO `shammy`.`authorities` (`id`, `authority`, `description`) VALUES
('4', 'EDITOR', 'This user can review and edit the articles');
INSERT INTO `shammy`.`users` (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
 ('1', true, true, true, true, 'Admin', 'Admin', 'admin', 'admin');
INSERT INTO `shammy`.`users` (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
 ('2', true, true, true, true, 'User', 'User', 'user', 'user');
INSERT INTO `shammy`.`user_authorities` (user_id,authority_id) VALUES
('1','1');
INSERT INTO `shammy`.`user_authorities` (user_id,authority_id) VALUES
('2','2');
INSERT INTO `shammy`.`users` (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
 ('3', true, true, true, true, 'User1', 'User1', 'user1', 'user1');
INSERT INTO `shammy`.`user_authorities` (user_id,authority_id) VALUES
('3','2');
INSERT INTO `shammy`.`users` (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
 ('4', true, true, true, true, 'User1', 'User1', 'user1', 'user2');
INSERT INTO `shammy`.`user_authorities` (user_id,authority_id) VALUES
('4','2');
INSERT INTO `shammy`.`users` (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
 ('5', true, true, true, true, 'User1', 'User1', 'user1', 'user3');
INSERT INTO `shammy`.`user_authorities` (user_id,authority_id) VALUES
('5','2');
INSERT INTO `shammy`.`users` (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
 ('6', true, true, true, true, 'User1', 'User1', 'user1', 'user4');
INSERT INTO `shammy`.`user_authorities` (user_id,authority_id) VALUES
('6','2');