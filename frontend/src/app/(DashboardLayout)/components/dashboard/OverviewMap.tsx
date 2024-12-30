import React from 'react';
import Map, { Marker, Popup } from 'react-map-gl';
import 'mapbox-gl/dist/mapbox-gl.css';
import DashboardCard from '../shared/DashboardCard';
import useSwr from 'swr';
import { parse } from 'path';

const MISSION_LOCATION_ITEMS_URL = "http://localhost:8081/api/mission-location-items/all";
const fetcher = async (...args) => {
  const res = await fetch(...args);
  if (!res.ok) {
    throw new Error(`HTTP error! Status: ${res.status}`);
  }
  return res.json();
};

function MapComponent() {
  const { data: missionLocationItems, error: missionLocationItemsError } = useSwr(MISSION_LOCATION_ITEMS_URL, fetcher);

  if (missionLocationItems) {
    if (missionLocationItems.status == 500) {
        return <div>Error loading data {JSON.stringify(missionLocationItems)}</div>;
      }
  }

  if (!missionLocationItems) {
      return <div>Loading mission and location...</div>;
  }

  // Replace with your Mapbox access token
  const MAPBOX_TOKEN = process.env.NEXT_PUBLIC_MAPBOX_TOKEN;

  // Marker data (example locations)
  const markers = missionLocationItems.map(d => {
    return {
      id: d.id,
      position: [parseFloat(d.longitude), parseFloat(d.latitude)],
      name: d.missionName,
    }
  })

  return (
    <DashboardCard title="Map">
          <div style={{ height: '350px', width: '100%' }}>
      <Map
        initialViewState={{
          latitude: markers[0].position[0],
          longitude: markers[0].position[1],
          zoom: 12,
        }}
        style={{ width: '100%', height: '100%' }}
        mapStyle="mapbox://styles/mapbox/streets-v11"
        mapboxAccessToken={MAPBOX_TOKEN}
      >
        {markers.map(marker => (
          <Marker
            key={marker.id}
            longitude={marker.position[1]}
            latitude={marker.position[0]}
          >
            <div
              style={{
                background: 'red',
                borderRadius: '50%',
                width: '10px',
                height: '10px',
              }}
            />
            { marker.name }
          </Marker>
        ))}
      </Map>
    </div>
    </DashboardCard>
  );
}

export default MapComponent;
