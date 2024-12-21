import React from "react";
import { Table, Button } from "react-bootstrap";
import { Link } from "react-router-dom";

const MissionsTable = ({ missions }) => {
  return (
    <Table striped bordered hover responsive>
      <thead>
        <tr>
          <th>Name</th>
          <th>Status</th>
          <th>Location</th>
          <th>Personnel</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {missions.map((mission) => (
          <tr key={mission.id}>
            <td>{mission.name}</td>
            <td>{mission.status}</td>
            <td>{mission.location}</td>
            <td>{mission.personnelCount}</td>
            <td>
              <Button
                variant="info"
                className="me-2"
                onClick={() => alert(`Showing details for mission: ${mission.id}`)}
              >
                View Details
              </Button>
              <Link to={`/specific-mission?id=${mission.id}`}>
                <Button variant="primary">Go to Mission</Button>
              </Link>
            </td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
};

export default MissionsTable;
