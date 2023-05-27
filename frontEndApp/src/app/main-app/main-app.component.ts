import { Component } from '@angular/core';
import { Excursie } from '../interface/excursie';
import { ServiceHttpService } from '../service/service-http.service';

@Component({
  selector: 'app-root',
  templateUrl: './main-app.component.html',
  styleUrls: ['./main-app.component.css']
})
export class MainAppComponent {
    excursii: Excursie[] = [];
    newExcursie: Excursie = new Excursie();

    obiectiv: string = "";
    ora: string = "";
  
    constructor(private excursieService: ServiceHttpService) {
      this.loadExcursii();
    }
  
    loadExcursii() {
      this.excursieService.getAll().subscribe(
        (excursii: Excursie[]) => {
          this.excursii = excursii;
          console.log(excursii);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  
    addExcursie() {
      this.excursieService.createExcursie(this.newExcursie).subscribe(
        () => {
          this.loadExcursii();
          this.newExcursie = new Excursie();
        },
        (error) => {
          console.log(error);
        }
      );
    }
  
    deleteExcursie(id: string) {
      this.excursieService.deleteExcursie(id).subscribe(
        () => {
          this.loadExcursii();
        },
        (error) => {
          console.log(error);
          this.loadExcursii();
        }
      );
    }

    updateExcursie(id: string) {
      this.newExcursie.id = id;
      this.excursieService.updateExcursie(this.newExcursie).subscribe(
        () => {
          this.loadExcursii();
        },
        (error) => {
          console.log(error);
        }
      );
    }

    filterExcursie() {
      if(this.obiectiv.length === 0 && this.ora.length === 0)
        this.loadExcursii();
      else
        this.excursieService.filterExcursie(this.obiectiv, this.ora).subscribe(
          (excursii: Excursie[]) => {
            this.excursii = excursii;
            console.log(excursii);
          },
          (error) => {
            console.log(error);
          }
        );
    }
  }
