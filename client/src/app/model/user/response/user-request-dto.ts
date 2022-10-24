// To specify the response object type, first define an interface with the required properties.
// Use an interface rather than a class, because the response is a plain object that cannot be automatically
// converted to an instance of a class.

export interface UserRequestDto {

  email: string;
  firstname: string;
  lastname: string;
  birthDay: Date;
  city: string;
  phone: string;

}
