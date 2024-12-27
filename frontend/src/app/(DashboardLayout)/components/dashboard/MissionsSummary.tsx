import React from "react";
import { Box, Grid, Typography } from "@mui/material";
import ListAltIcon from "@mui/icons-material/ListAlt";
import HourglassEmptyIcon from "@mui/icons-material/HourglassEmpty";
import CheckCircleIcon from "@mui/icons-material/CheckCircle";
import CancelIcon from "@mui/icons-material/Cancel";

// Define the props type
interface StatsComponentProps {
  totalMissions: number;
  pendingMissions: number;
  completedMissions: number;
  cancelledMissions: number;
}

const StatsComponent: React.FC<StatsComponentProps> = ({
  totalMissions,
  pendingMissions,
  completedMissions,
  cancelledMissions,
}) => {
  return (
    <Box>
      <Grid container spacing={3}>
        <Grid item xs={12} lg={3}>
          <Box textAlign="center">
            <ListAltIcon color="primary" fontSize="large" />
            <Typography variant="h3" marginTop={2}>
              Total Missions
            </Typography>
            <Typography variant="h6" marginTop={1}>
              {totalMissions}
            </Typography>
          </Box>
        </Grid>
        <Grid item xs={12} lg={3}>
          <Box textAlign="center">
            <HourglassEmptyIcon color="warning" fontSize="large" />
            <Typography variant="h3" marginTop={2}>
              Pending
            </Typography>
            <Typography variant="h6" marginTop={1}>
              {pendingMissions}
            </Typography>
          </Box>
        </Grid>
        <Grid item xs={12} lg={3}>
          <Box textAlign="center">
            <CheckCircleIcon color="success" fontSize="large" />
            <Typography variant="h3" marginTop={2}>
              Completed
            </Typography>
            <Typography variant="h6" marginTop={1}>
              {completedMissions}
            </Typography>
          </Box>
        </Grid>
        <Grid item xs={12} lg={3}>
          <Box textAlign="center">
            <CancelIcon color="error" fontSize="large" />
            <Typography variant="h3" marginTop={2}>
              Cancelled
            </Typography>
            <Typography variant="h6" marginTop={1}>
              {cancelledMissions}
            </Typography>
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
};

export default StatsComponent;
