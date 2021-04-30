SELECT p.name as `Point name`, l.name as `Location name`, p.latitude, p.longitude FROM db_palapa.vertice as v
INNER JOIN db_palapa.location as l on l.id = v.location_id
INNER JOIN db_palapa.point as p on p.id = v.point_id
WHERE l.name = 'Mountain';