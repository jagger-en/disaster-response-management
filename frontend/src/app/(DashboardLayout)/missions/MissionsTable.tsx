
import {
    Typography, Box, IconButton,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    TextField,
    MenuItem,
    FormControl,
    InputLabel,
    Select,
    Modal,
    Chip
} from '@mui/material';
import SourceIcon from '@mui/icons-material/Source';
import OpenInNewIcon from '@mui/icons-material/OpenInNew';
import { useState } from "react";
import DashboardCard from '@/app/(DashboardLayout)//components/shared/DashboardCard';
import NLink from "next/link";

interface Mission {
    id: string;
    missionName: string;
    statusName: string;
    statusBackground: string;
    locationName: string;
    description: string;
    numEmployees: number;
}

interface Props {
    missions: Mission[];
}

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    borderRadius: '15px',
    bgcolor: 'background.paper',
    p: 4,
};

const MissionsTable: React.FC<Props> = ({ missions }) => {
    const [nameSearchTerm, setNameSearchTerm] = useState("");
    const [selectedMission, setSelectedMission] = useState({
        id: "",
        name: "",
        statusName: "",
        statusBackground: "",
        location: "",
        description: "",
        numEmployees: 0,
    });
    const [locationSearchTerm, setLocationSearchTerm] = useState("");
    const [statusFilter, setStatusFilter] = useState("");

    const filteredMissions = missions.filter((item) => {
        const matchesNameSearch =
            item.missionName
                .toLowerCase()
                .includes(nameSearchTerm.toLowerCase());
        const matchesLocationSearch =
            item.locationName
                .toLowerCase()
                .includes(locationSearchTerm.toLowerCase());
        const matchesStatus = statusFilter ? item.statusName === statusFilter : true;
        return matchesNameSearch && matchesLocationSearch && matchesStatus;
    });

    const uniqueStatuses = [...new Set(missions.map((item) => item.statusName))];

    const [open, setOpen] = useState(false);
    const handleOpen = (mission: Mission) => {
        setOpen(true);
        setSelectedMission(mission)
    };
    const handleClose = () => setOpen(false);

    return (
        <Box>
            <DashboardCard title="Missions">
                <div>
                    <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
                        <TextField
                            id="search-by-name"
                            sx={{ m: 1, minWidth: 120 }}
                            label="Search by name"
                            variant="standard"
                            value={nameSearchTerm}
                            onChange={(e) => setNameSearchTerm(e.target.value)}
                        />

                        <TextField
                            id="search-by-location"
                            sx={{ m: 1, minWidth: 120 }}
                            label="Search by location"
                            variant="standard"
                            value={locationSearchTerm}
                            onChange={(e) => setLocationSearchTerm(e.target.value)}
                        />

                        <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                            <InputLabel id="demo-simple-select-standard-label">Status</InputLabel>
                            <Select
                                labelId="demo-simple-select-standard-label"
                                id="demo-simple-select-standard"
                                value={statusFilter}
                                onChange={(e) => setStatusFilter(e.target.value)}
                                label="Status"
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                {uniqueStatuses.map((option) => (
                                    <MenuItem key={option} value={option}>
                                        {option}
                                    </MenuItem>
                                ))}
                            </Select>
                        </FormControl>
                    </div>

                    <Box sx={{ overflow: 'auto', height: '300px' }}>
                        <Table
                            aria-label="simple table"
                            sx={{
                                whiteSpace: "nowrap",
                                mt: 2
                            }}
                        >
                            <TableHead>
                                <TableRow>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Id
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Name, Locations
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Number of Personnel
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Status
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Details
                                        </Typography>
                                    </TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {filteredMissions.map((mission) => (
                                    <TableRow key={mission.id}>
                                        <TableCell>
                                            <Typography
                                                sx={{
                                                    fontSize: "15px",
                                                    fontWeight: "500",
                                                }}
                                            >
                                                {mission.id}
                                            </Typography>
                                        </TableCell>
                                        <TableCell>
                                            <Box
                                                sx={{
                                                    display: "flex",
                                                    alignItems: "center",
                                                }}
                                            >
                                                <Box>
                                                    <Typography variant="subtitle2" fontWeight={600}>
                                                        {mission.missionName}
                                                    </Typography>
                                                    <Typography
                                                        color="textSecondary"
                                                        sx={{
                                                            fontSize: "13px",
                                                        }}
                                                    >
                                                        {mission.locationName}
                                                    </Typography>
                                                </Box>
                                            </Box>
                                        </TableCell>
                                        <TableCell>
                                            <Typography color="textSecondary" variant="subtitle2" fontWeight={400}>
                                                {mission.numEmployees}
                                            </Typography>
                                        </TableCell>
                                        <TableCell>
                                            <Chip
                                                sx={{
                                                    px: "4px",
                                                    backgroundColor: mission.statusBackground,
                                                    color: "#fff",
                                                }}
                                                size="small"
                                                label={mission.statusName}
                                            ></Chip>
                                        </TableCell>
                                        <TableCell>
                                            <Typography variant="h6">
                                                <IconButton color="primary" size="small" onClick={() => handleOpen(mission)}><SourceIcon /></IconButton>
                                                <NLink href={`/missions/${mission.id}`} target="_blank">
                                                    <IconButton color="primary" size="small">
                                                        <OpenInNewIcon />
                                                    </IconButton>
                                                </NLink>
                                            </Typography>
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </Box>
                </div>
            </DashboardCard>
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
                        {selectedMission.missionName}
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        {selectedMission.missionDescription}
                    </Typography>
                </Box>
            </Modal>
        </Box>
    );
};

export default MissionsTable;
