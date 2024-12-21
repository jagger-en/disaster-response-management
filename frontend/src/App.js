import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import { Navbar, Nav, Container, NavDropdown, Form, FormControl, Button, Table, Modal } from 'react-bootstrap';
import Home from "./Home.js"
import MissionsAndTeams from "./MissionsAndTeams.js"
import Workforce from "./Workforce.js"
import NewMission from "./NewMission.js"
import MissionsDashboard from "./MissionsDashboard";
import SpecificMission from "./SpecificMission";

export default function App() {
  const missions = [
    { id: "1", name: "Bushfire Response", status: "ACTIVE", location: "Victoria", personnelCount: 20 },
    { id: "2", name: "Flood Relief", status: "COMPLETED", location: "New South Wales", personnelCount: 15 },
    { id: "3", name: "Earthquake Rescue", status: "PLANNED", location: "Tasmania", personnelCount: 25 },
  ];

  const mission = {
    id: "1",
    name: "Bushfire Response",
    status: "ACTIVE",
    details: "Responding to the wildfires in Victoria",
    location: "Victoria",
    personnel: [
      { id: 1, firstName: "John", lastName: "Doe", location: "Melbourne", status: "ACTIVE" },
      { id: 2, firstName: "Jane", lastName: "Smith", location: "Sydney", status: "UNKNOWN" },
    ],
  };

  return (
    <BrowserRouter>
       <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand href="/">Disaster Response</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="/workforce">Workforce</Nav.Link>
              <Nav.Link href="/new-mission">New mission</Nav.Link>
              <Nav.Link href="/missions">Missions</Nav.Link>
              <Nav.Link href="/missions-and-teams">Overview</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/workforce" element={<Workforce />} />
        <Route path="/new-mission" element={ <NewMission /> } />
        <Route path="/missions" element={<MissionsDashboard missions={missions} />} />
        <Route path="/missions-and-teams" element={<MissionsAndTeams />} />
        <Route path="/specific-mission" element={<SpecificMission mission={mission} />} />
      </Routes>

    </BrowserRouter>
  );
}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/vectors-market" title="Vectors Market">Vectors Market</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
{/* <div>Icons made by <a href="https://www.flaticon.com/authors/mangsaabguru" title="mangsaabguru">mangsaabguru</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
{/* <div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
{/* <div>Icons made by <a href="https://www.flaticon.com/authors/monkik" title="monkik">monkik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
{/* <div>Icons made by <a href="https://www.flaticon.com/authors/good-ware" title="Good Ware">Good Ware</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
