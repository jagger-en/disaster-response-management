import React from 'react';
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
import { Navbar, Nav, NavDropdown, Form, FormControl, Button, Table } from 'react-bootstrap';

const fetcher = (...args) => fetch(...args).then(response => response.json());

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

export default function App() {
  const zoom_level = 3

  const url = "http://localhost:8081/api/markers/all";
  const {data, error} = useSwr(url, {fetcher});

  const markers_data = data && !error ? data : [];
  console.log(markers_data)
  const coord_center = markers_data.length > 0 ? 
    [markers_data[0].latitude, markers_data[0].longitude] : [0, 0]

  const summary_table_data = []

  return (
    <div>
      <Navbar bg="success" variant="dark" expand="lg">
        <div className="container">
          <Navbar.Brand href="#home">Disaster Response (Java Project)</Navbar.Brand>
        </div>
      </Navbar>
      <div className="container" style={{width: "100%", height: "100vh"}}>
        <MapContainer className="map" center={coord_center} zoom={zoom_level}>
          <TileLayer
            attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          {markers_data.map(d => (
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
      <div className="container mt-5">
        <h1>Summary</h1>
        <Table striped bordered hover size="sm">
          <thead>
            <tr>
              <th>#</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Job title</th>
              <th>Mission</th>
              <th>Team</th>
            </tr>
          </thead>
          <tbody>
            {
              summary_table_data.map(d => (
                <tr key={uuidv4()}>
                  <td>{d.id}</td>
                  <td>{d.firstName}</td>
                  <td>{d.lastName}</td>
                  <td>{d.jobTitleName}</td>
                  <td>{d.missionName}</td>
                  <td>{d.teamName}</td>
                </tr>
              ))
            }
          </tbody>
        </Table>
      </div>
      <div style={{marginBottom: "500px"}}></div>
    </div>
  );
}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/vectors-market" title="Vectors Market">Vectors Market</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/mangsaabguru" title="mangsaabguru">mangsaabguru</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/monkik" title="monkik">monkik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}

{/* <div>Icons made by <a href="https://www.flaticon.com/authors/good-ware" title="Good Ware">Good Ware</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div> */}
