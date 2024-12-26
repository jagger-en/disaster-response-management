import React from "react";

const Home = () => {
  return (
    <div class="container news-container">
      <h1>Forest Fire Emergency Report</h1>
      <div class="section">
          <h2>Incident Overview</h2>
          <p>A forest fire has erupted near the small town of Greenvale, located at the foothills of the Pine Ridge Mountains. The fire began late last night due to suspected lightning strikes during a severe storm. The blaze has already consumed approximately 500 acres of woodland and is spreading rapidly due to strong winds.</p>
      </div>

      <div class="section">
          <h2>Current Response</h2>
          <p>Firefighters from Greenvale and neighboring counties have been deployed to the scene. Two aerial water bombers and ground crews are actively working to contain the blaze. Emergency services have established a perimeter around the affected area, and efforts are underway to protect nearby properties.</p>
      </div>

      <div class="section evacuation">
          <h2>Evacuation and Safety Measures</h2>
          <p>The following actions are needed to ensure the safety of residents and effective response to the fire:</p>
          <ul>
              <li><strong>Issue Evacuation Orders:</strong> Authorities need to immediately inform residents of Greenvale and surrounding areas to evacuate and provide clear instructions for safe routes.</li>
              <li><strong>Set Up Shelters:</strong> Temporary shelters should be established at Greenvale High School and the Pinewood Community Center to accommodate evacuees.</li>
              <li><strong>Provide Emergency Communication:</strong> Establish a hotline for evacuees and concerned relatives. A suggested number is <a href="tel:+18005551234">1-800-555-1234</a>.</li>
              <li><strong>Coordinate Traffic Management:</strong> Ensure roads near the fire zone are kept clear for emergency services and evacuating residents.</li>
          </ul>
      </div>

      <div class="section">
          <h2>Recommended Actions</h2>
          <p>To help mitigate the impact of the fire, authorities are recommending the following actions:</p>
          <ul>
              <li>Residents in nearby towns should prepare to evacuate if conditions worsen.</li>
              <li>Do not return to evacuated areas until authorities declare it safe.</li>
              <li>Avoid driving on roads near the fire zone to allow emergency services to operate efficiently.</li>
              <li>Stay informed by tuning into local news channels or visiting the official Greenvale town website.</li>
          </ul>
      </div>
  </div>
  );
};

export default Home;
