import React, {Component} from 'react';
import './App.css';
import L from 'leaflet';
import { TileLayer, Marker, Popup, MapContainer} from 'react-leaflet';
import leafGreen from './assets/leaf-green.png';
import leafRed from './assets/leaf-red.png';
import leafOrange from './assets/leaf-orange.png';
import leafShadow from './assets/leaf-shadow.png';
import icon_close from './assets/icon_close.svg';
import icon_firefighter from './assets/icon_firefighter.svg';
import useSwr from 'swr';


const fetcher = (...args) => fetch(...args).then(response => response.json());

export default function App() {
  
  const state = {
    greenIcon: {
      lat: 35.787449,
      lng: -78.6438197,
    },
    redIcon: {
      lat: 35.774416,
      lng: -78.633271,
    },
    orangeIcon: {
      lat: 35.772790,
      lng: -78.652305,
    },
    zoom: 13
  }

  // <div>Icons made by <a href="https://www.flaticon.com/authors/mangsaabguru" 
  // title="mangsaabguru">mangsaabguru</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

  // <div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from 
  // <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

  const grenIcon = L.icon({
    iconUrl: leafGreen,
    shadowUrl: leafShadow,
    iconSize:     [38, 95], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -76]
  });

  const redIcon = L.icon({
    iconUrl: leafRed,
    shadowUrl: leafShadow,
    iconSize:     [38, 95], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -86]
  });

  const orangeIcon = L.icon({
    iconUrl: leafOrange,
    shadowUrl: leafShadow,
    iconSize:     [38, 95], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -86]
  });

  const iconClose = L.icon({
    iconUrl: icon_close,
    iconSize:     [38, 95], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -86]
  });

  const iconFirefighter = L.icon({
    iconUrl: icon_firefighter,
    iconSize:     [38, 95], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62],  // the same for the shadow
    popupAnchor:  [-3, -86]
  });

  const positionRedIcon = [state.redIcon.lat, state.redIcon.lng];
  const positionGreenIcon = [state.greenIcon.lat, state.greenIcon.lng];
  const positionOrangeIcon = [state.orangeIcon.lat, state.orangeIcon.lng];


  const url = "http://localhost:8080/api/markers/all";
  const {data, error} = useSwr(url, {fetcher});

  const markers_data = data && !error ? data : [];

  console.log("--------------------")
  console.log(markers_data)
  console.log("--------------------")

  return (
    <MapContainer className="map" center={positionGreenIcon} zoom={state.zoom}>
      <TileLayer
        attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      <Marker position={positionGreenIcon} icon={grenIcon}>
        <Popup>
        I am a green leaf
        </Popup>
      </Marker>
      <Marker position={positionRedIcon} icon={redIcon}>
        <Popup>
        I am a red leaf
        </Popup>
      </Marker>
      <Marker position={positionOrangeIcon} icon={orangeIcon}>
        <Popup>
        I am an orange leaf
        </Popup>
      </Marker>
      {markers_data.map(d => (
        <Marker key={d.pointName} position={[d.latitude, d.longitude]} icon={iconFirefighter}>
          <Popup>
          pointName: {d.pointName}
          locationName: {d.locationName}
          </Popup>
        </Marker>
      ))}
    </MapContainer>
  );
}