import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';
 
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';
 
import { AppRoutingModule }     from './app-routing.module'; 

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PersonnagesComponent } from './personnages/personnages.component';
import { ComptesComponent } from './comptes/comptes.component';
import { EnnemisComponent } from './ennemis/ennemis.component';
import { EquipementsComponent } from './equipements/equipements.component';
import { QuetesComponent } from './quetes/quetes.component';
import { CompteDetailComponent } from './compte-detail/compte-detail.component';
import { PersonnageDetailComponent } from './personnage-detail/personnage-detail.component';
import { EnnemiDetailComponent } from './ennemi-detail/ennemi-detail.component';
import { EquipementDetailComponent } from './equipement-detail/equipement-detail.component';
import { QueteDetailComponent } from './quete-detail/quete-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { CompteSearchComponent } from './compte-search/compte-search.component';
import { PersonnageSearchComponent } from './personnage-search/personnage-search.component';
import { EnnemiSearchComponent } from './ennemi-search/ennemi-search.component';
import { EquipementSearchComponent } from './equipement-search/equipement-search.component';
import { QueteSearchComponent } from './quete-search/quete-search.component';
import { ListeCompteComponent } from './liste-compte/liste-compte.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false })
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    PersonnagesComponent,
    ComptesComponent,
    EnnemisComponent,
    EquipementsComponent,
    QuetesComponent,
    CompteDetailComponent,
    PersonnageDetailComponent,
    EnnemiDetailComponent,
    EquipementDetailComponent,
    QueteDetailComponent,
    MessagesComponent,
    CompteSearchComponent,
    PersonnageSearchComponent,
    EnnemiSearchComponent,
    EquipementSearchComponent,
    QueteSearchComponent,
    ListeCompteComponent    
  ],  
  bootstrap: [AppComponent]
})
export class AppModule { }

