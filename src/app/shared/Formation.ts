export class Formation {
  id :any  ;
  nom :string="" ;
  dateDebut:any;
  dateFin:any ;
  domaine:string ="" ;
  nbPlaceDisponible:any   ;
  nomSalle:string  ="" ;
  etatFormation:any ;


  Formation(nom :string  ,formerName :string  ,  dateDebut:any, dateFin:any, domaine:string ,  nbPlaceDisponible: number,nomSalle:string, etatFormation:boolean  , id: number )
  {
    this.id=id;
    this.nom=nom ;
    this.dateDebut=dateDebut ;
    this.dateFin=dateFin ;
    this.domaine=domaine ;
    this.nbPlaceDisponible=nbPlaceDisponible ;
    this.nomSalle=nomSalle ;
    this.etatFormation=etatFormation ;

  }

}
