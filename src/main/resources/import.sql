delete from T_USER_ACTIVITY_LOG;
delete from T_USER;
insert INTO T_USER (USER_ID, USER_NAME) values (1, 'user1');
insert INTO T_USER (USER_ID, USER_NAME) values (2, 'user2');
insert INTO T_USER (USER_ID, USER_NAME) values (3, 'user3');

INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2013-08-23 11:00:00', 2, 1);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2014-12-05 23:00:00', 2, 2);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-11-13 15:00:00', 3, 3);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2013-10-02 18:00:00', 5, 3);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-05-30 02:00:00', 4, 2);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2014-01-24 07:00:00', 12, 2);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2013-02-06 11:00:00', 6, 1);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-08-16 12:00:00', 7, 1);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-09-06 22:00:00', 5, 3);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2013-07-02 01:00:00', 22, 2);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2013-10-26 21:00:00', 5, 1);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-05-29 14:00:00', 9, 2);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2014-03-14 05:00:00', 10, 3);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-10-09 03:00:00', 17, 3);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2014-12-10 23:00:00', 32, 2);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2014-01-11 01:00:00', 8, 1);
INSERT INTO T_USER_ACTIVITY_LOG (ACTIVITY_DATE, ACTIVITY_COUNT, USER_ID) values ('2015-06-12 12:00:00', 1, 1);