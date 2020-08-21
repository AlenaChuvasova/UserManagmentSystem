CREATE DATABASE user_mng;

drop table user_account;

CREATE TABLE user_account
(
  id         SERIAL PRIMARY KEY,
  username   VARCHAR(50)  NOT NULL UNIQUE,
  password   VARCHAR(255) NOT NULL,
  name       VARCHAR(50)  NOT NULL,
  surname    VARCHAR(50)  NOT NULL,
  role       VARCHAR(45)  NULL,
  active     boolean      NULL,
  is_locked  boolean      NULL,
  status     VARCHAR(45)  NULL,
  created_at timestamp    NOT NULL DEFAULT NOW()
);

select * from user_account;