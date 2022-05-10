import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from "@angular/common";
import {Conge} from "../shared/Conge";
import {CongeService} from "../services/conge.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-detail-conge',
  templateUrl: './detail-conge.component.html',
  styleUrls: ['./detail-conge.component.scss']
})
export class DetailCongeComponent implements OnInit {
  conge:Conge=new Conge();

  constructor(private activatedRouter:ActivatedRoute, private router: Router , private location: Location,
    private congeService: CongeService) { }

  ngOnInit(): void {
    this.cleanURL();
    this.activatedRouter.queryParams.subscribe(params => {
      this.conge = JSON.parse(params["conge"]);
    });
  }
  acceptConge(congeId: number){
    console.log(congeId)
    this.congeService.acceptConge(congeId).subscribe(data=>{console.log(data)})
    this.router.navigate(["../conge"])
  }
  refuseConge(congeId: number){
    console.log(congeId)
    this.congeService.refuseConge(congeId).subscribe(data=>{console.log(data)})
    this.router.navigate(["../conge"])
  }
 
  cleanURL() {
    // Use this method where its needed.
    this.location.replaceState('detail');
  }

}
