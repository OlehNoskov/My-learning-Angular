import { ResponseDto } from "./response.dto";

export interface UserRequestDto extends ResponseDto{

  email: string;
  firstname: string;
  lastname: string;
  birthDay: Date;
  city: string;
  phone: string;

}
