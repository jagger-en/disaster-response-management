'use client';
import PageContainer from '@/app/(DashboardLayout)/components/container/PageContainer';
import StaffTable from './table';

const StaffPage = () => {
  return (
    <PageContainer title="Staff" description="Staff">
      <StaffTable />
    </PageContainer>
  );
};

export default StaffPage;
