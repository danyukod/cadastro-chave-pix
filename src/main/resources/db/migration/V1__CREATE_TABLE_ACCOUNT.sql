CREATE TABLE IF NOT EXISTS `account` (
    `id` varchar(36) NOT NULL PRIMARY KEY,
    `type` varchar(255) NOT NULL,
    `agency_number` TINYINT NOT NULL,
    `number` INT NOT NULL,
    `holder_name` varchar(255) NOT NULL,
    `holder_last_name` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `modified_at` datetime
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;