import { Component, OnInit } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';


@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.css']
})
export class InventoryListComponent implements OnInit {

  
  service :WarehouseApiService;
  inventory :Array<any> = [];
  item :any = {}


  constructor(service :WarehouseApiService) {
    this.service = service;
  }


  ngOnInit(): void {
    this.service.getInventory().subscribe(data => {
      this.inventory = data
      console.log(this.inventory)
    });
  }

}
