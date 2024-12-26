import React, { useState } from "react";
import { Form, Button, Container, Row, Col, InputGroup } from "react-bootstrap";

const NewMission = () => {
  const [missionName, setMissionName] = useState("");
  const [missionDetails, setMissionDetails] = useState("");
  const [locations, setLocations] = useState([]);
  const [currentLocation, setCurrentLocation] = useState("");
  const [staff, setStaff] = useState([]);
  const [selectedStaff, setSelectedStaff] = useState("");

  const staffTypes = ["Driver", "Medic", "Pilot", "Engineer", "Communicator"];

  const handleAddLocation = () => {
    if (currentLocation.trim()) {
      setLocations([...locations, currentLocation]);
      setCurrentLocation("");
    }
  };

  const handleRemoveLocation = (index) => {
    setLocations(locations.filter((_, i) => i !== index));
  };

  const handleAddStaff = () => {
    if (selectedStaff && !staff.includes(selectedStaff)) {
      setStaff([...staff, selectedStaff]);
      setSelectedStaff("");
    }
  };

  const handleRemoveStaff = (type) => {
    setStaff(staff.filter((s) => s !== type));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const payload = {
      missionName,
      missionDetails,
      locations,
      staff,
    };

    console.log(payload)

    // try {
    //   const response = await fetch("http://your-endpoint/api/missions", {
    //     method: "POST",
    //     headers: {
    //       "Content-Type": "application/json",
    //     },
    //     body: JSON.stringify(payload),
    //   });
    //   if (response.ok) {
    //     alert("Mission submitted successfully!");
    //     setMissionName("");
    //     setMissionDetails("");
    //     setLocations([]);
    //     setStaff([]);
    //   } else {
    //     alert("Failed to submit mission.");
    //   }
    // } catch (error) {
    //   console.error("Error submitting mission:", error);
    //   alert("An error occurred. Please try again.");
    // }
  };

  return (
    <Container>
      <Form onSubmit={handleSubmit}>
        {/* Mission Name */}
        <Form.Group className="mb-3">
          <Form.Label>Mission Name</Form.Label>
          <Form.Control
            type="text"
            value={missionName}
            onChange={(e) => setMissionName(e.target.value)}
            placeholder="Enter mission name"
            required
          />
        </Form.Group>

        {/* Mission Details */}
        <Form.Group className="mb-3">
          <Form.Label>Mission Details</Form.Label>
          <Form.Control
            as="textarea"
            rows={4}
            value={missionDetails}
            onChange={(e) => setMissionDetails(e.target.value)}
            placeholder="Enter mission details"
            required
          />
        </Form.Group>

        {/* Locations */}
        <Form.Group className="mb-3">
          <Form.Label>Locations</Form.Label>
          <InputGroup className="mb-2">
            <Form.Control
              type="text"
              value={currentLocation}
              onChange={(e) => setCurrentLocation(e.target.value)}
              placeholder="Add a location"
            />
            <Button variant="primary" onClick={handleAddLocation}>
              Add
            </Button>
          </InputGroup>
          <div>
            {locations.map((loc, index) => (
              <div key={index} className="d-flex align-items-center mb-1">
                <span className="me-2">{loc}</span>
                <Button
                  variant="outline-danger"
                  size="sm"
                  onClick={() => handleRemoveLocation(index)}
                >
                  Remove
                </Button>
              </div>
            ))}
          </div>
        </Form.Group>

        {/* Staff */}
        <Form.Group className="mb-3">
          <Form.Label>Staff</Form.Label>
          <InputGroup className="mb-2">
            <Form.Select
              value={selectedStaff}
              onChange={(e) => setSelectedStaff(e.target.value)}
            >
              <option value="">Select staff type</option>
              {staffTypes.map((type, index) => (
                <option key={index} value={type}>
                  {type}
                </option>
              ))}
            </Form.Select>
            <Button variant="primary" onClick={handleAddStaff}>
              Add
            </Button>
          </InputGroup>
          <div>
            {staff.map((type, index) => (
              <div key={index} className="d-flex align-items-center mb-1">
                <span className="me-2">{type}</span>
                <Button
                  variant="outline-danger"
                  size="sm"
                  onClick={() => handleRemoveStaff(type)}
                >
                  Remove
                </Button>
              </div>
            ))}
          </div>
        </Form.Group>

        {/* Submit Button */}
        <Button variant="success" type="submit">
          Submit Mission
        </Button>
      </Form>
    </Container>
  );
};

export default NewMission;
