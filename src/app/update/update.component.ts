import { Component, OnInit } from '@angular/core';
import { Formation } from '../shared/Formation';
import{BackendApiFormationService} from '../services/backend-api-formation.service'
import { FormControl,FormGroup,} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import { Location } from "@angular/common"; 



@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  formation : Formation=new Formation() ;
  value :any="" ;
  disabled:boolean=false ;
  formation_to_update :any  ;
  indicator:string ="";





  constructor(   private location: Location,private formationservice:BackendApiFormationService ,private router:ActivatedRoute) {     }


  ngOnInit(): void {
    this.cleanURL();
    this.router.queryParams.subscribe(params => {
      this. formation_to_update= JSON.parse(params["formation"]);
    });

  }



  cleanURL() {
    // Use this method where its needed.
      this.location.replaceState('update');
    }
    
  

  onupdate()
  {
    let test_date=(new Date(this.formation_to_update.dateDebut).getTime().valueOf() > new Date(this.formation_to_update.dateFin).getTime().valueOf());
    if(this.formation_to_update.dateDebut==undefined ||this.formation_to_update.dateFin==undefined || test_date==true)
    {
      alert("verifer que  les fields date fin  et debut sont remplie  et que  date fin et plus grande que celle debut") ;
      return ;
    }
    else if (this.formation_to_update.domaine.length <2 || this.formation_to_update.nom.length <2 ||typeof JSON.parse(this.formation_to_update.etatFormation).toString()==="boolean" )
    {
      alert("les champs domaine et nom doit contenir plusque 2 carcters ") ;
      alert(typeof this.formation_to_update.etatFormation);
      return ;
    }
    else {
      this.formationservice.updateFormation(this.formation_to_update,this.formation_to_update.id);
    }
  }

}
