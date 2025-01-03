
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
import useSwr from 'swr';

const EMPLOYEES_URL = "http://localhost:8081/api/employee/all";
const fetcher = (...args) => fetch(...args).then(response => response.json());

const StaffTable = () => {
    // State for search and filter
    const [searchTerm, setSearchTerm] = useState("");
    const [jobTitleFilter, setJobTitleFilter] = useState("");
    const [siteFilter, setSiteFilter] = useState("");

    const { data: employees, error: employeesError } = useSwr(EMPLOYEES_URL, fetcher);

    if (employees) {
      if (employees.status == 500) {
          return <div>Error loading data {JSON.stringify(employees)}</div>;
        }
    }

    if (!employees) {
        return <div>Loading employees...</div>;
    }

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
            ? emp.jobTitle.name.includes(jobTitleFilter)
            : true;
        const matchesSite = siteFilter ? emp.site === siteFilter : true;
        return matchesSearch && matchesSkill && matchesSite;
    });

    // Extract unique skills and sites for dropdown options
    const uniqueJobTitles = [...new Set(employees.map((emp) => emp.jobTitle.name))];
    const uniqueSites = [...new Set(employees.map((emp) => emp.site ? emp.site.name : null))];

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
                                                        {employee.jobTitle ? employee.jobTitle.name : ""}
                                                    </Typography>
                                                </Box>
                                            </Box>
                                        </TableCell>
                                        <TableCell>
                                            <Typography color="textSecondary" variant="subtitle2" fontWeight={400}>
                                                {employee.site ? employee.site.name : ""}
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
                                                label={employee.availabilityStatus ? employee.availabilityStatus.name : ""}
                                            ></Chip>
                                        </TableCell>
                                        <TableCell>
                                            <Typography variant="h6">{employee.phoneNumber}</Typography>
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
