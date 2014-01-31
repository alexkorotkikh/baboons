CREATE TABLE `group` (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL
);

CREATE TABLE user (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(40) NOT NULL,
  group_id INT REFERENCES `group` (id)
);

CREATE TABLE present (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL
);

CREATE TABLE user_present (
  user_id    INT REFERENCES user (id),
  present_id INT REFERENCES present (id)
);

CREATE TABLE pair (
  giver_id    INT REFERENCES user (id),
  receiver_id INT REFERENCES user (id)
);

SELECT
  name
FROM present
  JOIN user_present ON present.id = user_present.present_id
  JOIN pair ON pair.receiver_id = user_present.user_id
WHERE receiver_id = ?;
