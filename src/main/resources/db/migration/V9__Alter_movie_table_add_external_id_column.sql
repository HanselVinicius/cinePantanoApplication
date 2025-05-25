ALTER TABLE movie
    ADD COLUMN external_id CHAR(36) DEFAULT NULL,
    ADD UNIQUE INDEX idx_movie_external_id (external_id);
