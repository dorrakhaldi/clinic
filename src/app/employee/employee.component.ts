import { Component, OnInit } from '@angular/core';

import {Timestamp} from "rxjs";
import {EmployeeService} from "../services/employee.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import * as XLSX from 'xlsx';
import {FormBuilder, FormGroup, NgForm} from "@angular/forms";
export class Employee {
  constructor(
    public id:number,
    public nom: string,
    public prenom: string,
    public cin: string,
    public  email:string,
    public password :string,
    public phoneNumber:string ,
    public emailConfirmed:boolean ,
    public dateNaissance:Timestamp<any>,
    public  adresse :string,
    public  gender :string,
    public  dateEmploi :Timestamp<any>,
    public  matricule :string,
    public  etatCompte :boolean,
    public  role:string,
  ) {

  }}

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  public closeResult!: string;
  public Employees: Employee[] = [];
  page = 1;
  count = 0;
  tableSize = 5;
  tableSizes = [3,6, 9, 12];
  gender!: string;
  fileName= 'ExcelSheet.xlsx';
   deleteId !: number;
  EditId !: number;
  role !: string;
  editForm!: FormGroup;
  data !: string;
  ACTIF !: boolean;
 public  emp !: Employee;
  dateNaissance!: any;



  constructor( private modalService: NgbModal ,  private service :EmployeeService,private fb: FormBuilder  ) {
 }

  ngOnInit(): void {
    this. getEmployesFromserv(),
      this.editForm = this.fb.group({
        id:[''],
        nom: [''],
        prenom: [''],
        cin:  [''],
       email: [''],
       phoneNumber: [''],
       emailConfirmed: [''],
      dateNaissance: [''],
        adresse : [''],
        gender : [''],
     dateEmploi : [''],
      matricule : [''],
       etatCompte : [''],
        role: [''],
      });
  }

  getEmployesFromserv(){
    this.service.getEmployes().subscribe(
      response => {
        console.log(response);
        this.Employees = response;
      }
    );
  }


  open(content: any) {

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then(result => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${EmployeeComponent.getDismissReason(reason)}`;
    });
  }

  private static getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  onSubmit(f: NgForm) {
    console.log(f.value.dateNaissance);
    this.service.createemployee(f)
    .subscribe(() => {
      this.ngOnInit(); //reload table
    });
    this.modalService.dismissAll();
  }

  openDelete(targetModal: any,emp:Employee) {
    this.deleteId = emp.id;
    this.modalService.open(targetModal, {
      backdrop: 'static',
      size: 'lg'
    });
    this.deleteId=emp.id;
  }

  onDelete() {
    this.service.deleteemployee(this.deleteId)
    .subscribe(() => {
      this.ngOnInit();
      this.modalService.dismissAll();

    });

  }
  openDetails(targetModal:any, emp:Employee) {
    this.EditId=emp.id;
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });

    this.editForm.patchValue({
      id:emp.id,
      nom: emp.nom,
      prenom: emp.prenom,
      cin:  emp.cin,
      email: emp.email,
      phoneNumber: emp.phoneNumber,
      emailConfirmed: emp.emailConfirmed,
      dateNaissance: emp.dateNaissance,
      adresse : emp.adresse,
      gender :emp.gender,
      dateEmploi : emp.dateEmploi,
      matricule : emp.matricule,
      etatCompte : emp.etatCompte,
      role: emp.role
   });


}
  onSave() {
    //this.editForm.value.dateNaissance= this.editForm.value.dateNaissance.getTime()/1000;
    console.log(this.editForm.value);
    this.service.editemployee(this.editForm, this.EditId)
    .subscribe(() => {
      this.ngOnInit();
      this.modalService.dismissAll();
    });
  }

  public openPDF():void {
    let DATA = document.getElementById('excel-table');

    html2canvas(<HTMLElement>DATA).then(canvas => {

      let fileWidth = 208;
      let fileHeight = canvas.height * fileWidth / canvas.width;
      const FILEURI = canvas.toDataURL('image/png')
      let PDF = new jsPDF('p', 'mm', 'a4');
      let position = 0;
      PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight)

      PDF.save('angular-demo.pdf');
    });
  }


  exportexcel(): void
  {
    /* table id is passed over here */
    var element = document.getElementById('excel-table');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);

    /* generate workbook and add the worksheet */
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileName);

  }






  onTableDataChange(event:any){
    this.page = event;
    this.getEmployesFromserv();
  }

  onTableSizeChange(event:any): void {
    this.tableSize = event.target.value;
    this.page = 1;
    this.getEmployesFromserv();
  }

}

