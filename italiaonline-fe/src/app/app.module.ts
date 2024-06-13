import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatToolbarModule} from '@angular/material/toolbar';
import { ArticoliTableComponent } from './components/articoli-table/articoli-table.component';
import { ArticoliContainerComponent } from './components/articoli-container/articoli-container.component';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { ArticoliMongodbComponent } from './components/articoli-mongodb/articoli-mongodb.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ArticoliInsertComponent } from './components/articoli-insert/articoli-insert.component';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSnackBarAction, MatSnackBarActions, MatSnackBarModule} from '@angular/material/snack-bar';
import {MatButtonModule} from '@angular/material/button';
import { SnackBarComponent } from './common/snack-bar/snack-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticoliTableComponent,
    ArticoliContainerComponent,
    ArticoliMongodbComponent,
    NavbarComponent,
    ArticoliInsertComponent,
    SnackBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    HttpClientModule,
    MatTableModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSnackBarModule,
    MatSnackBarAction,
    MatSnackBarActions,
    MatButtonModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
