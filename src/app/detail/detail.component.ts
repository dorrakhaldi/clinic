import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Formation } from '../shared/Formation';
import { Location } from "@angular/common"; 


@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {
  formation:any;
  heurdeb:string="" ;
  heurfin:string="";
  date:string="";

  constructor(private router:ActivatedRoute,  private location: Location) { }

  ngOnInit(): void {
    this.cleanURL();
    this.router.queryParams.subscribe(params => {
      this.formation = JSON.parse(params["formation"]);
    });
    this.date=this.formation.dateDebut.toString().slice(0,10);
    this.heurdeb=this.formation.dateDebut.toString().slice(11,19);
    this.heurfin=this.formation.dateFin.toString().slice(11,19);
  }

  cleanURL() {
      this.location.replaceState('View');
    }
    

}
