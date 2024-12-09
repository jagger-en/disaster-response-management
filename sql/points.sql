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
