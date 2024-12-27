'use client'
import { Grid, Box } from '@mui/material';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
// components
import MissionsChart from '@/app/(DashboardLayout)/components/dashboard/MissionsChart';
import MissionsSummary from '@/app/(DashboardLayout)/components/dashboard/MissionsSummary';
import MissionsTable from '@/app/(DashboardLayout)/missions/MissionsTable';
import MissionsTimeline from '@/app/(DashboardLayout)/components/dashboard/MissionsTimeline';
import OverviewMap from '@/app/(DashboardLayout)/components/dashboard/OverviewMap';

const Dashboard = () => {
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
    <PageContainer title="Dashboard" description="this is Dashboard">
      <Box>
        <Grid container spacing={3}>
          <Grid item xs={12} lg={12}>
            <MissionsSummary
              totalMissions={totalMissions}
              completedMissions={completedMissions}
              cancelledMissions={cancelledMissions}
              pendingMissions={pendingMissions} />
          </Grid>
          <Grid item xs={12} lg={6}>
            <OverviewMap />
          </Grid>
          <Grid item xs={12} lg={6}>
            <MissionsChart />
          </Grid>
          <Grid item xs={12} lg={4}>
            <MissionsTimeline />
          </Grid>
          <Grid item xs={12} lg={8}>
            <MissionsTable missions={missions} />
          </Grid>
        </Grid>
      </Box>
    </PageContainer>
  )
}

export default Dashboard;
