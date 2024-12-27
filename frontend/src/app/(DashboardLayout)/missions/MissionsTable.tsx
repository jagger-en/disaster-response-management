
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
import HourglassEmptyIcon from '@mui/icons-material/HourglassEmpty';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import CancelIcon from '@mui/icons-material/Cancel';
import ListAltIcon from '@mui/icons-material/ListAlt';

interface Mission {
    id: string;
    name: string;
    status: string;
    statusBackground: string;
    location: string;
    description: string;
    personnelCount: number;
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
        status: "",
        statusBackground: "",
        location: "",
        description: "",
        personnelCount: 0,
    });
    const [locationSearchTerm, setLocationSearchTerm] = useState("");
    const [statusFilter, setStatusFilter] = useState("");

    const filteredMissions = missions.filter((item) => {
        const matchesNameSearch =
            item.name
                .toLowerCase()
                .includes(nameSearchTerm.toLowerCase());
        const matchesLocationSearch =
            item.location
                .toLowerCase()
                .includes(locationSearchTerm.toLowerCase());
        const matchesStatus = statusFilter ? item.status === statusFilter : true;
        return matchesNameSearch && matchesLocationSearch && matchesStatus;
    });

    const uniqueStatuses = [...new Set(missions.map((item) => item.status))];

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
                                            Name, Location
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Status
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Personnel
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
                                                        {mission.name}
                                                    </Typography>
                                                    <Typography
                                                        color="textSecondary"
                                                        sx={{
                                                            fontSize: "13px",
                                                        }}
                                                    >
                                                        {mission.location}
                                                    </Typography>
                                                </Box>
                                            </Box>
                                        </TableCell>
                                        <TableCell>
                                            <Typography color="textSecondary" variant="subtitle2" fontWeight={400}>
                                                {mission.personnelCount}
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
                                                label={mission.status}
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
                        {selectedMission.name}
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        {selectedMission.description}
                    </Typography>
                </Box>
            </Modal>
        </Box>
    );
};

export default MissionsTable;
