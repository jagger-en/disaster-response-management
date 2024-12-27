'use client';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
import MissionsSummary from '@/app/(DashboardLayout)/components/dashboard/MissionsSummary';
import MissionsTable from './MissionsTable';
import { useState } from "react";
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


const MissionsPage = () => {
  const missions = [
    { id: "1",
      name: "Bushfire Response",
      status: "CANCELLED",
      statusBackground: "error.main",
      location: "Victoria",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque mollis sem eu dui suscipit tincidunt. Ut feugiat aliquam porttitor. Ut lacinia justo tellus, at rutrum sapien egestas eu. In ut.",
      personnelCount: 20 },
    { id: "2",
      name: "Flood Relief",
      status: "COMPLETED",
      statusBackground: "success.main",
      location: "New South Wales",
      description: "Quisque lobortis purus sit amet ex vestibulum maximus. Quisque at vehicula augue, non mattis sem. In hac habitasse platea dictumst. Nullam interdum, lectus quis dictum lobortis, tortor urna iaculis risus, eget molestie massa elit sed mauris. Nullam in ex in mi tincidunt convallis. Nulla pulvinar facilisis risus et maximus. Phasellus vel luctus diam. Cras velit libero, fringilla sed lacus in, maximus blandit metus. Mauris vitae venenatis neque. In.",
      personnelCount: 15 },
    { id: "3",
      name: "Earthquake Rescue",
      status: "PENDING",
      statusBackground: "warning.main",
      location: "Tasmania",
      description: "Quisque lobortis purus sit amet ex vestibulum maximus. Quisque at vehicula augue, non mattis sem. In hac habitasse platea dictumst. Nullam interdum, lectus quis dictum lobortis, tortor urna iaculis risus, eget molestie massa elit sed mauris. Nullam in ex in mi tincidunt convallis. Nulla pulvinar facilisis risus et maximus. Phasellus vel luctus diam. Cras velit libero, fringilla sed lacus in, maximus blandit metus. Mauris vitae venenatis neque. In.",
      personnelCount: 25 },
    { id: "4",
      name: "Tsunami Rescue",
      status: "PENDING",
      statusBackground: "warning.main",
      location: "FooBarBuzz",
      description: "Nulla pulvinar facilisis risus et maximus. Phasellus vel luctus diam. Cras velit libero, fringilla sed lacus in, maximus blandit metus. Mauris vitae venenatis neque. In.",
      personnelCount: 50 },
  ];

  const [open, setOpen] = useState(false);
  const handleOpen = () => {
      setOpen(true);
  };
  const handleClose = () => setOpen(false);

  // Aggregate statistics
  const totalMissions = missions.length;
  const completedMissions = missions.filter(
      (item) => item.status === "COMPLETED"
  ).length;
  const cancelledMissions = missions.filter(
      (item) => item.status === "CANCELLED"
  ).length;
  const pendingMissions = missions.filter(
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
        <MissionsTable missions={missions} />
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
