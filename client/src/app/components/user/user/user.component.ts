import { Component, Input } from '@angular/core';
import { User } from "../../../model/user/model/user";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  // Decorator, if Property 'users' has no initializer and is not definitely assigned in the constructor - >
  // change noPropertyAccessFromIndexSignature in tsconfing.json on false
  // and add field "strictPropertyInitialization": false.
  @Input() users: User;
}
