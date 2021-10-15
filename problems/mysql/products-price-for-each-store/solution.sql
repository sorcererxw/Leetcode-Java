Create table If Not Exists Products
(
    product_id int,
    store      ENUM ('store1', 'store2', 'store3'),
    price      int
);
Truncate table Products;
insert into Products (product_id, store, price)
values ('0', 'store1', '95');
insert into Products (product_id, store, price)
values ('0', 'store3', '105');
insert into Products (product_id, store, price)
values ('0', 'store2', '100');
insert into Products (product_id, store, price)
values ('1', 'store1', '70');
insert into Products (product_id, store, price)
values ('1', 'store3', '80');

#
#
# SELECT pid.product_id AS product_id,
#        p1.price       AS store1,
#        p2.price       AS store2,
#        p3.price       AS store3
# FROM (
#          SELECT DISTINCT product_id
#          FROM Products
#      ) pid
#          LEFT JOIN Products p1 ON p1.store = 'store1' AND p1.product_id = pid.product_id
#          LEFT JOIN Products p2 ON p2.store = 'store2' AND p2.product_id = pid.product_id
#          LEFT JOIN Products p3 ON p3.store = 'store3' AND p3.product_id = pid.product_id

SELECT product_id,
       MIN(IF(store = 'store1', price, NULL)) AS store1,
       MIN(IF(store = 'store2', price, NULL)) AS store2,
       MIN(IF(store = 'store3', price, NULL)) AS store3
FROM Products
GROUP BY product_id
