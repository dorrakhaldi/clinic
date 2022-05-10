import { Component, OnInit } from '@angular/core';
import {Employee} from "../employee/employee.component";
import {Conge} from "../shared/Conge";
import {CongeService} from "../services/conge.service";
import { Router ,NavigationExtras} from '@angular/router';
import {jsPDF} from "jspdf";
import * as XLSX from 'xlsx'
import { ViewChild,ElementRef } from '@angular/core'

@Component({
  selector: 'app-conge',
  templateUrl: './conge.component.html',
  styleUrls: ['./conge.component.scss']
})
export class CongeComponent implements OnInit {
  @ViewChild('TABLE', { static: false }) excel_table!: ElementRef;
  fileName= 'conge.xlsx';
  public conges:Conge[]=[];
  public congeId: number=1;
 

  constructor(private congeService: CongeService, private router: Router) { }

  ngOnInit(): void {
    this.getCongesFromserv()
  }
  getCongesFromserv(){
    this.congeService.getConges().subscribe(
      response => {
        console.log(response);
        this.conges = response;
      }
    );
  }
  openFormulaire(){
    this.router.navigate(['demande'])
  }
  deleteConge(congeId: number){
    this.congeService.deleteConge(congeId).subscribe(data=>{console.log(data)})
  }
  updateConge(conge:Conge){
    let navigationExtras: NavigationExtras = {
      queryParams: {
        "conge": JSON.stringify(conge),
        skipLocationChange:true
      }
    };

    this.router.navigate(["../updateConge"],navigationExtras );
  }
  detailConge(conge:Conge){
    let navigationExtras: NavigationExtras = {
      queryParams: {
        "conge": JSON.stringify(conge),
        skipLocationChange:true
      }
    };

    this.router.navigate(["../detailConge"],navigationExtras );
    
  }
  pdf(){
    const doc=new jsPDF('p','pt','a2');
    doc.html(this.excel_table.nativeElement,{
      callback: (pdf)=>{
        pdf.save("conge.pdf");
      }
    });
  }
  onExcel(){
    let element=document.getElementById("excel_table");
    const wb:XLSX.WorkBook=XLSX.utils.book_new();
    const ws:XLSX.WorkSheet=XLSX.utils.table_to_sheet(element);
    XLSX.utils.book_append_sheet(wb,ws,"Sheet1");
    XLSX.writeFile(wb,this.fileName);
  }
  




}
