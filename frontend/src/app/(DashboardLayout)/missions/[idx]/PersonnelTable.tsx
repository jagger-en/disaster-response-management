
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
import { useRouter } from 'next/router';

interface Employee {
    id: string;
    firstName: string;
    lastName: string;
    location: string;
    status: string;
    statusBackground: string;
    phone: string;
}

interface Props {
    employees: Employee[];
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

const PersonnelTable: React.FC<Props> = ({ employees }) => {
    const [nameSearchTerm, setNameSearchTerm] = useState("");
    const [selectedEmployee, setSelectedEmployee] = useState({
        id: "",
        firstName: "",
        lastName: "",
        location: "",
        status: "",
        statusBackground: "",
        phone: "",
    });
    const [locationSearchTerm, setLocationSearchTerm] = useState("");
    const [statusFilter, setStatusFilter] = useState("");

    const filteredPersonnel = employees.filter((item) => {
        const matchesNameSearch =
            `${item.firstName} ${item.lastName}`
                .toLowerCase()
                .includes(nameSearchTerm.toLowerCase());
        const matchesLocationSearch =
            item.location
                .toLowerCase()
                .includes(locationSearchTerm.toLowerCase());
        const matchesStatus = statusFilter ? item.status === statusFilter : true;
        return matchesNameSearch && matchesLocationSearch && matchesStatus;
    });

    const uniqueStatuses = [...new Set(employees.map((item) => item.status))];

    const [open, setOpen] = useState(false);
    const handleOpen = (employee: Employee) => {
        setOpen(true);
        setSelectedEmployee(employee)
    };
    const handleClose = () => setOpen(false);

    return (
        <Box>
            <DashboardCard title="Personnel">
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
                                            Phone
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
                                {filteredPersonnel.map((employee) => (
                                    <TableRow key={employee.id}>
                                        <TableCell>
                                            <Typography
                                                sx={{
                                                    fontSize: "15px",
                                                    fontWeight: "500",
                                                }}
                                            >
                                                {employee.id}
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
                                                        {employee.firstName} {employee.lastName}
                                                    </Typography>
                                                    <Typography
                                                        color="textSecondary"
                                                        sx={{
                                                            fontSize: "13px",
                                                        }}
                                                    >
                                                        {employee.location}
                                                    </Typography>
                                                </Box>
                                            </Box>
                                        </TableCell>
                                        <TableCell>
                                            <Typography color="textSecondary" variant="subtitle2" fontWeight={400}>
                                                {employee.phone}
                                            </Typography>
                                        </TableCell>
                                        <TableCell>
                                            <Chip
                                                sx={{
                                                    px: "4px",
                                                    backgroundColor: employee.statusBackground,
                                                    color: "#fff",
                                                }}
                                                size="small"
                                                label={employee.status}
                                            ></Chip>
                                        </TableCell>
                                        <TableCell>
                                            <Typography variant="h6">
                                                <IconButton color="primary" size="small" onClick={() => handleOpen(employee)}><SourceIcon /></IconButton>
                                                <NLink href={`/employees/${employee.id}`} target="_blank">
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
                        {selectedEmployee.firstName} {selectedEmployee.lastName}
                        <Chip
                            sx={{
                                px: "4px",
                                backgroundColor: selectedEmployee.statusBackground,
                                color: "#fff",
                                ml: 2,
                            }}
                            size="small"
                            label={selectedEmployee.status}
                        ></Chip>
                    </Typography>
                    <Typography id="modal-modal-location" sx={{ mt: 2 }}>
                        {selectedEmployee.location}
                    </Typography>
                    <Typography id="modal-modal-phone" sx={{ mt: 2 }}>
                        {selectedEmployee.phone}
                    </Typography>
                </Box>
            </Modal>
        </Box>
    );
};

export default PersonnelTable;
