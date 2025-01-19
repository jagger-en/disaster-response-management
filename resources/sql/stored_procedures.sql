CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE OR REPLACE FUNCTION get_all_mission_summaries()
RETURNS TABLE (
    id BIGINT,
    mission_name VARCHAR(255),
    mission_description VARCHAR(255),
    location_name VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255),
    status_name VARCHAR(255),
    status_background VARCHAR(255),
    num_employees BIGINT
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        m.id AS id,
        m.name AS mission_name,
        m.description AS mission_description,
        l.name AS location_name,
        l.latitude AS latitude,
        l.longitude AS longitude,
        ms.name AS status_name,
        ms.background AS status_background,
        COUNT(ma.employee_id) AS num_employees
    FROM mission m
        INNER JOIN mission_and_location ml ON m.id = ml.mission_id
        INNER JOIN location l ON ml.location_id = l.id
        INNER JOIN mission_status ms ON ms.id = m.mission_status_id
        LEFT JOIN mission_assignment ma ON m.id = ma.mission_id
        GROUP BY m.id, m.name, m.description, l.name, l.latitude, l.longitude, ms.name, ms.background;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_all_mission_timeline_item()
RETURNS TABLE (
    id BIGINT,
    mission_name VARCHAR(255),
    mission_description VARCHAR(255),
    status_name VARCHAR(255),
    status_background VARCHAR(255),
    assignment_date VARCHAR(255)
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        m.id AS id,
        m.name AS mission_name,
        m.description AS mission_description,
        ms.name AS status_name,
        ms.background AS status_background,
        m_and_st.assignment_date
    FROM mission_and_status m_and_st
        INNER JOIN mission_status ms ON ms.id = m_and_st.mission_status_id
        INNER JOIN mission m ON m.id = m_and_st.mission_id;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_all_mission_location_item()
RETURNS TABLE (
    id BIGINT,
    mission_name VARCHAR(255),
    mission_description VARCHAR(255),
    latitude VARCHAR(255),
    longitude VARCHAR(255)
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        m.id AS id,
        m.name AS mission_name,
        m.description AS mission_description,
        loc.latitude AS latitude,
        loc.longitude AS longitude
    FROM mission_and_location m_and_loc
        INNER JOIN mission m ON m.id = m_and_loc.mission_id
        INNER JOIN location loc ON loc.id = m_and_loc.location_id;
END;
$$ LANGUAGE plpgsql;
