import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { Location } from "@angular/common";
import {Conge} from "../shared/Conge";
import {CongeService} from "../services/conge.service";
import {NgForm} from "@angular/forms";
@Component({
  selector: 'app-modify-conge',
  templateUrl: './modify-conge.component.html',
  styleUrls: ['./modify-conge.component.scss']
})
export class ModifyCongeComponent implements OnInit {
  conge :Conge =new Conge() ;

  constructor( private location: Location,private router:ActivatedRoute, private congeService: CongeService) { }

  ngOnInit(): void {
    this.cleanURL();
    this.router.queryParams.subscribe(params => {
      this.conge= JSON.parse(params["conge"]);
    });

  }
  cleanURL() {

    this.location.replaceState('update');
  }
  onSubmit(f:NgForm){
    this.congeService.updateConge(this.conge.id,f).subscribe(data=>console.log(data))

  }


}
