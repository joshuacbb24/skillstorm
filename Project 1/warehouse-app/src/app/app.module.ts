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
import {HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeContentComponent } from './home-content/home-content.component';
import {MatTableModule} from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    InventoryListComponent,
    FindInventoryComponent,
    WarehouseListComponent,
    CreateItemComponent,
    FilterInventoryComponent,
    NavbarComponent,
    HomeContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
