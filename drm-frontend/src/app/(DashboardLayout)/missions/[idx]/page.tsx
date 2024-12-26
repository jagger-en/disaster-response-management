'use client';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
import { Typography, Box, Grid } from '@mui/material';
import { useParams } from 'next/navigation';
import PersonnelTable from './PersonnelTable';
import DashboardCard from '@/app/(DashboardLayout)//components/shared/DashboardCard';

const Mission = () => {
  const params = useParams();
  const { idx } = params; // Access the dynamic route parameter

  // Placeholder for mission data - replace this with actual fetch data in a real app
  // mission.personnel
  const personnel = [
    { id: "1", firstName: "John", lastName: "Doe", location: "Melbourne", phone: "111 222 333", status: "ACTIVE", statusBackground: "success.main" },
    { id: "2", firstName: "Jane", lastName: "Smith", location: "Sydney", phone: "111 222 444", status: "UNKNOWN", statusBackground: "secondary.main" },
  ];

  return (
    <PageContainer title="Mission" description="Mission">
      <Box>
        <Grid container spacing={3}>
          <Grid item xs={12} lg={8}>
            <DashboardCard>
              <Box>
                <Typography variant="h1" sx={{marginBottom: 2}}>
                  Bushfire response
                </Typography>

                <Typography variant="body1" align="justify" paragraph="true">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin condimentum mattis augue nec posuere. Phasellus vel elit condimentum, gravida massa sit amet, fringilla leo. Mauris tincidunt vulputate massa et egestas. Maecenas consequat, arcu eget vulputate condimentum, sapien odio scelerisque mauris, vel convallis nunc felis a purus. Fusce eu tristique dui. Ut in consectetur tellus, vel fringilla justo. Sed augue libero, elementum quis auctor sit amet, semper vestibulum nisl. Duis vel felis libero. Ut sed nisl pulvinar sapien ullamcorper sagittis ac eu mauris. Donec faucibus sem eros, sed ornare lorem euismod sed. Duis ultricies elit urna, eget mollis nisi mollis ultricies. Donec et ullamcorper neque. Curabitur maximus nunc vitae pretium pharetra. Donec accumsan sodales risus quis auctor.
                </Typography>

                <Typography variant="body1" align="justify" paragraph="true">
                  Donec congue rutrum erat id fringilla. Donec tellus quam, vulputate et metus nec, convallis elementum sem. Quisque facilisis ipsum id elementum malesuada. In lobortis, sem sit amet iaculis vehicula, diam diam ornare quam, eget ultricies augue metus in elit. Mauris varius odio et magna egestas, sed rutrum mi efficitur. In in nunc volutpat, fringilla elit vel, molestie mauris. Sed id semper sapien. Sed malesuada, libero nec suscipit maximus, nisi lectus faucibus justo, at luctus est eros at elit. Cras urna elit, finibus at sem a, imperdiet viverra eros. Sed bibendum placerat mauris ac vestibulum.
                </Typography>

                <Typography variant="body1" align="justify" paragraph="true">
                  Praesent ligula urna, dapibus in arcu vitae, molestie eleifend lacus. Morbi eget rhoncus mi. Aenean rhoncus mi porta accumsan faucibus. In vitae finibus odio. Donec gravida eleifend massa, sit amet placerat ex sagittis sed. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean mollis enim nec ultricies lobortis. Donec pharetra euismod rutrum. Proin tincidunt lacinia mauris vitae vulputate. Donec eu sem vitae quam finibus fringilla. Duis vel augue libero. Aenean id ultricies purus, id luctus nunc. Nullam ex eros, rutrum pellentesque quam sit amet, rutrum porta ipsum. Aliquam cursus dolor ac massa congue, at lobortis urna consectetur. Ut ac orci vestibulum, fermentum leo quis, congue libero.
                </Typography>

                <Typography variant="body1" align="justify" paragraph="true">
                  Duis hendrerit neque eget lectus gravida, at maximus purus pellentesque. Curabitur in dolor cursus, consequat neque at, pretium lectus. Nulla non condimentum velit. Fusce id magna ultrices lorem lobortis suscipit ornare non sapien. Sed ullamcorper mauris vel sapien venenatis scelerisque. Curabitur consequat nisl dolor, eu luctus leo posuere ac. Integer id massa tortor. Praesent rhoncus sit amet massa eu posuere. Maecenas sagittis ex eu arcu iaculis, venenatis tincidunt enim vulputate.
                </Typography>

                <Typography variant="body1" align="justify" paragraph="true">
                  Nulla ac condimentum lacus. Phasellus dapibus enim lorem, bibendum sollicitudin quam egestas quis. Nunc venenatis accumsan dolor, eu rhoncus elit efficitur a. Nulla ac tortor at tellus facilisis tristique. Suspendisse eu dui sed diam fermentum hendrerit et sit amet ipsum. Pellentesque placerat ornare risus sit amet volutpat. Vestibulum viverra scelerisque ligula in hendrerit. Etiam placerat tellus sit amet turpis luctus, a condimentum massa sodales. Duis vitae nunc viverra, lacinia justo et, aliquam velit. Curabitur sit amet nulla laoreet, condimentum ex in, iaculis risus. Suspendisse purus mi, facilisis nec tincidunt tempus, scelerisque et neque. Suspendisse potenti. Sed tempor neque a lorem eleifend hendrerit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                </Typography>
              </Box>
            </DashboardCard>
          </Grid>
          <Grid item xs={12} lg={4}>
            QR Code goes here
          </Grid>
          <Grid item xs={12} lg={8}>
            <PersonnelTable employees={personnel} />
          </Grid>
        </Grid>
      </Box>
    </PageContainer>
  );
};

export default Mission;
