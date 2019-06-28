import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
 
import { Quete } from '../quete';
import { QueteService }  from '../quete.service';

@Component({
  selector: 'app-quete-detail',
  templateUrl: './quete-detail.component.html',
  styleUrls: ['./quete-detail.component.css']
})
export class QueteDetailComponent implements OnInit {
  @Input() quete: Quete;

  constructor(
    private route: ActivatedRoute,
    private queteService: QueteService,
    private location: Location
  ) {}
 
  ngOnInit(): void {
    this.getQuete();
  }
 
  getQuete(): void {
    const idQuete = +this.route.snapshot.paramMap.get('idQuete');
    this.queteService.getQuete(idQuete)
      .subscribe(quete => this.quete = quete);
  }
 
  goBack(): void {
    this.location.back();
  }
  
  save(): void {
    this.queteService.updateQuete(this.quete)
      .subscribe(() => this.goBack());
  }
}

