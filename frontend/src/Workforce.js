import React, { useState } from "react";
import "@fortawesome/fontawesome-free/css/all.min.css";

const Workforce = () => {
  // Example employee data
  const employees = [
    {
      firstName: "John",
      lastName: "Doe",
      jobTitle: "Software Engineer",
      site: "New York",
      status: "Available",
      phone: "123-456-7890",
    },
    {
      firstName: "Jane",
      lastName: "Smith",
      jobTitle: "Software Engineer",
      site: "San Francisco",
      status: "Unavailable",
      phone: "987-654-3210",
    },
    {
      firstName: "Alice",
      lastName: "Brown",
      jobTitle: "Data Scientist",
      site: "New York",
      status: "Available",
      phone: "555-666-7777",
    },
    {
      firstName: "Bob",
      lastName: "Johnson",
      jobTitle: "Technician",
      site: "Austin",
      status: "Unavailable",
      phone: "444-333-2222",
    },
    {
      firstName: "Michael",
      lastName: "Davis",
      jobTitle: "System Administrator",
      site: "New York",
      status: "Available",
      phone: "321-654-9870",
    },
    {
      firstName: "Emily",
      lastName: "Clark",
      jobTitle: "UX Designer",
      site: "Austin",
      status: "Available",
      phone: "789-123-4560",
    },
    {
      firstName: "David",
      lastName: "Miller",
      jobTitle: "Electrical Engineer",
      site: "San Francisco",
      status: "Unavailable",
      phone: "555-888-9999",
    },
    {
      firstName: "Sophia",
      lastName: "Taylor",
      jobTitle: "Human Resources",
      site: "Austin",
      status: "Available",
      phone: "222-444-6666",
    },
    {
      firstName: "James",
      lastName: "Anderson",
      jobTitle: "Software Architect",
      site: "New York",
      status: "Unavailable",
      phone: "987-111-2222",
    },
    {
      firstName: "Olivia",
      lastName: "Martinez",
      jobTitle: "QA Engineer",
      site: "San Francisco",
      status: "Available",
      phone: "333-777-8888",
    },
  ];

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
    <div className="dashboard" style={{ fontFamily: "Arial, sans-serif", margin: "20px" }}>
      {/* Summary Statistics */}
      <div style={{ display: "flex", justifyContent: "space-around", marginBottom: "20px" }}>
        <div>
          <i className="fas fa-users fa-2x" style={{ color: "#4caf50" }}></i>
          <h3>Total workforce</h3>
          <p>{totalEmployees}</p>
        </div>
        <div>
          <i className="fas fa-user-check fa-2x" style={{ color: "#2196f3" }}></i>
          <h3>Available</h3>
          <p>{availableEmployees}</p>
        </div>
        <div>
          <i className="fas fa-user-times fa-2x" style={{ color: "#f44336" }}></i>
          <h3>Unavailable</h3>
          <p>{unavailableEmployees}</p>
        </div>
      </div>

      {/* Filters */}
      <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
        <input
          type="text"
          placeholder="Search by name"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          style={{ padding: "10px", width: "200px" }}
        />
        <select
          value={jobTitleFilter}
          onChange={(e) => setJobTitleFilter(e.target.value)}
          style={{ padding: "10px", width: "200px" }}
        >
          <option value="">Filter by Job Title</option>
          {uniqueJobTitles.map((skill) => (
            <option key={skill} value={skill}>
              {skill}
            </option>
          ))}
        </select>
        <select
          value={siteFilter}
          onChange={(e) => setSiteFilter(e.target.value)}
          style={{ padding: "10px", width: "200px" }}
        >
          <option value="">Filter by site</option>
          {uniqueSites.map((site) => (
            <option key={site} value={site}>
              {site}
            </option>
          ))}
        </select>
      </div>

      {/* Staff list */}
      <div>
        <h2>Staff list</h2>
        <table style={{ width: "100%", borderCollapse: "collapse" }}>
          <thead>
            <tr>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Name</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Job Title</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Site</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Status</th>
              <th style={{ border: "1px solid #ddd", padding: "8px" }}>Phone</th>
            </tr>
          </thead>
          <tbody>
            {filteredEmployees.map((emp, index) => (
              <tr key={index}>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>
                  {emp.firstName} {emp.lastName}
                </td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{emp.jobTitle}</td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{emp.site}</td>
                <td
                  style={{
                    border: "1px solid #ddd",
                    padding: "8px",
                    color: emp.status === "Available" ? "green" : "red",
                  }}
                >
                  {emp.status}
                </td>
                <td style={{ border: "1px solid #ddd", padding: "8px" }}>{emp.phone}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Workforce;
