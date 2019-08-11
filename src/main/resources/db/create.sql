CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 dpt_name VARCHAR,
 dpt_descriptionVARCHAR,
 dpt_empNo INT
);

CREATE TABLE IF NOT EXISTS employees (
 id int PRIMARY KEY auto_increment,
 emp_name VARCHAR,
 emp_details VARCHAR,
 emp_role VARCHAR,
 emp_position VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 news_name VARCHAR,
 news_content VARCHAR,
 dpt_id INTEGER
);