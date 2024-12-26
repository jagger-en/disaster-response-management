
import {
    Typography, Box,
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
    Icon,
    Chip
} from '@mui/material';
import PeopleIcon from '@mui/icons-material/People';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import CancelIcon from '@mui/icons-material/Cancel';
import { useState } from "react";
import DashboardCard from '@/app/(DashboardLayout)//components/shared/DashboardCard';

const employees = [
    {
        id: "1",
        firstName: "John",
        lastName: "Doe",
        jobTitle: "Software Engineer",
        site: "New York",
        status: "Available",
        statusBackground: "success.main",
        phone: "123-456-7890",
    },
    {
        id: "2",
        firstName: "Jane",
        lastName: "Smith",
        jobTitle: "Software Engineer",
        site: "San Francisco",
        status: "Unavailable",
        statusBackground: "error.main",
        phone: "987-654-3210",
    },
    {
        id: "3",
        firstName: "Alice",
        lastName: "Brown",
        jobTitle: "Data Scientist",
        site: "New York",
        status: "Available",
        statusBackground: "success.main",
        phone: "555-666-7777",
    },
    {
        id: "4",
        firstName: "Bob",
        lastName: "Johnson",
        jobTitle: "Technician",
        site: "Austin",
        status: "Unavailable",
        statusBackground: "error.main",
        phone: "444-333-2222",
    },
    {
        id: "5",
        firstName: "Michael",
        lastName: "Davis",
        jobTitle: "System Administrator",
        site: "New York",
        status: "Available",
        statusBackground: "success.main",
        phone: "321-654-9870",
    },
    {
        id: "6",
        firstName: "Emily",
        lastName: "Clark",
        jobTitle: "UX Designer",
        site: "Austin",
        status: "Available",
        statusBackground: "success.main",
        phone: "789-123-4560",
    },
    {
        id: "7",
        firstName: "David",
        lastName: "Miller",
        jobTitle: "Electrical Engineer",
        site: "San Francisco",
        status: "Unavailable",
        statusBackground: "error.main",
        phone: "555-888-9999",
    },
    {
        id: "8",
        firstName: "Sophia",
        lastName: "Taylor",
        jobTitle: "Human Resources",
        site: "Austin",
        status: "Available",
        statusBackground: "success.main",
        phone: "222-444-6666",
    },
    {
        id: "9",
        firstName: "James",
        lastName: "Anderson",
        jobTitle: "Software Architect",
        site: "New York",
        status: "Unavailable",
        statusBackground: "error.main",
        phone: "987-111-2222",
    },
    {
        id: "10",
        firstName: "Olivia",
        lastName: "Martinez",
        jobTitle: "QA Engineer",
        site: "San Francisco",
        status: "Available",
        statusBackground: "success.main",
        phone: "333-777-8888",
    },
];

const StaffTable = () => {
    // State for search and filter
    const [searchTerm, setSearchTerm] = useState("");
    const [jobTitleFilter, setJobTitleFilter] = useState("");
    const [siteFilter, setSiteFilter] = useState("");

    // Aggregate statistics
    const totalEmployees = employees.length;
    const availableEmployees = employees.filter(
        (emp) => emp.status === "Available"
    ).length;
    const unavailableEmployees = totalEmployees - availableEmployees;

    // Filter employees based on search and dropdown
    const filteredEmployees = employees.filter((emp) => {
        const matchesSearch =
            `${emp.firstName} ${emp.lastName}`
                .toLowerCase()
                .includes(searchTerm.toLowerCase());
        const matchesSkill = jobTitleFilter
            ? emp.jobTitle.includes(jobTitleFilter)
            : true;
        const matchesSite = siteFilter ? emp.site === siteFilter : true;
        return matchesSearch && matchesSkill && matchesSite;
    });

    // Extract unique skills and sites for dropdown options
    const uniqueJobTitles = [...new Set(employees.map((emp) => emp.jobTitle))];
    const uniqueSites = [...new Set(employees.map((emp) => emp.site))];

    return (
        <div>
            <div style={{ display: "flex", justifyContent: "space-around", marginBottom: "20px" }}>
                <div>
                    <PeopleIcon color="primary" fontSize="large" />
                    <Typography variant="h3">Total workforce</Typography>
                    <Typography marginTop={1}>{totalEmployees}</Typography>
                </div>
                <div>
                    <CheckCircleIcon color="success" fontSize="large" />
                    <Typography variant="h3">Available</Typography>
                    <Typography marginTop={1}>{availableEmployees}</Typography>
                </div>
                <div>
                    <CancelIcon color="error" fontSize="large" />
                    <Typography variant="h3">Unavailable</Typography>
                    <Typography marginTop={1}>{unavailableEmployees}</Typography>
                </div>
            </div>

            <DashboardCard title="Staff">
                <div>
                    <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
                        <TextField
                            id="search-by-name"
                            sx={{ m: 1, minWidth: 120 }}
                            label="Search by name"
                            variant="standard"
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                        />

                        <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                            <InputLabel id="demo-simple-select-standard-label">Job title</InputLabel>
                            <Select
                                labelId="demo-simple-select-standard-label"
                                id="demo-simple-select-standard"
                                value={jobTitleFilter}
                                onChange={(e) => setJobTitleFilter(e.target.value)}
                                label="Job title"
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                {uniqueJobTitles.map((option) => (
                                    <MenuItem key={option} value={option}>
                                        {option}
                                    </MenuItem>
                                ))}
                            </Select>
                        </FormControl>

                        <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                            <InputLabel id="demo-simple-select-standard-label">Site</InputLabel>
                            <Select
                                labelId="demo-simple-select-standard-label"
                                id="demo-simple-select-standard"
                                value={siteFilter}
                                onChange={(e) => setSiteFilter(e.target.value)}
                                label="Site"
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                {uniqueSites.map((option) => (
                                    <MenuItem key={option} value={option}>
                                        {option}
                                    </MenuItem>
                                ))}
                            </Select>
                        </FormControl>
                    </div>

                    <Box sx={{ overflow: 'auto', width: { xs: '280px', sm: 'auto' } }}>
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
                                            Name, Job Title
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Site
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Status
                                        </Typography>
                                    </TableCell>
                                    <TableCell>
                                        <Typography variant="subtitle2" fontWeight={600}>
                                            Phone
                                        </Typography>
                                    </TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {filteredEmployees.map((employee) => (
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
                                                        {employee.jobTitle}
                                                    </Typography>
                                                </Box>
                                            </Box>
                                        </TableCell>
                                        <TableCell>
                                            <Typography color="textSecondary" variant="subtitle2" fontWeight={400}>
                                                {employee.site}
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
                                            <Typography variant="h6">{employee.phone}</Typography>
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </Box>
                </div>
            </DashboardCard>
        </div>
    );
};

export default StaffTable;
