'use client';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
import MissionsSummary from '@/app/(DashboardLayout)/components/dashboard/MissionsSummary';
import MissionsTable from './MissionsTable';
import { useState } from "react";
import useSwr from 'swr';
import {
  Typography, Box, Button,
  Modal,
} from '@mui/material';
import NewMission from './NewMission';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 800,
  height: '50vh',
  overflow: 'auto',
  borderRadius: '15px',
  bgcolor: 'background.paper',
  p: 4,
};

const MISSION_SUMMARY_URL = "http://localhost:8081/api/mission-summaries/all";
const fetcher = (...args) => fetch(...args).then(response => response.json());



const MissionsPage = () => {
  const { data: missionSummaries, error: missionSummariesError } = useSwr(MISSION_SUMMARY_URL, fetcher);

  if (missionSummaries) {
    if (missionSummaries.status == 500) {
        return <div>Error loading data {JSON.stringify(missionSummaries)}</div>;
      }
  }

  if (!missionSummaries) {
      return <div>Loading mission summaries...</div>;
  }

  const [open, setOpen] = useState(false);
  const handleOpen = () => {
      setOpen(true);
  };
  const handleClose = () => setOpen(false);

  // Aggregate statistics
  const totalMissions = missionSummaries.length;
  const completedMissions = missionSummaries.filter(
      (item) => item.status === "COMPLETED"
  ).length;
  const cancelledMissions = missionSummaries.filter(
      (item) => item.status === "CANCELLED"
  ).length;
  const pendingMissions = missionSummaries.filter(
      (item) => item.status === "PENDING"
  ).length;

  return (
    <PageContainer title="Missions" description="Missions">
      <MissionsSummary
        totalMissions={totalMissions}
        completedMissions={completedMissions}
        cancelledMissions={cancelledMissions}
        pendingMissions={pendingMissions} />
      <Box sx={{marginTop: 5}}>
        <MissionsTable missions={missionSummaries} />
      </Box>
      <Button color="primary" size="medium" variant="outlined" sx={{marginTop: 2}} onClick={() => handleOpen()}>New mission</Button>
      <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
          slotProps={{
              backdrop: {
                  sx: {
                      backgroundColor: 'rgba(0, 0, 0, 0.7)',
                  },
              }
          }}
      >
          <Box sx={style}>
              <Typography id="modal-modal-title" variant="h6" component="h2">
                  New Mission
              </Typography>
              <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                  <NewMission />
              </Typography>
          </Box>
      </Modal>
    </PageContainer>
  );
};

export default MissionsPage;
