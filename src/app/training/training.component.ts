import { Component, OnInit, ViewChild,ElementRef } from '@angular/core'
import{BackendApiFormationService} from "../services/backend-api-formation.service";
import {jsPDF} from "jspdf";
import * as XLSX from 'xlsx';
import { Formation } from '../shared/Formation';
import { Router ,NavigationExtras} from '@angular/router';
import { query } from '@angular/animations';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.scss']
})
export class TrainingComponent implements OnInit {

  @ViewChild('TABLE', { static: false }) tabletow!: ElementRef;  
  p:number=1; 
  fileName= 'formation.xlsx';  

  formationlist =Array<Formation> () ;
  index:number=0;
  firstname:string="" ;
  constructor( private formationservice:BackendApiFormationService ,  private router:Router) {
  }

  ngOnInit(): void {
    this.formationservice.getallFormation().subscribe(resultat =>{
      this.formationlist =resultat ;})
  }
  
  pdf(){
    const doc=new jsPDF('p','pt','a2');
    doc.html(this.tabletow.nativeElement,{
      callback: (pdf)=>{
        pdf.save("formation.pdf");
      }
    });
  }

    onExcel(){
      let element=document.getElementById("tabletow");
      const wb:XLSX.WorkBook=XLSX.utils.book_new();
      const ws:XLSX.WorkSheet=XLSX.utils.table_to_sheet(element);
      XLSX.utils.book_append_sheet(wb,ws,"Sheet1");
     XLSX.writeFile(wb,this.fileName);
    }
    onUpdate(formation:Formation , id:number){
     // this.router.navigate(["../update"], { queryParams: formation, skipLocationChange: true});
       let navigationExtras: NavigationExtras = {
        queryParams: {
            "formation": JSON.stringify(formation),
            skipLocationChange:true
        }  
      };
  
       this.router.navigate(["../update"],navigationExtras ,); 
    }
    onDelete(formation:Formation){
      this.formationservice.deleteFormation(formation);
      
    }
    onView(formation:Formation){
        
      let navigationExtras: NavigationExtras = {
        queryParams: {
            "formation": JSON.stringify(formation)
        }
      };
  
       this.router.navigate(["../detail"],navigationExtras); 
    }
    Search(){
      if(this.firstname!="")
      this.formationlist =this.formationlist .filter(res=>{

        return res.nom.toLocaleLowerCase().match(this.firstname.toLocaleLowerCase())
        console.log(this.formationlist );
      })
    else if(this.firstname=="")
    {
      this.ngOnInit();
    }
  }

}
