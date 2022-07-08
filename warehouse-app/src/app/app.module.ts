import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { InventoryListComponent } from './inventory-list/inventory-list.component';
import { FindInventoryComponent } from './find-inventory/find-inventory.component';
import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';
import { CreateItemComponent } from './create-item/create-item.component';
import { FilterInventoryComponent } from './filter-inventory/filter-inventory.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    InventoryListComponent,
    FindInventoryComponent,
    WarehouseListComponent,
    CreateItemComponent,
    FilterInventoryComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
