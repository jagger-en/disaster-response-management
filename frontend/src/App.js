import React, { useState } from 'react';
import './App.css';
import L from 'leaflet';
import { TileLayer, Marker, Popup, MapContainer} from 'react-leaflet';
import icon_close_url from './assets/icon_close.svg';
import icon_flame_url from './assets/icon_flame.svg';
import icon_helicopter_url from './assets/icon_helicopter.svg';
import icon_firefighter_url from './assets/icon_firefighter.svg';
import icon_storagetank_url from './assets/icon_storagetank.svg';
import useSwr from 'swr';
import { v4 as uuidv4 } from 'uuid';
import { Navbar, Nav, NavDropdown, Form, FormControl, Button, Table, Modal } from 'react-bootstrap';

const fetcher = (...args) => fetch(...args).then(response => response.json());

const MARKERS_URL = "http://localhost:8081/api/markers/all";
const TEAM_MISSION_DETAILS_URL = "http://localhost:8081/api/team-mission-details/all";

const icon_close = L.icon({
  iconUrl: icon_close_url,
  iconSize:     [38, 95],
  iconAnchor:   [22, 94],
  popupAnchor:  [-3, -86]
});

const icon_firefighter = L.icon({
  iconUrl: icon_firefighter_url,
  iconSize:     [38, 95],
  iconAnchor:   [22, 94],
  popupAnchor:  [-3, -86]
});

const icon_flame = L.icon({
  iconUrl: icon_flame_url,
  iconSize:     [38, 95],
  iconAnchor:   [22, 94],
  popupAnchor:  [-3, -86]
});

const icon_helicopter = L.icon({
  iconUrl: icon_helicopter_url,
  iconSize:     [38, 95],
  iconAnchor:   [22, 94],
  popupAnchor:  [-3, -86]
});

const icon_storagetank = L.icon({
  iconUrl: icon_storagetank_url,
  iconSize:     [38, 95],
  iconAnchor:   [22, 94],
  popupAnchor:  [-3, -86]
});


const decide_icon = (pointName) => {
  let icon_return;
  if (pointName == "icon_close") {
    icon_return = icon_close
  }
  if (pointName == "icon_firefighter") {
    icon_return = icon_firefighter
  }
  else if (pointName == "icon_flame") {
    icon_return = icon_flame
  }
  else if (pointName == "icon_helicopter") {
    icon_return = icon_helicopter
  }
  else if (pointName == "icon_storagetank") {
    icon_return = icon_storagetank
  }
  else {
    icon_return = icon_close
  }
  return icon_return
}

const teams = [
  { name: 'Team Alpha', missions: ['Mission A', 'Mission C'] },
  { name: 'Team Beta', missions: ['Mission B'] },
  { name: 'Team Gamma', missions: ['Mission A', 'Mission B'] },
  { name: 'Team Delta', missions: [] },
];

export default function App() {

  const [showModal, setShowModal] = useState(false);
  const [modalContent, setModalContent] = useState({ title: '', details: '' });

  // Handle modal open and close
  const handleShow = (title, details) => {
    setModalContent({ title, details });
    setShowModal(true);
  };

  const handleClose = () => setShowModal(false);



  const zoom_level = 15

  const { data: markersData, error: markersError } = useSwr(MARKERS_URL, fetcher);

  const { data: teamMissionDetailsData, error: teamMissionDetailsError } = useSwr(TEAM_MISSION_DETAILS_URL, fetcher);

  if (markersError || teamMissionDetailsError) {
    return <div>Error loading data...</div>;
  }

  if (!markersData || !teamMissionDetailsData) {
    return <div>Loading...</div>;
  }

  const coord_center = markersData.length > 0 ?
    [markersData[0].latitude, markersData[0].longitude] : [0, 0]

  const uniqueTeamNames = new Set();

  teamMissionDetailsData.forEach(d => {
    uniqueTeamNames.add(d.teamName)
  })

  const teamMissionDetails = Array.from(uniqueTeamNames).map(d => {
    const matches = teamMissionDetailsData.filter(dd => {
      if (dd.teamName == d) {
        return dd
      }
    })

    const employees = new Set();
    const addToEmployees = obj => {
      const serialized = JSON.stringify(obj);
      employees.add(serialized);
    };
    matches.forEach(dd => {
      addToEmployees({
        employeeFirstName: dd.employeeFirstName,
        employeeLastName: dd.employeeLastName,
        employeeJobTitleName: dd.employeeJobTitleName,
      })
    })

    const missions = new Set();
    const addToMissions = obj => {
      const serialized = JSON.stringify(obj);
      missions.add(serialized);
    };
    matches.forEach(dd => {
      addToMissions({
        missionName: dd.missionName,
        missionDescription: dd.missionDescription,
        missionLocationName: dd.missionLocationName,
        missionTypeName: dd.missionTypeName,
      })
    })

    return {"name": d, "employees": Array.from(employees).map(dd => JSON.parse(dd)), "missions": Array.from(missions).map(dd => JSON.parse(dd))}
  })

  return (
    <div>
      <Navbar expand="lg">
        <div className="container">
          <Navbar.Brand href="#home">Disaster Response Management System</Navbar.Brand>
        </div>
      </Navbar>
      <div className="container">
        <MapContainer className="map" center={coord_center} zoom={zoom_level} style={{ height: "50vh", width: "100%" }}>
          <TileLayer
            attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          {markersData.map(d => (
            <Marker key={uuidv4()} position={[d.latitude, d.longitude]} icon={decide_icon(d.pointTypeName)}>
              <Popup>
              <b>Point:</b> {d.pointName}
              <br></br>
              <b>Location:</b> {d.locationName}
              <br></br>
              <b>Mission:</b> {d.missionName}
              <br></br>
              <b>Team:</b> {d.teamName}
              </Popup>
            </Marker>
          ))}
        </MapContainer>
      </div>

      <div className="container">
        <div className="birdseye-view">
          <h3>Teams and Missions</h3>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>Team Name</th>
                <th>Missions</th>
              </tr>
            </thead>
            <tbody>
              {teamMissionDetails.map((item, index) => (
                <tr key={index}>
                  <td>
                    <a
                      href="#!"
                      onClick={() => handleShow(`Team: ${item.name}`,
                        (
                          <table className="table">
                            <thead>
                              <tr>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Role</th>
                              </tr>
                            </thead>
                            <tbody>
                            {
                              item.employees.map((employee, index) => (
                                <tr key={index}>
                                  <td>{employee.employeeFirstName}</td>
                                  <td>{employee.employeeLastName}</td>
                                  <td>{employee.employeeJobTitleName}</td>
                                </tr>
                              ))
                            }
                            </tbody>
                          </table>
                        )
                      )}
                      className="team-link"
                    >
                      {item.name}
                    </a>
                  </td>
                  <td>
                    {item.missions.length > 0 ? (
                      item.missions.map((mission, idx) => (
                        <li
                          key={idx}
                          href="#!"
                          onClick={() => handleShow(`Mission: ${mission.missionName}`, (
                            <div>
                              <p>
                                <b>Description</b>: {mission.missionDescription}
                              </p>
                              <p>
                                <b>Location</b>: {mission.missionLocationName}
                              </p>
                              <p>
                                <b>Type</b>: {mission.missionTypeName}
                              </p>
                            </div>
                            ))}
                          className="mission-link"
                        >
                          {mission.missionName}
                        </li>
                      ))
                    ) : (
                      <span className="no-assignment">- None Assigned -</span>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>

          {/* Modal Component */}
          <Modal show={showModal} onHide={handleClose} centered>
            <Modal.Header closeButton>
              <Modal.Title>{modalContent.title}</Modal.Title>
            </Modal.Header>
            <Modal.Body>{modalContent.details}</Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                Close
              </Button>
            </Modal.Footer>
          </Modal>
        </div>
      </div>






    </div>
  );
}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/vectors-market" title="Vectors Market">Vectors Market</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/mangsaabguru" title="mangsaabguru">mangsaabguru</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/monkik" title="monkik">monkik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/good-ware" title="Good Ware">Good Ware</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
