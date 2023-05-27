export class Excursie {
    id: string;
    obiectivTuristic: string;
    numeCompanieTurism: string;
    oraPlecarii: string;
    pret: number;
    numarLocuriDisponibile: number;
  
    constructor(
      id: string = '',
      obiectivTuristic: string = '',
      numeCompanieTurism: string = '',
      oraPlecarii: string = '',
      pret: number = 0,
      numarLocuriDisponibile: number = 0
    ) 
    {
      this.id = id;
      this.obiectivTuristic = obiectivTuristic;
      this.numeCompanieTurism = numeCompanieTurism;
      this.oraPlecarii = oraPlecarii;
      this.pret = pret;
      this.numarLocuriDisponibile = numarLocuriDisponibile;
    }


}
  