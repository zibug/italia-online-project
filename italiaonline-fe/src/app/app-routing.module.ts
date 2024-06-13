import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticoliContainerComponent } from './components/articoli-container/articoli-container.component';
import { ArticoliMongodbComponent } from './components/articoli-mongodb/articoli-mongodb.component';
import { ArticoliInsertComponent } from './components/articoli-insert/articoli-insert.component';

const routes: Routes = [
  {
    path: '',
    component: ArticoliContainerComponent
  },
  {
    path: 'mongodb',
    component: ArticoliMongodbComponent
  },
  {
    path: 'insert',
    component: ArticoliInsertComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
