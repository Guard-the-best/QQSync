use web;

insert into userInfo values(1,'admin','$2a$10$hJxGqTH1WbPqGGpp0P3AheBtbsvuUjV99X0le3PP7xY3BF48.WxmW','10086','dyp'); -- password=123456
insert into rolesInfo values(1,'ROLE_ADMIN');
insert into rolesInfo values(1,'ROLE_USER');

insert into categoryInfo values(101,'Dog');
insert into productInfo values (1001,101,'Golden Retriever');
insert into productInfo values (1002, 101, 'Labrador Retriever');
insert into productInfo values (1003, 101, 'Chihuahua');
insert into itemInfo values (10001,1001,20,1,'good boy-happy-short tail');
insert into itemInfo values (10002, 1001, 20, 1, 'bad boy-angry-long tail');
insert into itemInfo values (10003, 1001, 30, 1, 'king-lonely-bold');
insert into itemInfo values (10010, 1002, 50, 1, 'jet-curious-smart');
insert into itemInfo values (10011, 1002, 50, 1, 'funk-angry-crazy');
insert into itemInfo values (10013, 1002, 60, 1, 'star-calm-handsome');
