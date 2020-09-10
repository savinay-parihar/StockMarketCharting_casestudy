import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {LoginsuccessComponent} from './loginsuccess/loginsuccess.component';
import { CompaniesComponent } from './companies/companies.component';
import { IposComponent } from './ipos/ipos.component';
import { ExchangesComponent } from './exchanges/exchanges.component';
import { UploadComponent } from './upload/upload.component';
import { CompareCompaniesComponent } from './compare-companies/compare-companies.component';
import { CompareSectorsComponent } from './compare-sectors/compare-sectors.component';
import { IposListComponent } from './ipos-list/ipos-list.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'loginsuccess', component: LoginsuccessComponent},
  {path: 'registration',component: RegistrationComponent},
  {path: 'companies', component: CompaniesComponent},
  {path: 'ipos', component: IposComponent},
  {path:'exchanges', component: ExchangesComponent},
  {path: 'upload', component: UploadComponent},
  {path: 'compareCompanies', component: CompareCompaniesComponent},
  {path: 'compareSectors',component: CompareSectorsComponent},
  {path:'listIpos',component:IposListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
