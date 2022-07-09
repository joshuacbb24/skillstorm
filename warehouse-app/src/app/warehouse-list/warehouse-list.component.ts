import { Component, OnInit } from '@angular/core';
import { WarehouseApiService } from '../warehouse-api.service';

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  service :WarehouseApiService;
  warehouses :Array<any> = [];
  //arrayLength :number = 0;

  constructor(service :WarehouseApiService) {
    this.service = service;
   }

  ngOnInit(): void {
    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data;
    })
    //this.arrayLength = this.warehouses.length; 
  }

}
