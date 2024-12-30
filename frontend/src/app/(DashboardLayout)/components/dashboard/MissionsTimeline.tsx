
import DashboardCard from '@/app/(DashboardLayout)/components/shared/DashboardCard';
import {
  Timeline,
  TimelineItem,
  TimelineOppositeContent,
  TimelineSeparator,
  TimelineDot,
  TimelineConnector,
  TimelineContent,
  timelineOppositeContentClasses,
} from '@mui/lab';
import useSwr from 'swr';

const MISSION_TIMELINE_ITEMS_URL = "http://localhost:8081/api/mission-timeline-items/all";
const fetcher = async (...args) => {
  const res = await fetch(...args);
  if (!res.ok) {
    throw new Error(`HTTP error! Status: ${res.status}`);
  }
  return res.json();
};

const MissionsTimeline = () => {
  const { data: missionTimelineItems, error: missionTimelineItemsError } = useSwr(MISSION_TIMELINE_ITEMS_URL, fetcher);

  if (missionTimelineItems) {
    if (missionTimelineItems.status == 500) {
        return <div>Error loading data {JSON.stringify(missionTimelineItems)}</div>;
      }
  }

  if (!missionTimelineItems) {
      return <div>Loading mission and status...</div>;
  }

  return (
    <DashboardCard title="Missions timeline">
      <>
        <Timeline
          className="theme-timeline"
          nonce={undefined}
          onResize={undefined}
          onResizeCapture={undefined}
          sx={{
            p: 0,
            mb: '-40px',
            '& .MuiTimelineConnector-root': {
              width: '1px',
              backgroundColor: '#efefef'
            },
            [`& .${timelineOppositeContentClasses.root}`]: {
              flex: 0.5,
              paddingLeft: 0,
            },
          }}
        >
        {missionTimelineItems.map((item, idx) => (
          <TimelineItem key={item.id}>
            <TimelineOppositeContent>{item.assignmentDate.replace("T", " ")}</TimelineOppositeContent>
            <TimelineSeparator>
              <TimelineDot color={item.statusBackground.split(".")[0]} variant="outlined" />
              {(idx == missionTimelineItems.length - 1) ? "" : <TimelineConnector />}
            </TimelineSeparator>
            <TimelineContent>{item.missionName}</TimelineContent>
          </TimelineItem>
        ))}
        </Timeline>
      </>
    </DashboardCard>
  );
};

export default MissionsTimeline;
