USE db_palapa;


INSERT INTO location (id, name) VALUES ('1', 'Water line');
INSERT INTO location (id, name) VALUES ('2', 'Wildfire zone');
SELECT * FROM location;


INSERT INTO point (id, name, longitude, latitude, height) VALUES ('11', 'lineA_1', '512.9327774047852', '-30.484368866927777', '50');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('12', 'lineA_2', '512.9372406005859', '-30.48133620934747', '60');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('13', 'lineA_3', '512.9423475265503', '-30.47826647191783', '70');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('14', 'lineA_4', '512.9465532302856', '-30.4741979960528', '50');

INSERT INTO point (id, name, longitude, latitude, height) VALUES ('21', 'zoneA_1', '512.9233360290526', '-30.49579595933365', '50');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('22', 'zoneA_2', '512.9358243942261', '-30.49483450812004', '60');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('23', 'zoneA_3', '512.950415611267', '-30.489102582572734', '70');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('24', 'zoneA_4', '512.952561378479', '-30.48163208253916', '50');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('25', 'zoneA_5', '512.9452228546143', '-30.475381570203016', '70');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('26', 'zoneA_6', '512.9314041137695', '-30.481040335256484', '80');
INSERT INTO point (id, name, longitude, latitude, height) VALUES ('27', 'zoneA_7', '512.9178428649902', '-30.487697284772047', '60');
SELECT * FROM point;


INSERT INTO vertice (id, point_id, location_id) VALUES ('1', '11', '1');
INSERT INTO vertice (id, point_id, location_id) VALUES ('2', '12', '1');
INSERT INTO vertice (id, point_id, location_id) VALUES ('3', '13', '1');
INSERT INTO vertice (id, point_id, location_id) VALUES ('4', '14', '1');
INSERT INTO vertice (id, point_id, location_id) VALUES ('5', '21', '2');
INSERT INTO vertice (id, point_id, location_id) VALUES ('6', '22', '2');
INSERT INTO vertice (id, point_id, location_id) VALUES ('7', '23', '2');
INSERT INTO vertice (id, point_id, location_id) VALUES ('8', '24', '2');
INSERT INTO vertice (id, point_id, location_id) VALUES ('9', '25', '2');
INSERT INTO vertice (id, point_id, location_id) VALUES ('10', '26', '2');
INSERT INTO vertice (id, point_id, location_id) VALUES ('11', '27', '2');
SELECT * FROM vertice;
