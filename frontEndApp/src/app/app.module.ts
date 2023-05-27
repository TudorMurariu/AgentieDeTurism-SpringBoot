import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MainAppComponent } from './main-app/main-app.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [ 
    MainAppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [MainAppComponent]
})
export class AppModule { }
