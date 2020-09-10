import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {LoginsuccessComponent} from './loginsuccess/loginsuccess.component';
import { CompaniesComponent } from './companies/companies.component';
import { CompareCompaniesComponent } from './compare-companies/compare-companies.component';
import { CompareSectorsComponent } from './compare-sectors/compare-sectors.component';
import { ExchangesComponent } from './exchanges/exchanges.component';
import { IposComponent } from './ipos/ipos.component';
import { MenuComponent } from './menu/menu.component';
import { UploadComponent } from './upload/upload.component';
import { ServicesComponent } from './services/services.component';
import { IposListComponent } from './ipos-list/ipos-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    LoginsuccessComponent,
    CompaniesComponent,
    CompareCompaniesComponent,
    CompareSectorsComponent,
    ExchangesComponent,
    IposComponent,
    MenuComponent,
    UploadComponent,
    ServicesComponent,
    IposListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
