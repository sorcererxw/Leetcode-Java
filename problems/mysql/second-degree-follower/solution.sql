Create table If Not Exists follow
(
    followee varchar(255),
    follower varchar(255)
);
Truncate table follow;
insert into follow (followee, follower)
values ('A', 'B');
insert into follow (followee, follower)
values ('B', 'C');
insert into follow (followee, follower)
values ('B', 'D');
insert into follow (followee, follower)
values ('D', 'E');
insert into follow (followee, follower)
values ('B', 'F');

SELECT *
FROM follow f
         JOIN
         (SELECT DISTINCT follower FROM follow) t ON f.followee = t.follower
ORDER BY f.follower;


SELECT f.followee AS follower, COUNT(DISTINCT f.follower) AS num
FROM follow f
         JOIN
         (SELECT DISTINCT follower FROM follow) t ON f.followee = t.follower
GROUP BY f.followee
ORDER BY f.followee