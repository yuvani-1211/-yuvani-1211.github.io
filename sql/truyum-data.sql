-- Include table data insertion, updation, deletion and select scripts

-- -------------------------------------------------------------------
-- Adding Menu Items into the table
-- -------------------------------------------------------------------
insert into menu_item
values
(1, 'Sandwich', 99.0, 'yes', '2017-03-15','Main Course', 'yes'),
(2, 'Burger', 129.0, 'yes','2017-12-23','Main Course', 'no'),
(3, 'Pizza', 149.0, 'yes','2017-08-21', 'Main Course', 'no'),
(4, 'French Fries', 57.0,'no','2017-07-02','Starters','yes'),
(5, 'Chocolate Brownie', 32.0,'yes','2022-11-02','Dessert','yes');

select
me_name as Name ,
me_price as Price,
me_active as Active,
me_date_of_launch as Date_of_Launch, 
me_category as Category,
me_free_delivery as Free_Delivery
from menu_item;

-- -------------------------------------------------------------------
-- update the menu items values
-- -------------------------------------------------------------------
update menu_item 
set me_name ='Biriyani',
me_price=101.0,
me_active='no',
me_date_of_launch='2017-03-19',
me_category='Starters',
me_free_delivery='no'
where me_id=1;

-- -------------------------------------------------------------------
-- adding user items into the table
-- -------------------------------------------------------------------
insert into user
values
(1,'ravimal'),
(2,'yuvani');

-- -------------------------------------------------------------------
-- adding cart items into the table
-- -------------------------------------------------------------------
insert into cart (ct_us_id,ct_pr_id)
values
(1,1),
(1,3);


-- -------------------------------------------------------------------
-- adding cart items into the table
-- -------------------------------------------------------------------

insert into cart (ct_us_id,ct_pr_id)
values
(1,4);

insert into cart (ct_us_id,ct_pr_id)
values(2,3),(2,2);

-- -------------------------------------------------------------------
-- adding cart items into the table
-- -------------------------------------------------------------------


select  
me_name as Name ,
me_free_delivery as Free_Delivery,
me_price as Price,
me_category as Category
from menu_item 
where me_active='yes' and me_date_of_launch < current_date();

-- -------------------------------------------------------------------
-- getting the menu Item cart list
-- -------------------------------------------------------------------
select 
me_name as Name,
me_free_delivery as Free_Delivery,
me_price  as Price
from menu_item me 
join cart ca on(me.me_id = ca.ct_id) 
where ca.ct_us_id=1;

-- -------------------------------------------------------------------
-- adding the price value
-- -------------------------------------------------------------------

select 
sum(me_price)
from menu_item me join cart ca on(me.me_id = ca.ct_id) 
where ca.ct_us_id=1;

-- -------------------------------------------------------------------
-- deleting the cart item from the cart table
-- -------------------------------------------------------------------
delete  from cart where ct_pr_id=3 and ct_us_id=1;

