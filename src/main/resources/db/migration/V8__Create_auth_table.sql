CREATE TABLE auth
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    principal    VARCHAR(255) NOT NULL,
    credentials   VARCHAR(255) NOT NULL,
    enabled      BOOLEAN      NOT NULL,
    roles     VARCHAR(20) NOT NULL
);
