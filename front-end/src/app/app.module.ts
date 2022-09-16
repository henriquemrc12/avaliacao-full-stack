import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountModule } from './account/account.module';
import { TransfersModule } from './transfers/transfers.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GeneralModalComponent } from './general-modal/general-modal.component';
import { HttpClientModule } from '@angular/common/http';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatDialogModule } from '@angular/material/dialog';
import { NgxMaskModule } from 'ngx-mask';

@NgModule({
  declarations: [
    AppComponent,
    GeneralModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccountModule,
    TransfersModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    NgxMaskModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
