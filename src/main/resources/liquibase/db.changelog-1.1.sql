-- liquibase formatted sql
-- changeset nghiemnc:1.1

DROP TABLE IF EXISTS device;

CREATE TABLE device (
    id serial,
    firebase_project_name VARCHAR (255) NOT NULL,
    firebase_device_token VARCHAR (255) NOT NULL UNIQUE ,
    endpoint VARCHAR (255) default null,
    p256dh VARCHAR (255) default null ,
    oauth VARCHAR (255) default null,
    application_key VARCHAR (255) default null,
    created_at TIMESTAMP default null ,
    updated_at TIMESTAMP default null,
    created_by BIGINT default null ,
    updated_by BIGINT default null,
    is_active bool default true,
    is_deleted bool default false,
    PRIMARY KEY (id)
)
