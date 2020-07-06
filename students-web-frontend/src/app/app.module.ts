import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AuthModule, OidcConfigService} from "angular-auth-oidc-client";
import {configureAuth} from "./authentication/authentication.service";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {AuthInterceptor} from "./authentication/auth.interceptor";
import { LoginComponent } from './authentication/login/login.component';
import { MainApplicationComponent } from './home/main-application/main-application.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { HomePageComponent } from './home/home-page/home-page.component';
import { StudentPageComponent } from './student/student-page/student-page.component';
import { RequestPageComponent } from './applications/request/request-page/request-page.component';
import { EmployeeCatalogPageComponent } from './applications/employee-catalog/employee-catalog-page/employee-catalog-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainApplicationComponent,
    NavbarComponent,
    HomePageComponent,
    StudentPageComponent,
    RequestPageComponent,
    EmployeeCatalogPageComponent
  ],
  imports: [
    AuthModule.forRoot(),
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule
  ],
  providers: [
    OidcConfigService,
    {
      provide: APP_INITIALIZER,
      useFactory: configureAuth,
      deps: [OidcConfigService, HttpClient],
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
