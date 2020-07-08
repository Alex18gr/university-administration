export class Announcement {
  announcementId: number;
  departmentName: string;
  title: string;
  content: string;
  insDate: Date;
  creator: {
    employeeId: string,
    name: string,
    surname: string,
    email: string,
    phone: string,
    siteUrl: string,
    title: string
  };
}
