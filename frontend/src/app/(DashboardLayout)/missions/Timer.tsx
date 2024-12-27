"use client";

import React, { useEffect, useState } from "react";
import { Box, Typography, Grid, Paper } from "@mui/material";

interface TimerProps {
  targetDate: Date;
}

const Timer: React.FC<TimerProps> = ({ targetDate }) => {
  const [timeRemaining, setTimeRemaining] = useState<{
    days: number;
    hours: number;
    minutes: number;
    seconds: number;
  }>({
    days: 0,
    hours: 0,
    minutes: 0,
    seconds: 0,
  });

  useEffect(() => {
    const calculateTimeRemaining = () => {
      const now = new Date().getTime();
      const target = new Date(targetDate).getTime();
      const difference = target - now;

      if (difference > 0) {
        setTimeRemaining({
          days: Math.floor(difference / (1000 * 60 * 60 * 24)),
          hours: Math.floor((difference / (1000 * 60 * 60)) % 24),
          minutes: Math.floor((difference / (1000 * 60)) % 60),
          seconds: Math.floor((difference / 1000) % 60),
        });
      } else {
        setTimeRemaining({
          days: 0,
          hours: 0,
          minutes: 0,
          seconds: 0,
        });
      }
    };

    const timer = setInterval(calculateTimeRemaining, 1000);
    return () => clearInterval(timer);
  }, [targetDate]);

  return (
    <Box
      display="flex"
      justifyContent="center"
      alignItems="center"
    >
      <Paper elevation={3} sx={{ padding: 4, textAlign: "center" }}>
        <Typography variant="h4" gutterBottom>
          Countdown Timer
        </Typography>
        <Grid container spacing={2} justifyContent="center">
          <Grid item xs={3}>
            <Box>
              <Typography variant="h5" color="primary">
                {timeRemaining.days}
              </Typography>
              <Typography variant="subtitle2">Days</Typography>
            </Box>
          </Grid>
          <Grid item xs={3}>
            <Box>
              <Typography variant="h5" color="secondary">
                {timeRemaining.hours}
              </Typography>
              <Typography variant="subtitle2">Hours</Typography>
            </Box>
          </Grid>
          <Grid item xs={3}>
            <Box>
              <Typography variant="h5" color="warning.main">
                {timeRemaining.minutes}
              </Typography>
              <Typography variant="subtitle2">Minutes</Typography>
            </Box>
          </Grid>
          <Grid item xs={3}>
            <Box>
              <Typography variant="h5" color="error">
                {timeRemaining.seconds}
              </Typography>
              <Typography variant="subtitle2">Seconds</Typography>
            </Box>
          </Grid>
        </Grid>
      </Paper>
    </Box>
  );
};

export default Timer;
