import { Component, OnInit } from '@angular/core';
import {Equipement} from '../equipement';
import { EquipementService } from '../equipement.service';

@Component({
  selector: 'app-equipements',
  templateUrl: './equipements.component.html',
  styleUrls: ['./equipements.component.css']
})
export class EquipementsComponent implements OnInit {
  equipements: Equipement[];
 
  constructor(private equipementService: EquipementService) { }
 
  ngOnInit() {
    this.getEquipements();
  }
 
  getEquipements(): void {
    this.equipementService.getEquipements()
        .subscribe(equipements => this.equipements = equipements);
  }

  
  add(nameEquipement: string): void {
    nameEquipement = nameEquipement.trim();
    if (!nameEquipement) { return; }
    this.equipementService.addEquipement({ nameEquipement } as Equipement)
      .subscribe(equipement => {
        this.equipements.push(equipement);
      });
  }
 
  delete(equipement: Equipement): void {
    this.equipements = this.equipements.filter(h => h !== equipement);
    this.equipementService.deleteEquipement(equipement).subscribe();
  }
}
