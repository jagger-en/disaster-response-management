'use client'
import { Grid, Box } from '@mui/material';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
// components
import MissionsChart from '@/app/(DashboardLayout)/components/dashboard/MissionsChart';
import MissionsSummary from '@/app/(DashboardLayout)/components/dashboard/MissionsSummary';
import MissionsTable from '@/app/(DashboardLayout)/missions/MissionsTable';
import MissionsTimeline from '@/app/(DashboardLayout)/components/dashboard/MissionsTimeline';
import OverviewMap from '@/app/(DashboardLayout)/components/dashboard/OverviewMap';
import useSwr from 'swr';

const MISSION_SUMMARY_URL = "http://localhost:8081/api/mission-summaries/all";
const fetcher = (...args) => fetch(...args).then(response => response.json());

const Dashboard = () => {
  const { data: missionSummaries, error: missionSummariesError } = useSwr(MISSION_SUMMARY_URL, fetcher);

  if (missionSummaries) {
    if (missionSummaries.status == 500) {
        return <div>Error loading data {JSON.stringify(missionSummaries)}</div>;
      }
  }

  if (!missionSummaries) {
      return <div>Loading mission summaries...</div>;
  }

  // Aggregate statistics
  const totalMissions = missionSummaries.length;
  const completedMissions = missionSummaries.filter(
      (item) => item.statusName.toUpperCase() === "COMPLETED"
  ).length;
  const cancelledMissions = missionSummaries.filter(
      (item) => item.statusName.toUpperCase() === "CANCELLED"
  ).length;
  const pendingMissions = missionSummaries.filter(
      (item) => item.statusName.toUpperCase() === "PENDING"
  ).length;

  return (
    <PageContainer title="D.R.M dashboard" description="this is the Dashboard">
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
            <MissionsTable missions={missionSummaries} />
          </Grid>
        </Grid>
      </Box>
    </PageContainer>
  )
}

export default Dashboard;
