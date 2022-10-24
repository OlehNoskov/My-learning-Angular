import { Injectable } from "@angular/core";

// Via HttpClient we can work with server
import { HttpClient } from "@angular/common/http";

@Injectable({
  // Auto registered in root module
  providedIn: 'root'
})

// Service in Angular - it's abstract layer, which works with concrete object.
// Here we do to request to server to receive data or send their to server.
export class UserService {
  constructor(private http: HttpClient) {
  }

  getAllUsers(){
    return this.http.get("http://localhost:8080/users")
  }
}
