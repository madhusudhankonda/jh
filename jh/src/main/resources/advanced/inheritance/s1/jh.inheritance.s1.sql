--Employee and Executive joined up Table

CREATE TABLE inheritance_s1_employee (
  employee_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  role varchar(20) DEFAULT NULL,
  discriminator varchar(20) DEFAULT NULL,
  DTYPE varchar(31) NOT NULL,
  PRIMARY KEY (employee_id)
)