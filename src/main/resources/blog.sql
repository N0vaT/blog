DROP TABLE IF EXISTS post;

CREATE TABLE post
(
    post_id SERIAL,
    post_title varchar(255) not null,
    post_anons varchar(255) not null,
    post_full_text TEXT not null,
    PRIMARY KEY (post_id)
);

INSERT INTO post (post_id, post_title, post_anons, post_full_text) VALUES
(1, 'TEST - post_title', 'TEST - post_anons', 'TEST - post_full_text'),
(2, 'TEST 2 - post_title 2', 'TEST 2 - post_anons 2', 'TEST 2 - post_full_text 2');