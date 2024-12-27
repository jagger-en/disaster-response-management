'use client';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
import { Typography, Box, Grid, Button } from '@mui/material';
import { useParams } from 'next/navigation';
import PersonnelTable from './PersonnelTable';
import DashboardCard from '@/app/(DashboardLayout)/components/shared/DashboardCard';
import Timer from '@/app/(DashboardLayout)/missions/Timer';
import Map, { Marker, MapRef } from "react-map-gl";
import "mapbox-gl/dist/mapbox-gl.css";
import { useState } from "react";

// Mapbox Access Token
const MAPBOX_TOKEN = process.env.NEXT_PUBLIC_MAPBOX_TOKEN;

const addSecondsToDate = (date: Date, seconds: number): Date => {
  const newDate = new Date(date);
  newDate.setSeconds(newDate.getSeconds() + seconds);
  return newDate;
};

const Mission = () => {
  const params = useParams();
  const { idx } = params; // Access the dynamic route parameter

  // Placeholder for mission data - replace this with actual fetch data in a real app
  // mission.personnel
  const personnel = [
    { id: "1", firstName: "John", lastName: "Doe", location: "Melbourne", phone: "111 222 333", status: "ACTIVE", statusBackground: "success.main" },
    { id: "2", firstName: "Jane", lastName: "Smith", location: "Sydney", phone: "111 222 444", status: "UNKNOWN", statusBackground: "secondary.main" },
  ];
  const ttl = 60 * 60 * 24; // 1 day

  const now = new Date();

  const originalTimerTargetDate = addSecondsToDate(now, ttl)

  const [timerTargetDate, setTimerTargetDate] = useState(originalTimerTargetDate);

  const handleTimerTargetDate = () => {
    const now = new Date();

    const newDate = addSecondsToDate(now, ttl)

    setTimerTargetDate(newDate)
  }

  return (
    <PageContainer title="Mission" description="Mission">
      <Box>
        <Grid container spacing={3}>
          <Grid item xs={12} lg={8}>
            <DashboardCard>
              <Box>
                <Typography variant="h1" sx={{marginBottom: 2}}>
                  Bushfire response
                </Typography>

                <Typography variant="body1" align="justify" paragraph="true">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin condimentum mattis augue nec posuere. Phasellus vel elit condimentum, gravida massa sit amet, fringilla leo. Mauris tincidunt vulputate massa et egestas. Maecenas consequat, arcu eget vulputate condimentum, sapien odio scelerisque mauris, vel convallis nunc felis a purus. Fusce eu tristique dui. Ut in consectetur tellus, vel fringilla justo. Sed augue libero, elementum quis auctor sit amet, semper vestibulum nisl. Duis vel felis libero. Ut sed nisl pulvinar sapien ullamcorper sagittis ac eu mauris. Donec faucibus sem eros, sed ornare lorem euismod sed. Duis ultricies elit urna, eget mollis nisi mollis ultricies. Donec et ullamcorper neque. Curabitur maximus nunc vitae pretium pharetra. Donec accumsan sodales risus quis auctor.
                </Typography>
              </Box>
            </DashboardCard>
          </Grid>
          <Grid item xs={12} lg={4}>
              <Timer targetDate={timerTargetDate} />
              <Button variant="contained" color="success" sx={{marginBottom: 3, marginTop: 3}}>Complete mission</Button>
              <Button variant="contained" color="primary" sx={{marginBottom: 3, marginTop: 3, marginLeft: 2}} onClick={handleTimerTargetDate}>Refresh timer</Button>

              <Map
                initialViewState={{
                  longitude: -120.5,
                  latitude: 38.5,
                  zoom: 10,
                }}
                style={{ width: "100%", height: 250 }}
                mapStyle="mapbox://styles/mapbox/streets-v11"
                mapboxAccessToken={MAPBOX_TOKEN}
              >

              </Map>
          </Grid>
          <Grid item xs={12} lg={12}>
            <PersonnelTable employees={personnel} />
          </Grid>
        </Grid>
      </Box>
    </PageContainer>
  );
};

export default Mission;
