import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TrainingComponent } from './training/training.component';
import { RegistreComponent } from './registre/registre.component';
import { DetailComponent } from './detail/detail.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatButtonModule} from '@angular/material/button';
import { MatMomentDateModule } from "@angular/material-moment-adapter";
import { SidenavComponent } from './sidenav/sidenav.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatDividerModule} from '@angular/material/divider';
import { HttpClientModule } from '@angular/common/http';
import { EmployeeComponent } from './employee/employee.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { NgxPaginationModule } from 'ngx-pagination';
import {MatPaginatorModule} from "@angular/material/paginator";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {OwlDateTimeModule, OwlNativeDateTimeModule} from "ng-pick-datetime";
import {DateTimePickerModule} from "@syncfusion/ej2-angular-calendars";
import { CongeComponent } from './conge/conge.component';
import { DemandeComponent } from './demande/demande.component';
import { ModifyCongeComponent } from './modify-conge/modify-conge.component';
import { DetailCongeComponent } from './detail-conge/detail-conge.component';
import { UpdateComponent } from './update/update.component';


@NgModule({
  declarations: [
    AppComponent,
    TrainingComponent,
    RegistreComponent,
    DetailComponent,
    SidenavComponent,
    EmployeeComponent,
    CongeComponent,
    DemandeComponent,
    ModifyCongeComponent,
    DetailCongeComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatIconModule,
    FormsModule,
    MatDatepickerModule,
    MatButtonModule,
    MatMomentDateModule,
    MatToolbarModule,
    MatSidenavModule,
    MatDividerModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MatPaginatorModule,
    Ng2SearchPipeModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    DateTimePickerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
