import { Component, OnInit} from '@angular/core';
import { Formation } from '../shared/Formation';
import{BackendApiFormationService} from '../services/backend-api-formation.service'
import { ActivatedRoute} from '@angular/router';




@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.scss']
})
export class RegistreComponent implements OnInit {
  formation : Formation=new Formation() ;

  constructor(   private formationservice:BackendApiFormationService ,private router:ActivatedRoute) {}




  ngOnInit(): void {}


  onAdd()
  {
    let test_date=(new Date(this.formation.dateDebut).getTime().valueOf() > new Date(this.formation.dateFin).getTime().valueOf());
    if(this.formation.dateDebut==undefined ||this.formation.dateFin==undefined || test_date==true)
    {
      alert("verifer que  les fields date fin  et debut sont remplie  et que  date fin et plus grande que celle debut") ;
      return ;
    }
    else if (this.formation.domaine.length <2 || this.formation.nom.length <2 ||typeof JSON.parse(this.formation.etatFormation).toString()==="boolean" )
    {
      alert("les champs domaine et nom doit contenir plusque 2 carcters ") ;
      alert(typeof this.formation.etatFormation);
      return ;
    }
    else {
      this.formationservice.create(this.formation) ;
    }
  }

}
