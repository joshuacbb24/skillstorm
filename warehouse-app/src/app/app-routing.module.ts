import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeContentComponent } from './home-content/home-content.component';
import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';

const routes: Routes = [
  {path: '', component: HomeContentComponent},
  {path: 'warehouses', component: WarehouseListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
