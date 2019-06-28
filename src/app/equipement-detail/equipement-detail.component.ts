import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
 
import { Equipement } from '../equipement';
import { EquipementService }  from '../equipement.service';


@Component({
  selector: 'app-equipement-detail',
  templateUrl: './equipement-detail.component.html',
  styleUrls: ['./equipement-detail.component.css']
})
export class EquipementDetailComponent implements OnInit {
  @Input() equipement: Equipement;

  constructor(
    private route: ActivatedRoute,
    private equipementService: EquipementService,
    private location: Location
  ) {}
 
  ngOnInit(): void {
    this.getEquipement();
  }
 
  getEquipement(): void {
    const idEquipement = +this.route.snapshot.paramMap.get('idEquipement');
    this.equipementService.getEquipement(idEquipement)
      .subscribe(equipement => this.equipement = equipement);
  }
 
  goBack(): void {
    this.location.back();
  }
 
 save(): void {
    this.equipementService.updateEquipement(this.equipement)
      .subscribe(() => this.goBack());
  }
}

