insert into roles values(1,'ADMIN');
insert into roles values(2,'USER');

insert into users values(1, 'user1@email.com', '$2a$10$863vO4Y4uS.b2OV3pDGiKeeP8dhf.VwyLMrm.ofXMZYSPhjc1PP3e', 'User1');

insert into users_roles values(1,1);
insert into users_roles values(1,2);