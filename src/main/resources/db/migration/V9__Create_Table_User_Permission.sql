﻿CREATE TABLE  user_permissions (
   id_user bigint NOT NULL,
   id_permission bigint NOT NULL,
   PRIMARY KEY (id_user, id_permission),
   CONSTRAINT fk_user_permission FOREIGN KEY (id_user) REFERENCES users (id),
   CONSTRAINT fk_user_permission_permission FOREIGN KEY (id_permission) REFERENCES permissions (id)
);
