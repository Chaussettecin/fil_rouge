import { Component, OnInit } from '@angular/core';
import {Ennemi} from '../ennemi';
import { EnnemiService } from '../ennemi.service';

@Component({
  selector: 'app-ennemis',
  templateUrl: './ennemis.component.html',
  styleUrls: ['./ennemis.component.css']
})
export class EnnemisComponent implements OnInit {
  ennemis: Ennemi[];
 
  constructor(private ennemiService: EnnemiService) { }
 
  ngOnInit() {
    this.getEnnemis();
  }
  
  getEnnemis(): void {
    this.ennemiService.getEnnemis()
        .subscribe(ennemis => this.ennemis = ennemis);
  }

  
  add(nameEnnemi: string): void {
    nameEnnemi = nameEnnemi.trim();
    if (!nameEnnemi) { return; }
    this.ennemiService.addEnnemi({ nameEnnemi } as Ennemi)
      .subscribe(ennemi => {
        this.ennemis.push(ennemi);
      });
  }
 
  delete(ennemi: Ennemi): void {
    this.ennemis = this.ennemis.filter(h => h !== ennemi);
    this.ennemiService.deleteEnnemi(ennemi).subscribe();
  }
}

