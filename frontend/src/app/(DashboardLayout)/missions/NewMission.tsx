"use client"; // Ensures this component is treated as a client-side component

import React, { useState } from "react";
import {
  Container,
  TextField,
  Typography,
  Button,
  Box,
  Autocomplete,
  Chip,
} from "@mui/material";
import Map, { Marker, MapRef } from "react-map-gl";
import AddLocationIcon from "@mui/icons-material/AddLocation";
import RemoveCircleIcon from "@mui/icons-material/RemoveCircle";
import "mapbox-gl/dist/mapbox-gl.css";

// Mapbox Access Token
const MAPBOX_TOKEN = process.env.NEXT_PUBLIC_MAPBOX_TOKEN;

// StaffType Options
const staffTypes = ["Driver", "Medic", "Searcher", "Rescuer"];

const NewMission = () => {
  const [name, setName] = useState("");
  const [details, setDetails] = useState("");
  const [selectedStaff, setSelectedStaff] = useState<string[]>([]);
  const [locations, setLocations] = useState<{ longitude: number; latitude: number }[]>([]);

  const handleMapClick = (event: any) => {
    const { lng, lat } = event.lngLat;
    setLocations([...locations, { longitude: lng, latitude: lat }]);
  };

  const removeLocation = (index: number) => {
    setLocations(locations.filter((_, i) => i !== index));
  };

  const handleSubmit = () => {
    const missionData = {
      name,
      details,
      staffType: selectedStaff,
      locations,
    };

    console.log("Mission Data Submitted:", missionData);

    // Example POST request to a server
    fetch("/api/missions", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(missionData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Mission created:", data);
      })
      .catch((error) => {
        console.error("Error creating mission:", error);
      });
  };

  return (
    <Container maxWidth="lg" sx={{ py: 4 }}>
      <Typography variant="h4" gutterBottom>
        New Mission
      </Typography>
      <Box component="form" sx={{ display: "flex", flexDirection: "column", gap: 3 }}>
        {/* Mission Name */}
        <TextField
          label="Mission Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          fullWidth
          required
        />

        {/* Mission Details */}
        <TextField
          label="Mission Details"
          value={details}
          onChange={(e) => setDetails(e.target.value)}
          multiline
          rows={4}
          fullWidth
          required
        />

        {/* Staff Type Selector */}
        <Autocomplete
          multiple
          options={staffTypes}
          value={selectedStaff}
          onChange={(event, newValue) => setSelectedStaff(newValue)}
          renderTags={(value, getTagProps) =>
            value.map((option, index) => (
              <Chip label={option} {...getTagProps({ index })} key={option} />
            ))
          }
          renderInput={(params) => <TextField {...params} label="Staff Type" />}
        />

        {/* Map Section */}
        <Box sx={{ mt: 4 }}>
          <Typography variant="h6" gutterBottom>
            Select Locations
          </Typography>
          <Map
            initialViewState={{
              longitude: -120.5,
              latitude: 38.5,
              zoom: 10,
            }}
            style={{ width: "100%", height: 250 }}
            mapStyle="mapbox://styles/mapbox/streets-v11"
            mapboxAccessToken={MAPBOX_TOKEN}
            onClick={handleMapClick}
          >
            {locations.map((location, index) => (
              <Marker
                key={index}
                longitude={location.longitude}
                latitude={location.latitude}
                anchor="bottom"
              >
                <AddLocationIcon
                  style={{ color: "red", fontSize: "3rem" }}
                  onClick={() => removeLocation(index)}
                />
              </Marker>
            ))}
          </Map>
          {locations.length > 0 && (
            <Box sx={{ mt: 2 }}>
              <Typography variant="body1">Selected Locations:</Typography>
              {locations.map((location, index) => (
                <Box key={index} sx={{ display: "flex", alignItems: "center", mt: 1 }}>
                  <Typography variant="body2" sx={{ mr: 1 }}>
                    {`[Longitude: ${location.longitude.toFixed(4)}, Latitude: ${location.latitude.toFixed(4)}]`}
                  </Typography>
                  <RemoveCircleIcon
                    sx={{ color: "red", cursor: "pointer" }}
                    onClick={() => removeLocation(index)}
                  />
                </Box>
              ))}
            </Box>
          )}
        </Box>

        {/* Submit Button */}
        <Button variant="contained" color="primary" onClick={handleSubmit}>
          Create Mission
        </Button>
      </Box>
    </Container>
  );
};

export default NewMission;
