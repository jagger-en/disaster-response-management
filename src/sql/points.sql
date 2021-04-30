DELIMITER //
CREATE PROCEDURE `get_set_of_points_for_location` (
    IN location_name VARCHAR(255)
)
BEGIN
    SELECT p.name as `Point name`, l.name as `Location name`, p.latitude, p.longitude FROM db_palapa.vertice as v
    INNER JOIN db_palapa.location as l on l.id = v.location_id
    INNER JOIN db_palapa.point as p on p.id = v.point_id
    WHERE l.name = location_name;
END //
DELIMITER ;

CALL get_set_of_points_for_location('Water line');