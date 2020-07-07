import { Injectable } from '@angular/core';
import {
  EventTypes,
  LogLevel,
  OidcConfigService,
  OidcSecurityService,
  PublicEventsService
} from "angular-auth-oidc-client";
import {filter, map} from "rxjs/operators";
import {Observable} from "rxjs";
import {AuthUserModel} from './models/AuthUserModel';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {StudentDetails} from "../common/models/StudentDetails";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  userData: AuthUserModel;
  isAuthenticated: boolean;
  apiUrl: string = environment.apiUrl + 'api/';

  constructor(public oidcSecurityService: OidcSecurityService,
              private readonly eventService: PublicEventsService,
              private http: HttpClient) {

    this.eventService
      .registerForEvents()
      .pipe(filter((notification) => notification.type === EventTypes.ConfigLoaded))
      .subscribe((config) => {
        console.log('ConfigLoaded', config);
      });

  }

  public checkAuth(): Observable<any> {
    return this.oidcSecurityService.checkAuth().pipe(map((isAuthenticated) => {
      console.log('app authenticated', isAuthenticated);
      this.isAuthenticated = isAuthenticated;
      if (!this.userData) {
        this.initializeUserData();
      }
      return isAuthenticated;
    }));
  }

  public initializeUserData() {
    const tokenData = this.oidcSecurityService.getPayloadFromIdToken();
    this.userData = {
      email: tokenData.email,
      name: tokenData.given_name,
      surname: tokenData.family_name,
      groups: tokenData.groups
    };
  }

  public getUserData() {
    return this.userData;
  }

  login() {
    this.oidcSecurityService.authorize();
  }

  logout() {
    this.oidcSecurityService.logoff();
  }

  getToken() {
    // this.oidcSecurityService.authorize();
    return this.oidcSecurityService.getToken();
  }

  getCurrentStudentDetails(): Observable<StudentDetails> {
    return this.http.get<StudentDetails>(this.apiUrl + 'students/me');
  }
}




export function configureAuth(oidcConfigService: OidcConfigService) {
  return () =>
    oidcConfigService.withConfig({
      stsServer: 'http://localhost:8095/auth/realms/master',
      redirectUrl: window.location.origin,
      postLogoutRedirectUri: window.location.origin,
      unauthorizedRoute: 'login',
      clientId: 'uiPlatformClient',
      scope: 'openid profile email offline_access',
      responseType: 'code',
      silentRenew: true,
      useRefreshToken: true,
      ignoreNonceAfterRefresh: true,
      // silentRenewUrl: `${window.location.origin}`,
      logLevel: LogLevel.Debug,
      autoUserinfo: true
    });
}
