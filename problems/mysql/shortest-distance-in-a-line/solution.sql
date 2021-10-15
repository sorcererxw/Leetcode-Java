CREATE TABLE If Not Exists point
(
    x INT NOT NULL,
    UNIQUE INDEX x_UNIQUE (x ASC)
);
Truncate table point;
insert into point (x)
values ('-1');
insert into point (x)
values ('0');
insert into point (x)
values ('2');

SELECT MIN(ABS(a.x - b.x)) AS shortest
FROM point a
         JOIN point b on a.x != b.x