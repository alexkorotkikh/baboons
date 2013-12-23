CREATE TABLE employees (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(128) NOT NULL,
  title        VARCHAR(32)  NOT NULL,
  manager_id   INT REFERENCES employees (id),
  started_date DATE         NOT NULL,
  salary       INT          NOT NULL
);

INSERT INTO employees (name, title, started_date, salary) VALUES
  ('SMITH', 'CLERK', '1980-12-17', 800),
  ('ALLEN', 'SALESMAN', '1981-02-20', 1600),
  ('WARD', 'SALESMAN', '1981-02-22', 1250),
  ('JONES', 'MANAGER', '1981-04-02', 2975),
  ('MARTIN', 'SALESMAN', '1981-09-28', 1250),
  ('BLAKE', 'MANAGER', '1981-05-01', 2850),
  ('CLARK', 'MANAGER', '1981-06-09', 2450),
  ('SCOTT', 'ANALYST', '1982-12-09', 3000),
  ('KING', 'PRESIDENT', '1981-11-17', 5000),
  ('TURNER', 'SALESMAN', '1981-09-08', 1500),
  ('ADAMS', 'CLERK', '1983-01-12', 1100),
  ('JAMES', 'CLERK', '1981-12-01', 950),
  ('FORD', 'ANALYST', '1981-12-03', 3000),
  ('MILLER', 'CLERK', '1982-12-23', 1300);



