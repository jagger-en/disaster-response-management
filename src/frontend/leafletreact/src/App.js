import React from 'react';
import './App.css';
import L from 'leaflet';
import { TileLayer, Marker, Popup, MapContainer} from 'react-leaflet';
import icon_close from './assets/icon_close.svg';
import icon_firefighter from './assets/icon_firefighter.svg';
import useSwr from 'swr';
import { v4 as uuidv4 } from 'uuid';

const fetcher = (...args) => fetch(...args).then(response => response.json());




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


const decide_icon = (pointName) => {
  if (pointName == "") {

  }
  return iconFirefighter
}

export default function App() {
  const zoom_level = 3

  const url = "http://localhost:8080/api/markers/all";
  const {data, error} = useSwr(url, {fetcher});

  const markers_data = data && !error ? data : [];
  console.log(markers_data)
  const coord_center = markers_data.length > 0 ? 
    [markers_data[0].latitude, markers_data[0].longitude] : [0, 0]

  return (
    <MapContainer className="map" center={coord_center} zoom={zoom_level}>
      <TileLayer
        attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      {markers_data.map(d => (
        <Marker key={uuidv4} position={[d.latitude, d.longitude]} icon={decide_icon(d.pointName)}>
          <Popup>
          Point: {d.pointName}
          <br></br>
          Location: {d.locationName}
          </Popup>
        </Marker>
      ))}
    </MapContainer>
  );
}


// <div>Icons made by <a href="https://www.flaticon.com/authors/mangsaabguru" 
// title="mangsaabguru">mangsaabguru</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

// <div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from 
// <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
