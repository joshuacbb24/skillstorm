import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { InventoryListComponent } from './inventory-list/inventory-list.component';
import { FindInventoryComponent } from './find-inventory/find-inventory.component';
import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    SidebarComponent,
    InventoryListComponent,
    FindInventoryComponent,
    WarehouseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
