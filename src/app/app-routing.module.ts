import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegistreComponent} from './registre/registre.component';
import {EmployeeComponent} from "./employee/employee.component";
import {CongeComponent} from "./conge/conge.component";
import {DemandeComponent} from "./demande/demande.component";
import {ModifyCongeComponent} from "./modify-conge/modify-conge.component";
import {DetailCongeComponent} from "./detail-conge/detail-conge.component";
import {DetailComponent} from "./detail/detail.component";
import {TrainingComponent} from "./training/training.component";
import {UpdateComponent} from "./update/update.component";

const routes: Routes = [
  { path : "",component:RegistreComponent },
  { path : 'employee',component:EmployeeComponent },
  {path : 'conge', component:CongeComponent},
  {path : 'demande', component:DemandeComponent},
  {path : 'updateConge', component:ModifyCongeComponent},
  {path: 'detailConge', component:DetailCongeComponent},
  {path:"detail",  component:DetailComponent} ,
  {path:"formation",  component:TrainingComponent},
  {path:"update" , component:UpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
