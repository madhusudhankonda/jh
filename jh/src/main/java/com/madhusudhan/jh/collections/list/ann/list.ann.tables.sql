CREATE TABLE showroom_list_ann (
  SHOWROOM_ID int(11) NOT NULL AUTO_INCREMENT,
  location varchar(255) DEFAULT NULL,
  manager varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SHOWROOM_ID`)
)

CREATE TABLE car_list_ann (
  CAR_ID int(11) NOT NULL AUTO_INCREMENT,
  color varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  SHOWROOM_ID int(11) DEFAULT NULL,
  PRIMARY KEY (CAR_ID),
  FOREIGN KEY (SHOWROOM_ID) REFERENCES showroom_list_ann (SHOWROOM_ID)
) 


CREATE TABLE showroom_car_set_ann_jointable (
  SHOROOM_ID int(11) NOT NULL,
  cars_id int(11) NOT NULL,
  PRIMARY KEY (SHOROOM_ID,cars_id),
  FOREIGN KEY (SHOROOM_ID) REFERENCES showroom_set_ann_jointable (SHOWROOM_ID),
  FOREIGN KEY (cars_id) REFERENCES car_set_ann_jointable (id)
)