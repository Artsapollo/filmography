CREATE SCHEMA `filmography` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE films
(
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  year int(4),
  genre VARCHAR(20),
  watched BIT DEFAULT false NOT NULL
)
COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX films_title_uindex ON films (title);

INSERT INTO `films` (`title`, `year`, `genre`, watched)
VALUES ('The Longest Yard', 2005, 'sport', 1);

