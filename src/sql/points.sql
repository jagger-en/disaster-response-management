USE db_palapa;

DELIMITER //
CREATE PROCEDURE `get_set_of_points_for_location` ()
BEGIN
    SELECT
		p.name as `point_name`,
        l.name as `location_name`,
		p.latitude,
        p.longitude,
        pt.name as `point_type_name`,
        p.id
	FROM db_palapa.vertice as v
    INNER JOIN db_palapa.location as l on l.id = v.location_id
    INNER JOIN db_palapa.point as p on p.id = v.point_id
	INNER JOIN db_palapa.point_type as pt on pt.id = p.point_type_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE `get_all_points` ()
BEGIN
    SELECT * FROM point;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE `get_ultra_query` ()
BEGIN
    SELECT
		p.name as `point_name`,
        l.name as `location_name`,
		p.latitude as `latitude`,
        p.longitude as `longitude`,
        pt.name as `point_type_name`,
		mis.name as `mission_name`,
        team.name as `team_name`,
		LEFT(UUID(), 8) as `id`
	FROM vertice as v
    INNER JOIN location as l on l.id = v.location_id
    INNER JOIN point as p on p.id = v.point_id
	INNER JOIN point_type as pt on pt.id = p.point_type_id
    INNER JOIN mission as mis on mis.location_id = l.id
    INNER JOIN mission_team as misteam on misteam.mission_id = mis.id
    INNER JOIN team on team.id = misteam.team_id
    ;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE `get_summary_query` ()
BEGIN
    SELECT
        LEFT(UUID(), 8) as `id`,
        person.first_name as `first_name`,
        person.last_name as `last_name`,
        job_title.name as `job_title_name`,
        mis.name as `mission_name`,
        team.name as `team_name`,
		p.name as `point_name`,
        l.name as `location_name`,
		p.latitude as `latitude`,
        p.longitude as `longitude`,
        pt.name as `point_type_name`
	FROM vertice as v
    INNER JOIN location as l on l.id = v.location_id
    INNER JOIN point as p on p.id = v.point_id
	INNER JOIN point_type as pt on pt.id = p.point_type_id
    INNER JOIN mission as mis on mis.location_id = l.id
    INNER JOIN mission_team as misteam on misteam.mission_id = mis.id
    INNER JOIN team on team.id = misteam.team_id
    INNER JOIN team_employee as teamEmp on teamEmp.team_id = team.id
    INNER JOIN employee on employee.id = teamEmp.employee_id
    INNER JOIN job_title on job_title.id = employee.job_title_id
    INNER JOIN person on person.id = employee.person_id
    ;
END //
DELIMITER ;
