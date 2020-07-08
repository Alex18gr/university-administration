export class CourseRegistration {
  registryNumber: string;
  name: string;
  mark: number;
  professors: {
    name: string,
    surname: string,
    email: string,
    title: string,
    url: string;
  };
}
