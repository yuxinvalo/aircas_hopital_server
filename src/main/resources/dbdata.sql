INSERT INTO t_user VALUES(1, '22390', '桂花', 'toto', '2021-02-01 16:01:21', '13597273344');
INSERT INTO t_user VALUES(2, '22391', '大有', 'toto', '2021-02-02 16:01:21', '13597273234');
INSERT INTO t_user VALUES(3, '22392', '麻辣香锅', 'toto', '2021-02-11 16:01:21', '13597246744');
INSERT INTO t_user VALUES(4, '22394', '麻辣兔头', 'toto', '2021-01-27 16:01:21', '13497278904');

INSERT INTO t_device VALUES("TCB-A1", 20, 0, 100, '192.168.0.1', '10.0.0.1', 0);
INSERT INTO t_device VALUES("TCB-A2", 40, 30, 8, '192.168.0.2', '10.0.0.1', 1);
INSERT INTO t_device VALUES("TCB-B1", 50, 0, 10, '192.168.0.3', '10.0.0.1', 0);
INSERT INTO t_device VALUES("TCB-B2", 80, 0, 80, '192.168.0.4', '10.0.0.1', 0);
INSERT INTO t_device VALUES("TCB-A3", 30, 0, 77, '192.168.0.5', '10.0.0.1', 0);
INSERT INTO t_device VALUES("TCB-A4", 40, 20, 68, '192.168.0.1', '10.0.0.2', 0);
INSERT INTO t_device VALUES("TCB-A5", 50, 0, 45, '192.168.0.2', '10.0.0.2', 0);
INSERT INTO t_device VALUES("TCB-A6", 20, 55, 1, '192.168.0.4', '10.0.0.2', 1);
INSERT INTO t_device VALUES("TCB-A7", 70, 90, 100, '192.168.0.5', '10.0.0.2', 0);

INSERT INTO t_user_device VALUES (1, 1, "TCB-A1", "1", "1");
INSERT INTO t_user_device VALUES (2, 1, "TCB-A2", "1", "2");
INSERT INTO t_user_device VALUES (3, 1, "TCB-A3", "2", "1");
INSERT INTO t_user_device VALUES (4, 2, "TCB-A4", "2", "6");
INSERT INTO t_user_device VALUES (5, 2, "TCB-B1", "3", "7");
INSERT INTO t_user_device VALUES (6, 3, "TCB-B2", "2", "2");
INSERT INTO t_user_device VALUES (7, 4, "TCB-A6", "3", "4");