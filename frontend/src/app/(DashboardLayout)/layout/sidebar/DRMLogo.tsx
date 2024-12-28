
import { Box, Typography } from "@mui/material";

const DRMLogo = () => {
  return (
    <Box
        sx={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        padding: 2,
        }}
    >
        <Box
        component="img"
        src="/images/logos/drm-logo.png"
        alt="DRM Logo"
        sx={{
            width: '100%',
            height: 'auto',
            marginRight: 2,
            maxWidth: 50, // Optional: limit max width
            objectFit: 'contain', // Ensures the image scales proportionally
        }}
        />

        <Typography variant="h5">Disaster response management</Typography>
    </Box>
  );
};

export default DRMLogo;
