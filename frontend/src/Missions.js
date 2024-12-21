import React, { useState } from 'react';
import { Button, Container, Modal } from "react-bootstrap";
import MissionsTable from "./MissionsTable";
import NewMission from "./NewMission";

const Missions = ({ missions }) => {
  const [showModal, setShowModal] = useState(false);

  // Handle modal open and close
  const handleShow = () => {
      setShowModal(true);
  };

  const handleClose = () => setShowModal(false);

  return (
    <Container className="mt-3">
      <MissionsTable missions={missions} />

      <Button onClick={() => handleShow()}>
        New mission
      </Button>

      {/* Modal Component */}
      <Modal show={showModal} onHide={handleClose} centered>
          <Modal.Header>
              <Modal.Title>Create new mission</Modal.Title>
          </Modal.Header>
          <Modal.Body><NewMission /></Modal.Body>
          <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                  Close
              </Button>
          </Modal.Footer>
      </Modal>

    </Container>
  );
};

export default Missions;
