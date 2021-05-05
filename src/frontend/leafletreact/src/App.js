import React from 'react';
import './App.css';
import L from 'leaflet';
import { TileLayer, Marker, Popup, MapContainer} from 'react-leaflet';
import icon_close from './assets/icon_close.svg';
import icon_firefighter from './assets/icon_firefighter.svg';
import useSwr from 'swr';


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
  
  console.log("--------------------")
  console.log(JSON.stringify(markers_data))
  console.log("--------------------")
  // const markers_data = [{"pointName":"lineA_1","locationName":"50","latitude":"-30.484368866927777","longitude":"512.9327774047852"},{"pointName":"lineA_2","locationName":"60","latitude":"-30.48133620934747","longitude":"512.9372406005859"},{"pointName":"lineA_3","locationName":"70","latitude":"-30.47826647191783","longitude":"512.9423475265503"},{"pointName":"lineA_4","locationName":"50","latitude":"-30.4741979960528","longitude":"512.9465532302856"},{"pointName":"zoneA_1","locationName":"50","latitude":"-30.49579595933365","longitude":"512.9233360290526"},{"pointName":"zoneA_2","locationName":"60","latitude":"-30.49483450812004","longitude":"512.9358243942261"},{"pointName":"zoneA_3","locationName":"70","latitude":"-30.489102582572734","longitude":"512.950415611267"},{"pointName":"zoneA_4","locationName":"50","latitude":"-30.48163208253916","longitude":"512.952561378479"},{"pointName":"zoneA_5","locationName":"70","latitude":"-30.475381570203016","longitude":"512.9452228546143"},{"pointName":"Sample1","locationName":"145","latitude":"-30.5068796961844","longitude":"152.89874017238617"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50647759770449","longitude":"152.89936780929565"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50602465719561","longitude":"152.90002226829526"},{"pointName":"Sample1","locationName":"145","latitude":"-30.505641042665626","longitude":"152.9009234905243"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50507717277826","longitude":"152.901052236557"},{"pointName":"Sample1","locationName":"145","latitude":"-30.504619603827333","longitude":"152.9009073972702"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50411812427204","longitude":"152.90072232484818"},{"pointName":"Sample1","locationName":"145","latitude":"-30.502163022604204","longitude":"152.89736151695251"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50233634880783","longitude":"152.89760828018186"},{"pointName":"Sample1","locationName":"145","latitude":"-30.502394124140395","longitude":"152.89792746305463"},{"pointName":"Sample1","locationName":"145","latitude":"-30.502451899438633","longitude":"152.89834856987"},{"pointName":"Sample1","locationName":"145","latitude":"-30.502516607731938","longitude":"152.89887964725494"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50258824900642","longitude":"152.8994670510292"},{"pointName":"Sample1","locationName":"145","latitude":"-30.502710732353492","longitude":"152.89997667074203"},{"pointName":"Sample1","locationName":"145","latitude":"-30.503082803461783","longitude":"152.90046751499173"},{"pointName":"Sample1","locationName":"145","latitude":"-30.50363975196385","longitude":"152.90067672729492"}]
  const coord_center = markers_data.length > 0 ? 
    [markers_data[0].latitude, markers_data[0].longitude] : [0, 0]

  return (
    <MapContainer className="map" center={coord_center} zoom={zoom_level}>
      <TileLayer
        attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      {markers_data.map(d => (
        <Marker key={d.pointName} position={[d.latitude, d.longitude]} icon={decide_icon(d.pointName)}>
          <Popup>
          pointName: {d.pointName}
          locationName: {d.locationName}
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
