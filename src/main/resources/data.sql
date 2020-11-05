use sevenfivefive;
INSERT IGNORE INTO `agent` (`id`, `username`, `password`, `algorithm`) VALUES ('1', 'Simar', '$2a$10$igTgmII5GOBn1QlSkjYc.uaqSMsSJsnukqE78Rzyd317dK2Fdj456', 'BCRYPT');
INSERT IGNORE INTO `agent` (`id`, `username`, `password`, `algorithm`) VALUES ('2', 'James', '$2a$10$c7ttPDz4wr97e8JGVpNxkOhD.BzHNbtLR8pV5l0qkzNNbZxIWMxLS', 'BCRYPT');

INSERT IGNORE INTO `authority` (`id`, `name`, `agent`) VALUES ('1', 'CAN_VIEW', '1');
INSERT IGNORE INTO `authority` (`id`, `name`, `agent`) VALUES ('2', 'CAN_BUY_SELL', '2');


INSERT IGNORE INTO `stock` (`id`,`organization`, `stockname`, `stockprice`, `trade_currency`) VALUES ('1', 'Microsoft', 'MSFT','206.43', 'USD');
INSERT IGNORE INTO `stock` (`id`,`organization`, `stockname`, `stockprice`, `trade_currency`) VALUES ('2', 'Queen Industries', 'QI','800.09', 'USD');