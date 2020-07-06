import { Component } from '@angular/core';
import {AuthenticationService} from "./authentication/authentication.service";
import {OidcSecurityService} from "angular-auth-oidc-client";
import {AuthUserModel} from "./authentication/models/AuthUserModel";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'students-web-frontend';
  userData: AuthUserModel;

  constructor(private authenticatedService: AuthenticationService) {
  }



  ngOnInit(): void {
    this.authenticatedService.checkAuth().subscribe(isAuthenticated => {
      if (isAuthenticated) {
        this.userData = this.authenticatedService.getUserData();
      }
    });
  }
}
