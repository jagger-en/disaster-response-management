import React from "react";
import { useLocation } from "react-router-dom";
import { Table, Button, Container, Row, Col } from "react-bootstrap";
// import QRCode from "qrcode.react";

const SpecificMission = ({ mission }) => {
  const query = new URLSearchParams(useLocation().search);
  const missionId = query.get("id");

  // Placeholder for mission data - replace this with actual fetch data in a real app
  const personnel = mission.personnel || [
    { id: 1, firstName: "John", lastName: "Doe", location: "Melbourne", status: "ACTIVE" },
    { id: 2, firstName: "Jane", lastName: "Smith", location: "Sydney", status: "UNKNOWN" },
  ];

  return (
    <Container>
      <h1 className="mb-4">Mission Details</h1>
      <Row>
        <Col md={4} className="text-center">
          {/* <QRCode value={`http://your-app-url/specific-mission?id=${missionId}`} size={150} /> */}
          <p className="mt-2">Scan QR to Share Mission</p>
        </Col>
        <Col md={8}>
          <h2>{mission.name}</h2>
          <p><strong>Status:</strong> {mission.status}</p>
          <p><strong>Details:</strong> {mission.details}</p>
          <p><strong>Location:</strong> {mission.location}</p>
          <Button variant="success" className="mt-3">Chat with Team</Button>
        </Col>
      </Row>
      <h3 className="mt-5">Assigned Personnel</h3>
      <Table striped bordered hover responsive>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Location</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {personnel.map((person) => (
            <tr key={person.id}>
              <td>{person.firstName}</td>
              <td>{person.lastName}</td>
              <td>{person.location}</td>
              <td>{person.status}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default SpecificMission;
