"use client"; // Ensure this component is treated as a Client Component
import React from 'react';
import { Container, Typography, Grid, Card, CardContent, CardMedia, Box } from '@mui/material';
import 'mapbox-gl/dist/mapbox-gl.css';
import Map, { Marker } from 'react-map-gl';
import FireIcon from '@mui/icons-material/LocalFireDepartment';

// Mapbox Access Token
const MAPBOX_TOKEN = process.env.NEXT_PUBLIC_MAPBOX_TOKEN;

// Map Markers
const fireLocations = [
  { longitude: -120.5, latitude: 38.5, description: "Fire near Greenvale Town" },
  { longitude: -120.7, latitude: 38.6, description: "Expanding fire in Pine Ridge Forest" },
  { longitude: -120.6, latitude: 38.4, description: "Isolated fire near Riverbend" },
];

const BushfireNews = () => {
  return (
    <Container maxWidth="lg" sx={{ py: 4 }}>
      {/* Header */}
      <Typography variant="h2" gutterBottom>
        Forest Fire Emergency Report
      </Typography>

      {/* Incident Overview */}
      <Box className="section" sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Incident Overview
        </Typography>
        <Typography variant="body1">
          A forest fire has erupted near the small town of Greenvale, located at the foothills of the Pine Ridge Mountains. The fire began late last night due to suspected lightning strikes during a severe storm. The blaze has already consumed approximately 500 acres of woodland and is spreading rapidly due to strong winds.
        </Typography>
      </Box>

      {/* Current Response */}
      <Box className="section" sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Current Response
        </Typography>
        <Typography variant="body1">
          Firefighters from Greenvale and neighboring counties have been deployed to the scene. Two aerial water bombers and ground crews are actively working to contain the blaze. Emergency services have established a perimeter around the affected area, and efforts are underway to protect nearby properties.
        </Typography>
      </Box>

      {/* Evacuation and Safety Measures */}
      <Box className="section evacuation" sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Evacuation and Safety Measures
        </Typography>
        <Typography variant="body1">
          The following actions are needed to ensure the safety of residents and effective response to the fire:
        </Typography>
        <ul>
          <li>
            <strong>Issue Evacuation Orders:</strong> Authorities need to immediately inform residents of Greenvale and surrounding areas to evacuate and provide clear instructions for safe routes.
          </li>
          <li>
            <strong>Set Up Shelters:</strong> Temporary shelters should be established at Greenvale High School and the Pinewood Community Center to accommodate evacuees.
          </li>
          <li>
            <strong>Provide Emergency Communication:</strong> Establish a hotline for evacuees and concerned relatives. A suggested number is{' '}
            <a href="tel:+18005551234">1-800-555-1234</a>.
          </li>
          <li>
            <strong>Coordinate Traffic Management:</strong> Ensure roads near the fire zone are kept clear for emergency services and evacuating residents.
          </li>
        </ul>
      </Box>

      {/* Recommended Actions */}
      <Box className="section" sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Recommended Actions
        </Typography>
        <Typography variant="body1">
          To help mitigate the impact of the fire, authorities are recommending the following actions:
        </Typography>
        <ul>
          <li>Residents in nearby towns should prepare to evacuate if conditions worsen.</li>
          <li>Do not return to evacuated areas until authorities declare it safe.</li>
          <li>Avoid driving on roads near the fire zone to allow emergency services to operate efficiently.</li>
          <li>Stay informed by tuning into local news channels or visiting the official Greenvale town website.</li>
        </ul>
      </Box>

      {/* Map Section */}
      <Box sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Bushfire Affected Locations
        </Typography>
        <Map
          initialViewState={{
            longitude: -120.5,
            latitude: 38.5,
            zoom: 10,
          }}
          style={{ width: "100%", height: 400 }}
          mapStyle="mapbox://styles/mapbox/streets-v11"
          mapboxAccessToken={MAPBOX_TOKEN}
        >
          {fireLocations.map((location, index) => (
            <Marker
              key={index}
              longitude={location.longitude}
              latitude={location.latitude}
              anchor="bottom"
            >
              <FireIcon style={{ color: "red", fontSize: "2rem" }} titleAccess={location.description} />
            </Marker>
          ))}
        </Map>
      </Box>
    </Container>
  );
};

export default BushfireNews;
