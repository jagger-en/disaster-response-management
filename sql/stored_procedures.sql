CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE OR REPLACE FUNCTION get_set_of_points_for_location()
RETURNS TABLE (
    point_name VARCHAR(255),
    location_name VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255),
    point_type_name VARCHAR(255),
    id TEXT
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        p.name AS point_name,
        l.name AS location_name,
        p.latitude,
        p.longitude,
        pt.name AS point_type_name,
        p.id
    FROM db_palapa.vertice v
    INNER JOIN db_palapa.location l ON l.id = v.location_id
    INNER JOIN db_palapa.point p ON p.id = v.point_id
    INNER JOIN db_palapa.point_type pt ON pt.id = p.point_type_id;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_all_points()
RETURNS TABLE (
    id BIGINT,
    name VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255),
    point_type_id BIGINT
) AS $$
BEGIN
    RETURN QUERY
    SELECT p.id, p.name, p.latitude, p.longitude, p.point_type_id FROM point p;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_ultra_query()
RETURNS TABLE (
    point_name VARCHAR(255),
    location_name VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255),
    point_type_name VARCHAR(255),
    mission_name VARCHAR(255),
    team_name VARCHAR(255),
    id TEXT
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        p.name AS point_name,
        l.name AS location_name,
        p.latitude AS latitude,
        p.longitude AS longitude,
        pt.name AS point_type_name,
        mis.name AS mission_name,
        team.name AS team_name,
        LEFT(UUID_GENERATE_V4()::text, 8) AS id
    FROM vertice v
    INNER JOIN location l ON l.id = v.location_id
    INNER JOIN point p ON p.id = v.point_id
    INNER JOIN point_type pt ON pt.id = p.point_type_id
    INNER JOIN mission mis ON mis.location_id = l.id
    INNER JOIN mission_team misteam ON misteam.mission_id = mis.id
    INNER JOIN team ON team.id = misteam.team_id;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_summary_query()
RETURNS TABLE (
    id TEXT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    job_title_name VARCHAR(255),
    mission_name VARCHAR(255),
    team_name VARCHAR(255),
    point_name VARCHAR(255),
    location_name VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255),
    point_type_name VARCHAR(255)
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        LEFT(UUID_GENERATE_V4()::text, 8) AS id,
        per.first_name AS first_name,
        per.last_name AS last_name,
        jt.name AS job_title_name,
        mis.name AS mission_name,
        team.name AS team_name,
        p.name AS point_name,
        l.name AS location_name,
        p.latitude AS latitude,
        p.longitude AS longitude,
        pt.name AS point_type_name
    FROM vertice v
    INNER JOIN location l ON l.id = v.location_id
    INNER JOIN mission mis ON mis.location_id = l.id
    INNER JOIN mission_team misteam ON misteam.mission_id = mis.id
    INNER JOIN team ON team.id = misteam.team_id
    INNER JOIN team_employee team_emp ON team_emp.team_id = team.id
    INNER JOIN employee emp ON emp.id = team_emp.employee_id
    INNER JOIN job_title jt ON jt.id = emp.job_title_id
    INNER JOIN person per ON per.id = emp.person_id
    INNER JOIN point p ON p.id = v.point_id
    INNER JOIN point_type pt ON pt.id = p.point_type_id;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_all_team_mission_details_query()
RETURNS TABLE (
    id TEXT,
    team_name VARCHAR(255),
    team_functionality_name VARCHAR(255),
    team_functionality_description VARCHAR(255),
    employee_first_name VARCHAR(255),
    employee_last_name VARCHAR(255),
    employee_job_title_name VARCHAR(255),
    mission_name VARCHAR(255),
    mission_description VARCHAR(255),
    mission_type_name VARCHAR(255),
    mission_location_name VARCHAR(255)
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        LEFT(UUID_GENERATE_V4()::text, 8) AS id,
        team.name AS team_name,
        tf.name AS team_functionality_name,
        tf.description AS team_functionality_description,
        per.first_name AS employee_first_name,
        per.last_name AS employee_last_name,
        jt.name AS employee_job_title_name,
        mis.name AS mission_name,
        mis.description AS mission_description,
        mistyp.name AS mission_type_name,
        loc.name AS mission_location_name
    FROM mission_team mt
    INNER JOIN team ON team.id = mt.team_id
    INNER JOIN team_functionality tf ON tf.id = team.team_functionality_id
    INNER JOIN team_employee te ON te.team_id = team.id
    INNER JOIN employee emp ON emp.id = te.employee_id
    INNER JOIN person per ON per.id = emp.person_id
    INNER JOIN job_title jt ON jt.id = emp.job_title_id
    INNER JOIN mission mis ON mis.id = mt.mission_id
    INNER JOIN mission_type mistyp ON mistyp.id = mis.mission_type_id
    INNER JOIN location loc ON loc.id = mis.location_id;
END;
$$ LANGUAGE plpgsql;
