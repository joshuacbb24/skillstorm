import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';
import { WarehouseListComponent } from '../warehouse-list/warehouse-list.component';
import {MatSort} from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

export interface WarehouseData {
  id: string;
  name: string;
  companyId: string;
  capacity: string;
  stock: string;
  favorited: any;
}

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.css']
})
export class InventoryListComponent implements OnInit {

  
  service :WarehouseApiService;
  inventory :Array<any> = [];
  item :any = {};
  quantity :number = 1;
  warehouses :Array<any> = [];
  date :String = (new Date()).toISOString().split('T')[0];
  exceeds :Boolean = false;
  isCreateFormHidden :Boolean = true;
  isEditFormHidden :Boolean = true;
  modalHidden :Boolean = true;
  warehouseId :number = 0;
  
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  constructor(service :WarehouseApiService) {
    this.service = service;
  }
  revealEditForm(event :any, b :Boolean): void {
    if (b)
    {
      this.warehouseId = event.target.getAttribute("data-warehouse-id");
    }
    this.modalHidden = !this.modalHidden;
    this.isEditFormHidden = !this.isEditFormHidden;

  }
  revealCreateForm(): void {
    this.modalHidden = !this.modalHidden;
    this.isCreateFormHidden = !this.isCreateFormHidden;
  }
  handleSelect(): void{

  }
  closeForm(): void {

  }
  ngOnInit(): void {
    this.service.getInventory().subscribe(data => {
      this.inventory = data
      console.log(this.inventory)
    });

    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data;
    })
  }

}
