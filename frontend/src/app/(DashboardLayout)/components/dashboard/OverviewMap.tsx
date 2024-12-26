import React from 'react';
import Map, { Marker, Popup } from 'react-map-gl';
import 'mapbox-gl/dist/mapbox-gl.css';
import DashboardCard from '../shared/DashboardCard';

function MapComponent() {
  // Replace with your Mapbox access token
  const MAPBOX_TOKEN = process.env.NEXT_PUBLIC_MAPBOX_TOKEN;

  // Marker data (example locations)
  const markers = [
    { id: 1, position: [51.505, -0.09], popupText: 'London' },
    { id: 2, position: [48.8566, 2.3522], popupText: 'Paris' },
    { id: 3, position: [40.7128, -74.006], popupText: 'New York' },
  ];

  return (
    <DashboardCard title="Map">
          <div style={{ height: '500px', width: '100%' }}>
      <Map
        initialViewState={{
          longitude: -0.09,
          latitude: 51.505,
          zoom: 3,
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
          </Marker>
        ))}
      </Map>
    </div>
    </DashboardCard>
  );
}

export default MapComponent;
